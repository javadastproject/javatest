package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Host;

public interface HostDAO {
	public Host find(EntityManager em, String username);

    public List<Host> list(EntityManager em);

    public void create(EntityManager em, Host host);
}
