package fr.dauphine.ProjetMSMA.Change.Controller;

import fr.dauphine.ProjetMSMA.Change.Model.TauxChange;
import fr.dauphine.ProjetMSMA.Change.Repository.TauxChangeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;


@RestController
public class ChangeController {

    // Spring se charge de la création d'instance
    @Autowired
    private Environment environment;

    // Spring se charge de la création d'instance
    @Autowired
    private TauxChangeRepository repository;


    @GetMapping("/devise-change")
    public List<TauxChange> afficherTaux(){
        List<TauxChange> tauxChange = repository.findAll();

        return tauxChange;
    }

    @RequestMapping(method={RequestMethod.DELETE,RequestMethod.GET},value = "/devise-change/delete={id}")
    public void supprimerTaux(@PathVariable Long id){
        repository.deleteById(id);
    }


    @GetMapping("/devise-change/source/{source}/dest/{dest}/date/{dateCotation}")
    public TauxChange retrouveTauxChange
            (@PathVariable String source, @PathVariable String dest,@PathVariable Date dateCotation) {

        TauxChange tauxChange =
                repository.findBySourceAndDestAndDateCotation(source, dest,dateCotation);

    /*tauxChange.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));*/

        return tauxChange;
    }

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json",value = "/devise-change/ajout/")
    public void ajoutTauxChange(){
        BigDecimal b = new BigDecimal(0.006);
        TauxChange t = new TauxChange(Long.valueOf(10005),"DZD","EUR",new Date(2021,05,23), b);
        repository.save(t);
    }


}