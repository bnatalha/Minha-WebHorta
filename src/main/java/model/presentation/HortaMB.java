package model.presentation;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.Horta;
import model.Planta;
import model.data.HortaDAO;
import java.io.Serializable;

@Named(value = "hortaManagedBean")
@SessionScoped
public class HortaMB implements Serializable {
    @Inject
    HortaDAO dao;

    private List<Horta> hortaList;
    private Horta horta;

    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    // Constructor
    // ------------------------------------------------------------------------||
    @PostConstruct
    public void init() {
	hortaList = dao.getAll();
	horta = new Horta();
    }

    // Get/Set
    // ------------------------------------------------------------------------||
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

    // View controller communication
    // ------------------------------------------------------------------------||
    public String addNewHorta() {
	dao.save(horta);
	hortaList = dao.getAll();
	return "/hortalist.xhtml?faces-redirect=true";
    }
    
    public String addNewPlanta(Planta planta) {
	this.horta = dao.get(this.horta.getId());
	this.horta.addPlanta(planta);
	System.out.println(this.horta);
	dao.update(this.horta);
	
	return "/hortaedit.xhtml?faces-redirect=true";
    }

    public String editHorta(Horta horta){
//	FacesContext fc = FacesContext.getCurrentInstance();
//	Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//	
//	Horta editThisHorta = 
//		dao.get(Long.parseLong(params.get("editButton")));
//	
//	sessionMap.put("editHortaObj", editThisHorta);
	this.horta = horta;
	
        return "/hortaedit.xhtml?faces-redirect=true";
    }
    
    public String deletePlanta(Horta horta, Planta planta) {
	// call dao and update horta with a new array without planta
	return "/hortalist.xhtml?faces-redirect=true";
    }

    public String updateHortaList() {
	hortaList = dao.getAll();
	return "/hortalist.xhtml?faces-redirect=true";
    }
}
