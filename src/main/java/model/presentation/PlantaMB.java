package model.presentation;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
//import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Planta;
import model.data.PlantaDAO;
import java.io.Serializable;

@Named(value = "plantaManagedBean")
@SessionScoped
public class PlantaMB implements Serializable {
    @Inject
    PlantaDAO dao;

    private List<Planta> plantaList;
    private Planta planta;
    private Long plantaId;
    
    // Constructor
    // ------------------------------------------------------------------------||
    @PostConstruct
    public void init() {
	plantaList = dao.getAll();
	planta = new Planta();
//	plantaId = null;
    }

    // Get/Set
    // ------------------------------------------------------------------------||
    public List<Planta> getPlantaList() {
	return plantaList;
    }

    public void setPlantaList(List<Planta> plantaList) {
	this.plantaList = plantaList;
    }

    public Planta getPlanta() {
	return planta;
    }

    public void setPlanta(Planta planta) {
	this.planta = planta;
    }

    public Long getPlantaId() {
        return plantaId;
    }

    public void setPlantaId(Long plantaId) {
        this.plantaId = plantaId;
    }

    // Dao communication
    // ------------------------------------------------------------------------||
    public String addNewPlanta() {
	dao.save(planta);
	plantaList = dao.getAll();
	
	return "/plantalist.xhtml?faces-redirect=true";
    }

    public String updatePlantaList() {
	plantaList = dao.getAll();
	
	return "/plantalist.xhtml?faces-redirect=true";
    }
}
