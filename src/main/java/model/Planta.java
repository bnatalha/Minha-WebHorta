package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = "Planta.findAll", query = "SELECT p FROM Planta p"),
    @NamedQuery(name = "Planta.findId", query = "SELECT p FROM Planta p WHERE p.id = :id"), 
})
public class Planta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLANTA")
    @SequenceGenerator(name = "SEQ_PLANTA", sequenceName = "seq_planta", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String nomeCientifico;

    private Float luminosidadePadrao;

    private Float umidadePadrao;

    // private List<Rotina> rotinaPadrao;

    private String tipoDeSolo;

    private Boolean adubavel;
    
//    @ManyToOne
    @OneToMany(mappedBy = "tipoDaPlanta")
    private List<Plantada> plantadas;

//    @Temporal(TemporalType.DATE)
//    private Date dob;

    // Constructor
    // ------------------------------------------------------------------------||

    public Planta() {

    }

    // Getters/Setters
    // ------------------------------------------------------------------------||

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getNomeCientifico() {
	return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
	this.nomeCientifico = nomeCientifico;
    }

    public Float getLuminosidadePadrao() {
	return luminosidadePadrao;
    }

    public void setLuminosidadePadrao(Float luminosidadePadrao) {
	this.luminosidadePadrao = luminosidadePadrao;
    }

    public Float getUmidadePadrao() {
	return umidadePadrao;
    }

    public void setUmidadePadrao(Float umidadePadrao) {
	this.umidadePadrao = umidadePadrao;
    }

    public String getTipoDeSolo() {
	return tipoDeSolo;
    }

    public void setTipoDeSolo(String tipoDeSolo) {
	this.tipoDeSolo = tipoDeSolo;
    }

    public Boolean getAdubavel() {
	return adubavel;
    }

    public void setAdubavel(Boolean adubavel) {
	this.adubavel = adubavel;
    }

    // HashCode
    // ------------------------------------------------------------------------||

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    // Equals
    // ------------------------------------------------------------------------||

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Planta other = (Planta) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }
    
    @Override
    public String toString() {
        return "Horta[id=" + id + "]";
    }

}
