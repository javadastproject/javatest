package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.House;

public interface HouseDAO {
	public List<House> list_by_location(EntityManager em, String location);
	
	public void create(EntityManager em, House house);
}
