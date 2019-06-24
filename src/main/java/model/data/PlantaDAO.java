package model.data;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import model.Planta;

@Named
@RequestScoped
public class PlantaDAO implements DAO<Planta> {
    @PersistenceContext(unitName = "PlantaPU")
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    @Override
    public Planta get(long id) {
	TypedQuery<Planta> query = entityManager.createNamedQuery("Planta.findId", Planta.class);
	return query.getSingleResult();
    }
    
    @Override
    public List<Planta> getAll() {
	TypedQuery<Planta> query = entityManager.createNamedQuery("Planta.findAll", Planta.class);
	return query.getResultList();
    }

    @Override
    public Planta save(Planta planta) {
	try {
	    userTransaction.begin();
	    entityManager.persist(planta);
	    userTransaction.commit();
	} catch (Exception e) {

	    e.printStackTrace();
	}
	return planta;
    }
}
