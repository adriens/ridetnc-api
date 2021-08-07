/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.ridetncapi.service;

import com.github.adriens.ridetnc4j.entities.Entreprise;
import com.github.adriens.ridetnc4j.wrapper.EntrepriseNotFoundException;
import com.github.adriens.ridetnc4j.wrapper.Entreprises;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author 3004SAL
 */
@Service
public class EntreprisesService {
    
    private final Logger log = LoggerFactory.getLogger(EntreprisesService.class);
    
    public Entreprise getEnterpriseFromRidet(String ridet) throws EntrepriseNotFoundException, Exception{
        Entreprise ent = Entreprises.getEnterpriseFromRidet(ridet);
        return ent;
    }
    public List<Entreprise> getEnterprisesFromQueryString(String q, int page){
        return Entreprises.getEnterprisesFromQueryString(q, page);
    }
}
