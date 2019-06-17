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
public class HortaDAO {
	@PersistenceContext(unitName = "HortaPU")
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;

	public Horta addNew(Horta horta) {
		try {
			userTransaction.begin();
			entityManager.persist(horta);
			userTransaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return horta;
	}

	public List<Horta> findHortas() {
		TypedQuery<Horta> query = entityManager.createNamedQuery("findAllHortas", Horta.class);
		return query.getResultList();
	}

}
