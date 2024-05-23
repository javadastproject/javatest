package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.servlet.http.Part;


/**
 * The persistent class for the tenant database table.
 * 
 */
@Entity
@NamedQuery(name="Tenant.findAll", query="SELECT t FROM Tenant t")
public class Tenant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String email;

	@Column(name="`first name`")
	private String first_name;

	@Column(name="`last name`")
	private String last_name;

	private String password;

	private String telephone;
	
	private String filepath;
	
	@Temporal(TemporalType.DATE)
	@Column(name="`first date house`")
	private java.util.Date first_date_house;

	@Temporal(TemporalType.DATE)
	@Column(name="`last date house`")
	private java.util.Date last_date_house;

	@Column(name="`location house`")
	private String location_house;

	@Column(name="`max number of persons house`")
	private int max_number_of_persons_house;

	@Column(name="`min value of tenancy house`")
	private double min_value_of_tenancy_house;

	@Transient
	private Part photo;

	//bi-directional many-to-one association to House
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="username", referencedColumnName="location", insertable=false, updatable=false),
		@JoinColumn(name="username", referencedColumnName="`first date`", insertable=false, updatable=false),
		@JoinColumn(name="username", referencedColumnName="`last date`", insertable=false, updatable=false),
		@JoinColumn(name="username", referencedColumnName="`max number of persons`", insertable=false, updatable=false),
		@JoinColumn(name="username", referencedColumnName="`min value of tenancy`", insertable=false, updatable=false)
	})
	private House house;

	public Tenant() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return this.first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return this.last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getFilepath() {
		return this.filepath;
	}
	
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	public java.util.Date getFirst_date_house() {
		return this.first_date_house;
	}

	public void setFirst_date_house(java.util.Date first_date_house) {
		this.first_date_house = first_date_house;
	}

	public java.util.Date getLast_date_house() {
		return this.last_date_house;
	}

	public void setLast_date_house(java.util.Date last_date_house) {
		this.last_date_house = last_date_house;
	}

	public String getLocation_house() {
		return this.location_house;
	}

	public void setLocation_house(String location_house) {
		this.location_house = location_house;
	}

	public int getMax_number_of_persons_house() {
		return this.max_number_of_persons_house;
	}

	public void setMax_number_of_persons_house(int max_number_of_persons_house) {
		this.max_number_of_persons_house = max_number_of_persons_house;
	}

	public double getMin_value_of_tenancy_house() {
		return this.min_value_of_tenancy_house;
	}

	public void setMin_value_of_tenancy_house(double min_value_of_tenancy_house) {
		this.min_value_of_tenancy_house = min_value_of_tenancy_house;
	}
	
	public Part getPhoto() {
		return this.photo;
	}
	
	public void setPhoto(Part photo) {
		this.photo = photo;
	}

	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

}