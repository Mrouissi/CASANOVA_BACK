package com.istic.casanova.restcontroller;

import com.istic.casanova.model.*;
import com.istic.casanova.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BonDeCommandeController {

    @Autowired
    private AgenceRepository agenceRepository;
    @Autowired
    private EntiteVenteRepository entiteVenteRepository;
    @Autowired
    private OrigineContactRepository origineContactRepository;
    @Autowired
    private TypesTravauxRepository typesTravauxRepository;
    @Autowired
    private ElementARenoverRepository elementARenoverRepository;
    @Autowired
    private PrestationARealaiserRepository prestationARealaiserRepository;
    @Autowired
    private SupportExistantRepository supportExistantRepository;


    /**
     *
     * @return list of agences
     */
    @GetMapping("/agences")
    public List<Agence> getAllAgences(){ return agenceRepository.findAll();}

    /**
     *
     * @return List of EntiteVente
     */
    @GetMapping("/entiteVente")
    public List<EntiteVente> getAllEntiteVente(){return entiteVenteRepository.findAll();}

    /**
     *
     * @return List of OrigineContact
     */
    @GetMapping("/originecontact")
    public List<OrigineContact> getAllOrigineContact(){ return origineContactRepository.findAll();}

    /**
     *
     * @return List of TypesTravaux
     */
    @GetMapping("/typestravaux")
    public List<TypesTravaux> getAllTypesTravaux(){ return typesTravauxRepository.findAll();}

    /**
     *
     * @return List of ElementARenover
     */
    @GetMapping("/elementrenover")
    public List<ElementARenover> getAllElementARenover(){return elementARenoverRepository.findAll();}

    /**
     *
     * @return List of prestationARealiser
     */
    @GetMapping("/prestationrealiser")
    public List<PrestationARealiser> getAllPrestationARealiser(){ return prestationARealaiserRepository.findAll();}

    /**
     *
     * @return List of supportExistant
     */
    @GetMapping("/supportexistant")
    public List<SupportExistant> getAllSupportExistant(){return supportExistantRepository.findAll();}

}

