package model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
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

    @ManyToOne
    private ArrayList<Plantada> plantadasDaHorta;
    
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

    public ArrayList<Plantada> getPlantadasDaHorta() {
        return plantadasDaHorta;
    }

    public void setPlantasDaHorta(ArrayList<Plantada> plantasDaHorta) {
        this.plantadasDaHorta = plantasDaHorta;
    }
    
    // Especific modifiers --------------------------------------------------------------||
    public void addPlantada(Plantada plantada) {
	this.plantadasDaHorta.add(plantada);
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
	String printString = new String("Horta [id=" + id + ", nome=" + nome + ", plantadasDaHorta= ");
	printString += "[ ";
	for (Plantada p: this.plantadasDaHorta) {
	    printString += "(" + p.toString() + "), ";
	}
	printString += "]]";
	return printString;
    }
}
