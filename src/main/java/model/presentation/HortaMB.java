package model.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.Horta;
import model.data.HortaDAO;

@Named(value = "hortaManagedBean")
@RequestScoped
public class HortaMB {
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

    // Dao communication
    // ------------------------------------------------------------------------||
    public String addNewHorta() {
	dao.save(horta);
	hortaList = dao.getAll();
	return "hortalist";
    }

    public String editHorta(){
	FacesContext fc = FacesContext.getCurrentInstance();
	Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
	
	Horta editThisHorta = 
		dao.get(Long.parseLong(params.get("editButton")));
	
	sessionMap.put("editHortaObj", editThisHorta);
	
        return "/horta_editplantas.xhtml?faces-redirect=true";
    }

//    public String updateHorta() {
//	dao.update()
//        Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//        sessionMapObj.put("selectedHortaMBObj", selectedHortaMB );	
//        return "horta_editplantas";
//    }

//    public String getHortaById(Long id) {
//	horta = dao.get(id);
//	return "hortalist";
//    }

    public String updateHortaList() {
	hortaList = dao.getAll();
	return "hortalist";
    }
}
