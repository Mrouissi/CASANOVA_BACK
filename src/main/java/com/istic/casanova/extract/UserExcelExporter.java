package com.istic.casanova.extract;

import com.istic.casanova.model.Client;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Client> listClients;

    public UserExcelExporter(List<Client> listClients) {
        this.listClients= listClients ;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Client");
    }

    private void writeHeaderRow(){
        Row row = sheet.createRow(0);
        Cell cell= row.createCell(0);
        cell.setCellValue("NOM");

        cell= row.createCell(1);
        cell.setCellValue("PRENOM");



    }
    private void writeDataRows() {
        int rowCount=1;
        for (Client client : listClients){
            Row row = sheet.createRow(rowCount);

            Cell cell = row.createCell(0);
            cell.setCellValue(client.getNom());

            cell = row.createCell(1);
            cell.setCellValue(client.getPrenom());

        }

    }
    public void export(HttpServletResponse response) throws IOException {

        writeDataRows();
        writeHeaderRow();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }
}
