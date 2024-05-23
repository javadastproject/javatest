package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import model.House;

public class HouseDAOImpl implements HouseDAO {
	@Override
	public List<House> list_by_location(EntityManager em, String location) {
		Query query = em.createQuery("SELECT h FROM House h WHERE h.id.location LIKE :location ORDER BY h.id.min_value_of_tenancy");
		query.setParameter("location", location);
		@SuppressWarnings("unchecked")
		List<House> list = query.getResultList();
		return list;
	}
	
	@Override
	public void create(EntityManager em, House house) {
		em.persist(house);
	}
}