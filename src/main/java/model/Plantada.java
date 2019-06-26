package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({
    @NamedQuery(name = "Plantada.findAll", query = "SELECT h FROM Plantada h"),
    @NamedQuery(name = "Plantada.findId", query = "SELECT h FROM Plantada h WHERE h.id = :id"), 
})
public class Plantada {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_PLANTADA")
    @SequenceGenerator(name="SEQ_PLANTADA", sequenceName="seq_plantada", allocationSize =1)
    private Long id;	
    
//    @OneToMany(mappedBy = "plantadas")
    @ManyToOne
    private Planta tipoDaPlanta;
    
//    @OneToMany(mappedBy = "plantadasDaHorta")
    @ManyToOne
    private Horta nestaHorta;
    
    @Column(nullable = false)
    private Date dataDePlantio = new Date();

    /**
     * @param id
     */
    public Plantada(Long id) {
	super();
	this.id = id;
	
    }

    /**
     * 
     */
    public Plantada() {
	super();
    }
    
    // HashCode  ------------------------------------------------------------------------||
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Planta getTipoDaPlanta() {
        return tipoDaPlanta;
    }

    public void setTipoDaPlanta(Planta tipoDaPlanta) {
        this.tipoDaPlanta = tipoDaPlanta;
    }

    public Horta getHorta() {
        return nestaHorta;
    }

    public void setHorta(Horta horta) {
        this.nestaHorta = horta;
    }
    
    public Date getDataDePlantio() {
        return dataDePlantio;
    }

    public void setDataDePlantio(Date dataDePlantio) {
        this.dataDePlantio = dataDePlantio;
    }

    // HashCode  ------------------------------------------------------------------------||
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    // Equals  ------------------------------------------------------------------------||    
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Plantada other = (Plantada) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }
    
}
