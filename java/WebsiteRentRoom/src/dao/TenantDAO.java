package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Tenant;

public interface TenantDAO {
	public Tenant find(EntityManager em, String username);

    public List<Tenant> list(EntityManager em);
    
    public List<Tenant> list_by_house(EntityManager em, String location, String first_date, String last_date, int max_number_of_persons, double min_value_of_tenancy);

    public void create(EntityManager em, Tenant tenant);
}
