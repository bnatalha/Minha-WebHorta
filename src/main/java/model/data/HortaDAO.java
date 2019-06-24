package model.data;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import model.Horta;

@Named
@RequestScoped
public class HortaDAO implements DAO<Horta> {
    @PersistenceContext(unitName = "HortaPU")
    private EntityManager em;

    @Resource
    private UserTransaction userTransaction;

    @Override
    public Horta get(long id) {
	System.out.println(id);
	TypedQuery<Horta> query = em.createNamedQuery("Horta.findId", Horta.class);
	query.setParameter("id", id);
	return query.getSingleResult();
    }
    
    @Override
    public List<Horta> getAll() {
	TypedQuery<Horta> query = em.createNamedQuery("Horta.findAll", Horta.class);
	return query.getResultList();
    }

    @Override
    public Horta save(Horta horta) {
	try {
	    userTransaction.begin();
	    em.persist(horta);
	    userTransaction.commit();
	} catch (Exception e) {

	    e.printStackTrace();
	}
	return horta;
    }
    
//    @Override
//    public Horta update(Horta horta) {
//	try {
//	    userTransaction.begin();
//	    Horta hortaToModify = em.find(Horta.class, horta.getId());
//	    
//	    hortaToModify.setNome(horta.getNome());
//	    hortaToModify.setPlantasDaHorta(horta.getPlantasDaHorta());
//	    em.persist(horta);
//	    
//	    userTransaction.commit();
//	} catch (Exception e) {
//
//	    e.printStackTrace();
//	}
//	return horta;
//    }
}
