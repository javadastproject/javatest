package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Manager;

public interface ManagerDAO {
	public Manager find(EntityManager em, String username);

    public List<Manager> list(EntityManager em);

    public void create(EntityManager em, Manager manager);
}
