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
		Query query = em.createNativeQuery("SELECT * FROM Tenant AS t WHERE t.`location house`= '"+location+"' AND t.`first date house`= '"+first_date+"' AND t.`last date house`= '"+last_date+"' AND t.`max number of persons house`= '"+max_number_of_persons+"' AND t.`min value of tenancy house`= '"+min_value_of_tenancy+"'", Tenant.class);
	    @SuppressWarnings("unchecked")
	    List<Tenant> list = query.getResultList();
	    return list;
	}


	@Override
	public void create(EntityManager em, Tenant tenant) {
		em.persist(tenant);
	}

}
