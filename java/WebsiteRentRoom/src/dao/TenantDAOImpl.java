package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Tenant;

public class TenantDAOImpl implements TenantDAO {

	@Override
	public Tenant find(EntityManager em, String username) {
		Tenant tenant = em.find(Tenant.class, username);
        return tenant;
	}

	@Override
	public List<Tenant> list(EntityManager em) {
		Query query = em.createNamedQuery("Tenant.findAll");
		@SuppressWarnings("unchecked")
		List<Tenant> tenants = query.getResultList(); 
        return tenants;
	}
	
	@Override
	public List<Tenant> list_by_house(EntityManager em, String location, String first_date, String last_date, int max_number_of_persons, double min_value_of_tenancy) {
		Query query = em.createNativeQuery("SELECT * FROM Tenant AS t WHERE t.`location house`= :parameter0"+" AND t.`first date house`= :parameter1"+" AND t.`last date house`= :parameter2"+" AND t.`max number of persons house`= '"+max_number_of_persons+"' AND t.`min value of tenancy house`= '"+min_value_of_tenancy+"'", Tenant.class).setParameter(":parameter0", location).setParameter(":parameter1", first_date).setParameter(":parameter2", last_date);
	    @SuppressWarnings("unchecked")
	    List<Tenant> list = query.getResultList();
	    return list;
	}


	@Override
	public void create(EntityManager em, Tenant tenant) {
		em.persist(tenant);
	}

}
