package model.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Planta;
import model.data.PlantaDAO;

@Named(value = "plantaManagedBean")
@RequestScoped
public class PlantaMB {
	@Inject PlantaDAO dao;
	
	//Auxiliary fields for JSF
	private List<Planta> plantaList = new ArrayList<>();
	private Planta planta = new Planta();
	
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

	public String addNewPlanta() {
		dao.addNew(planta);
		plantaList = dao.findPlantas();
		return "plantalist";
	}
	
	public String updatePlantaList() {
		plantaList = dao.findPlantas();
		return "plantalist";
	}
	
}
