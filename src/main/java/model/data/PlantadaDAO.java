package model.data;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import model.Plantada;

@Named
@RequestScoped
public class PlantadaDAO implements DAO<Plantada> {
    @PersistenceContext(unitName = "webhortaPU")
    private EntityManager em;

    @Resource
    private UserTransaction userTransaction;

    @Override
    public Plantada get(long id) {
	TypedQuery<Plantada> query = em.createNamedQuery("Plantada.findId", Plantada.class);
	query.setParameter("id", id);
	return query.getSingleResult();
    }
    
    @Override
    public List<Plantada> getAll() {
	TypedQuery<Plantada> query = em.createNamedQuery("Plantada.findAll", Plantada.class);
	return query.getResultList();
    }

    @Override
    public Plantada save(Plantada plantada) {
	try {
	    userTransaction.begin();
	    em.persist(plantada);
	    userTransaction.commit();
	} catch (Exception e) {

	    e.printStackTrace();
	}
	return plantada;
    }
    
//    @Override
    public Plantada update(Plantada plantada) {
	try {
	    userTransaction.begin();
//	    Plantada hortaToModify = em.find(Plantada.class, plantada.getId());
	    
//	    hortaToModify.setNome(plantada.getNome());
//	    hortaToModify.setPlantasDaPlantada(plantada.getPlantasDaPlantada());
	    em.persist(plantada);
	    
	    userTransaction.commit();
	} catch (Exception e) {

	    e.printStackTrace();
	}
	return plantada;
    }
}
