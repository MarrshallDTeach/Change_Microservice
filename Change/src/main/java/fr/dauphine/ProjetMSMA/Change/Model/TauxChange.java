package fr.dauphine.ProjetMSMA.Change.Model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
//import javax.persistence.GeneratedValue;

@Entity
public class TauxChange {

    @Id
    private Long id;

    @Column(name="devise_src")
    private String source;

    @Column(name="devise_dest")
    private String dest;

    @Column(name="date_cotation")
    private Date dateCotation;

    private BigDecimal taux;

    public TauxChange() {

    }

    public TauxChange(Long id, String source, String dest, Date dateCotation, BigDecimal taux) {
        super();
        this.id = id;
        this.source = source;
        this.dest = dest;
        this.dateCotation = dateCotation;
        this.taux = taux;
    }

    public Long getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getDest() {
        return dest;
    }

    public Date getDateCotation() { return dateCotation; }

    public BigDecimal getTaux() {
        return taux;
    }

    public void setTaux(BigDecimal taux) {this.taux = taux;}
}
