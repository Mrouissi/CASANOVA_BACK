package com.istic.casanova.extract;

import com.istic.casanova.model.Client;
import com.istic.casanova.model.Dossier;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.formula.FormulaType;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
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

        List<String> headers = Arrays.asList("NOM","PRENOM","ADRESSE","CP","DPT","VILLE","TEL","MOB","EMAIL","AGENCE","Entité","N°bdc","DATE CDE","MOIS",
                "DATE REC","MOIS", "ORIGINE","PERIODE", "DEROG","VEND 1","%","CAHT","VEND 2","%","CAHT","VEND 3","%","CAHT","Mode régl","CA HT",
                "CA TTC","% acpte","Acompte","Date encaiss","Mois",	"Début","Réception","Réception M+1","Réception M+2","Réception M+3", "Solde",
                "Type travaux",	"Elément à rénover","Type de matériaux/support existant","Prestation à réaliser", "Coul/matériau mis en place",
                "Surface/taille","Remise",	"tx Rem",	"net",	"brut"	,"verif caht","","mt financé","date offre",	"durée", "taux","coût vendeur",
                "date env préacc mail","Délai en cours","date env phys",	"Délai en cours",	"ACC def reçue", "DATE FIN DE CHANTIER","Date prise solde",
                "Délai en cours",	"Retard constaté","Facturé","Date facture",	"Mois","Acompte","Début", "Réception","Réception M+1","Réception M+2","Réception M+3","Solde");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(8);
        font.setFontName("Arial");
        style.setFont(font);

        for(int i = 0; i < headers.size() ; i++){

           row.createCell(i).setCellValue(headers.get(i));
           row.getCell(i).setCellStyle(style);
        }

    }
    private void writeDataRows() {

        int rowCount=1;
        for (Client client : listClients){
            Row row = sheet.createRow(rowCount);
            row.createCell(0).setCellValue(client.getNom());
            row.createCell(1).setCellValue(client.getPrenom());
            row.createCell(2).setCellValue(client.getAdresse());
            row.createCell(3).setCellValue(client.getCode_postal());
            row.createCell(4).setCellValue(client.getDpt());
            row.createCell(5).setCellValue(client.getVille());
            row.createCell(6).setCellValue(client.getTel_fixe());
            row.createCell(7).setCellValue(client.getTel_portable());
            row.createCell(8).setCellValue(client.getEmail());

            List<Dossier> dossiers= client.getDossiers();
            for(Dossier dossier : dossiers){
                row.createCell(9).setCellValue(dossier.getAgence());
                row.createCell(10).setCellValue(dossier.getEntite_vente());
                row.createCell(11).setCellValue(dossier.getNum_bon());
                row.createCell(12).setCellValue(dossier.getDate_commande());
                //row.createCell(13).setCellFormula("IF(M3=,M3)");
                row.createCell(14).setCellValue(dossier.getDate_reception());
                //row.createCell(15).setCellFormula();
                row.createCell(16).setCellValue(dossier.getOrganisme()); // verifier origine
                //row.createCell(17).setCellValue(dossier.g)// comment periode est rempli?
                // row.createCell(18).setCellValue(); rempli manuellement
                row.createCell(19).setCellValue(dossier.getVendeur1());
                row.createCell(20).setCellValue(dossier.getPct_vendeur1());
                //row.createCell(21).setCellFormula(); pour calculer le chiffre d'affaire
                row.createCell(22).setCellValue(dossier.getVendeur2());
                row.createCell(23).setCellValue(dossier.getPct_vendeur2());
                //row.createCell(24).setCellFormula(); pour calculer le chiffre d'affaire
                row.createCell(25).setCellValue(dossier.getVendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                //row.createCell(27).setCellFormula(); pour calculer le chiffre d'affaire
                //row.createCell(28).setCellValue(dossier.getmodereglement); créer le champ mode de règlement
                //row.createCell(29).setCellFormula(CA);
                //row.createCell(30).setCellFormula(CATTC);
                //row.createCell(31).setCellFormula(%acompte);
                row.createCell(32).setCellValue(dossier.getMontant_acompte());
                row.createCell(33).setCellValue(dossier.getDate_encaissement());
                //row.createCell(34).setFormula(mois);
                //row.createCell(35).setCellValue(début);
                //row.createCell(36).setCellValue(dossier.reception);
                //row.createCell(37).setCellValue(M+1);
                //row.createCell(38).setCellValue(M+2);
                //row.createCell(39).setCellValue(M+3);
               // row.createCell(40).setCellFormula(solde);
                /*
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());
                row.createCell(26).setCellValue(dossier.getPct_vendeur3());

*/
            }

        }

    }
    public void export(HttpServletResponse response) throws IOException {

        writeHeaderRow();
        writeDataRows();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();

    }
}
