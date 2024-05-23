package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Manager;

public class ManagerDAOImpl implements ManagerDAO {
	@Override
	public Manager find(EntityManager em, String username) {
		Manager	manager = em.find(Manager.class, username);
        return manager;
	}

	@Override
	public List<Manager> list(EntityManager em) {
		Query query = em.createNamedQuery("Manager.findAll");
		@SuppressWarnings("unchecked")
		List<Manager> managers = query.getResultList();
        return managers;
	}

	@Override
	public void create(EntityManager em, Manager manager) {
		em.persist(manager);
	}
	
}
