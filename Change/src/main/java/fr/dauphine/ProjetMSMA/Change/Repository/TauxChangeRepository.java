package fr.dauphine.ProjetMSMA.Change.Repository;

import fr.dauphine.ProjetMSMA.Change.Model.TauxChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;
import java.util.Optional;

@Repository
public interface TauxChangeRepository extends  JpaRepository<TauxChange, Long>{

    List<TauxChange> findAll();
    void deleteById(Long id);
    Optional<TauxChange> findById(Long id);
    TauxChange findBySourceAndDestAndDateCotation(String source, String dest,Date dateCotation);
    TauxChange save(TauxChange t);
    List<TauxChange> findByDateCotation(Date dateCotation);
    List<TauxChange> findBySourceAndDest(String source, String dest);

}
