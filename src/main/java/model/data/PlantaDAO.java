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
public class PlantaDAO {
	@PersistenceContext(unitName = "PlantaPU")
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;

	public Planta addNew(Planta planta) {
		try {
			userTransaction.begin();
			entityManager.persist(planta);
			userTransaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return planta;
	}

	public List<Planta> findPlantas() {
		TypedQuery<Planta> query = entityManager.createNamedQuery("findAllPlantas", Planta.class);
		return query.getResultList();
	}
	
	public List<Planta> findPlantaPorId() {
		TypedQuery<Planta> query = entityManager.createNamedQuery("findAllPlantas", Planta.class);
		return query.getResultList();
	}

}
