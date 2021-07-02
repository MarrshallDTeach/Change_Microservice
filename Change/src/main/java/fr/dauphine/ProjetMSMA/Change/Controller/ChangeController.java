package fr.dauphine.ProjetMSMA.Change.Controller;

import fr.dauphine.ProjetMSMA.Change.Model.TauxChange;
import fr.dauphine.ProjetMSMA.Change.Repository.TauxChangeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import java.util.Optional;


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

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json",value = "/devise-change/ajout/id/{id}/source/{source}/dest/{dest}/date/{dateCotation}/taux/{taux}")
    public void ajoutTauxChange
            (@PathVariable Long id,@PathVariable String source,@PathVariable String dest,@PathVariable Date dateCotation,@PathVariable BigDecimal taux) {
        TauxChange t = new TauxChange(id,source,dest,dateCotation,taux);
        repository.save(t);

    }

    @RequestMapping(method = {RequestMethod.PUT,RequestMethod.GET},produces = "application/json",value = "/devise-change/modifier/id/{id}/taux/{taux}")
    public Optional<TauxChange> modifierTauxChange
            (@PathVariable Long id,@PathVariable BigDecimal taux) {
        return repository.findById(id).map(tauxchange-> {
            tauxchange.setTaux(taux);
            return repository.save(tauxchange);
        });

    }
}