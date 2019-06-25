package model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = "Horta.findAll", query = "SELECT h FROM Horta h"),
    @NamedQuery(name = "Horta.findId", query = "SELECT h FROM Horta h WHERE h.id = :id"), 
})
public class Horta {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_HORTA")
    @SequenceGenerator(name="SEQ_HORTA", sequenceName="seq_horta", allocationSize =1)
    private Long id;	   

    @Column(nullable=false)
    private String nome;

    private ArrayList<Planta> plantasDaHorta;
    
    // Constructor ------------------------------------------------------------------------||
    public Horta()
    {

    }
    
    // Getters/Setters ------------------------------------------------------------------------||

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

    public ArrayList<Planta> getPlantasDaHorta() {
        return plantasDaHorta;
    }

    public void setPlantasDaHorta(ArrayList<Planta> plantasDaHorta) {
        this.plantasDaHorta = plantasDaHorta;
    }
    
    // Especific modifiers --------------------------------------------------------------||
    public void addPlanta(Planta planta) {
	this.plantasDaHorta.add(planta);
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
	Horta other = (Horta) obj;
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
