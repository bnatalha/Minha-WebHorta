package model.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Planta;
import model.data.PlantaDAO;

@Named(value = "plantaManagedBean")
@RequestScoped
public class PlantaMB {
    @Inject
    PlantaDAO dao;

    private List<Planta> plantaList;
    private Planta planta;
    
    // Constructor
    // ------------------------------------------------------------------------||
    @PostConstruct
    public void init() {
	plantaList = dao.getAll();
	planta = new Planta();
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
    
    // Dao communication
    // ------------------------------------------------------------------------||
    public String addNewPlanta() {
	dao.save(planta);
	plantaList = dao.getAll();
	return "plantalist";
    }

//    public String getPlantaById(Long id) {
//	planta = dao.get(id);
//	return "plantalist";
//    }

    public String updatePlantaList() {
	plantaList = dao.getAll();
	return "plantalist";
    }
}
