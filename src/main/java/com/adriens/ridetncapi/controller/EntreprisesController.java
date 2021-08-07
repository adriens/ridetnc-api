/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.ridetncapi.controller;

import com.adriens.ridetncapi.service.EntreprisesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.adriens.ridetnc4j.entities.Entreprise;
import com.github.adriens.ridetnc4j.wrapper.EntrepriseNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author 3004SAL
 */
@RestController
public class EntreprisesController {
    @Autowired
    private EntreprisesService entreprisesService;
    
    @GetMapping("/ridet/{ridet}")
    public Entreprise getEntreprise(@PathVariable String ridet) throws Exception{
        try{
            Entreprise ent = entreprisesService.getEnterpriseFromRidet(ridet);
            return ent;
        }
        catch(EntrepriseNotFoundException ex){
         ResponseStatusException httpEx = new ResponseStatusException(
                 HttpStatus.NOT_FOUND,
                 ex.getMessage(),
                 ex);
         throw httpEx;
        }
        
    }
    
    @GetMapping("/ridets")
    public List<Entreprise> getEnterprisesFromQueryString(
            @RequestParam(value="q") String q,
            @RequestParam(value="page", defaultValue = "1") int page) {
     return entreprisesService.getEnterprisesFromQueryString(q, page);
    }
}
