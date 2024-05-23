package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.servlet.http.Part;

import java.util.List;


/**
 * The persistent class for the house database table.
 * 
 */
@Entity
@NamedQuery(name="House.findAll", query="SELECT h FROM House h")
public class House implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HousePK id;
	
	private String address;
	
	private String transport;

	@Column(name="`additional cost per person`")
	private double additional_cost_per_person;

	private double area;

	private String description;

	private int event;
	
	private String filepath;

	private String filepaths;
	
	@Transient
	private List<String> filepaths2;

	@Column(name="`living room`")
	private int living_room;

	@Column(name="`min number of days`")
	private int min_number_of_days;

	@Column(name="`number of baths`")
	private int number_of_baths;

	@Column(name="`number of bedrooms`")
	private int number_of_bedrooms;

	@Column(name="`number of beds`")
	private int number_of_beds;

	private int pets;

	private int smoking;

	@Column(name="`type of rental space`")
	private String type_of_rental_space;
	
	@Transient
	private Part photo;
	
	private int stars;
	
	private int reviews;
	
	@Column(name="`reviews host`")
	private int reviews_host;
	
	private String messages;
	
	@Transient
	private List<String> messages2;
	
	@Column(name="`username host`")
	private String username_host;

	//bi-directional many-to-one association to Host
	@ManyToOne
	@JoinColumn(name="location", insertable=false, updatable=false)
	private Host host;

	//bi-directional many-to-one association to Tenant
	@OneToMany(mappedBy="house")
	private List<Tenant> tenants;

	public House() {
	}

	public HousePK getId() {
		return this.id;
	}

	public void setId(HousePK id) {
		this.id = id;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTransport() {
		return this.transport;
	}
	
	public void setTransport(String transport) {
		this.transport = transport;
	}

	public double getAdditional_cost_per_person() {
		return this.additional_cost_per_person;
	}

	public void setAdditional_cost_per_person(double additional_cost_per_person) {
		this.additional_cost_per_person = additional_cost_per_person;
	}

	public double getArea() {
		return this.area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEvent() {
		return this.event;
	}

	public void setEvent(int event) {
		this.event = event;
	}
	
	public String getFilepath() {
		return this.filepath;
	}
	
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFilepaths() {
		return this.filepaths;
	}

	public void setFilepaths(String filepaths) {
		this.filepaths = filepaths;
	}
	
	public List<String> getFilepaths2() {
		return this.filepaths2;
	}

	public void setFilepaths2(List<String> filepaths2) {
		this.filepaths2 = filepaths2;
	}

	public int getLiving_room() {
		return this.living_room;
	}

	public void setLiving_room(int living_room) {
		this.living_room = living_room;
	}

	public int getMin_number_of_days() {
		return this.min_number_of_days;
	}

	public void setMin_number_of_days(int min_number_of_days) {
		this.min_number_of_days = min_number_of_days;
	}

	public int getNumber_of_baths() {
		return this.number_of_baths;
	}

	public void setNumber_of_baths(int number_of_baths) {
		this.number_of_baths = number_of_baths;
	}

	public int getNumber_of_bedrooms() {
		return this.number_of_bedrooms;
	}

	public void setNumber_of_bedrooms(int number_of_bedrooms) {
		this.number_of_bedrooms = number_of_bedrooms;
	}

	public int getNumber_of_beds() {
		return this.number_of_beds;
	}

	public void setNumber_of_beds(int number_of_beds) {
		this.number_of_beds = number_of_beds;
	}

	public int getPets() {
		return this.pets;
	}

	public void setPets(int pets) {
		this.pets = pets;
	}

	public int getSmoking() {
		return this.smoking;
	}

	public void setSmoking(int smoking) {
		this.smoking = smoking;
	}

	public String getType_of_rental_space() {
		return this.type_of_rental_space;
	}

	public void setType_of_rental_space(String type_of_rental_space) {
		this.type_of_rental_space = type_of_rental_space;
	}
	
	public Part getPhoto() {
		return this.photo;
	}
	
	public void setPhoto(Part photo) {
		this.photo = photo;
	}
	
	public int getStars() {
		return this.stars;
	}
	
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	public int getReviews() {
		return this.reviews;
	}
	
	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
	
	public int getReviews_host() {
		return this.reviews_host;
	}
	
	public void setReviews_host(int reviews_host) {
		this.reviews_host = reviews_host;
	}
	
	public String getMessages() {
		return this.messages;
	}
	
	public void setMessages(String messages) {
		this.messages = messages;
	}
	
	public List<String> getMessages2() {
		return this.messages2;
	}
	
	public void setMessages2(List<String> messages2) {
		this.messages2 = messages2;
	}
	
	public void addMessage(String message) {
		getMessages2().add(message);
	}
	
	public void removeMessage(String message) {
		getMessages2().remove(message);
	}
	
	public String getUsername_host() {
		return this.username_host;
	}

	public void setUsername_host(String username_host) {
		this.username_host = username_host;
	}

	public Host getHost() {
		return this.host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public List<Tenant> getTenants() {
		return this.tenants;
	}

	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}

	public Tenant addTenant(Tenant tenant) {
		getTenants().add(tenant);
		tenant.setHouse(this);

		return tenant;
	}

	public Tenant removeTenant(Tenant tenant) {
		getTenants().remove(tenant);
		tenant.setHouse(null);

		return tenant;
	}

}