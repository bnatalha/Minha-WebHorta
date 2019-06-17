package model.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Horta;
import model.data.HortaDAO;

@Named(value = "hortaManagedBean")
@RequestScoped
public class HortaMB {
	@Inject HortaDAO dao;
	
	//Auxiliary fields for JSF
	private List<Horta> hortaList = new ArrayList<>();
	private Horta horta = new Horta();
	
	public List<Horta> getHortaList() {
		return hortaList;
	}

	public void setHortaList(List<Horta> hortaList) {
		this.hortaList = hortaList;
	}

	public Horta getHorta() {
		return horta;
	}

	public void setHorta(Horta horta) {
		this.horta = horta;
	}

	public String addNewHorta() {
		dao.addNew(horta);
		hortaList = dao.findHortas();
		return "hortalist";
	}
	
//	public String addNewPlanta(Horta horta) {
//		dao.(horta);
//		hortaList = dao.findHortas();
//		return "hortalist";
//	}
	
	public String updateHortaList() {
		hortaList = dao.findHortas();
		return "hortalist";
	}
	
}
