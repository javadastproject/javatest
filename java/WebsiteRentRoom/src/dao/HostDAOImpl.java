package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Host;

public class HostDAOImpl implements HostDAO {
	@Override
	public Host find(EntityManager em, String username) {
		Host host = em.find(Host.class, username); 
        return host;
	}

	@Override
	public List<Host> list(EntityManager em) {
		Query query = em.createNamedQuery("Host.findAll");
		@SuppressWarnings("unchecked")
		List<Host> hosts = query.getResultList();
        return hosts;
	}

	@Override
	public void create(EntityManager em, Host host) {
		em.persist(host);
	}
	
}
