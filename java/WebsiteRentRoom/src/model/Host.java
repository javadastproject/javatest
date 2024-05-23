package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.servlet.http.Part;

import java.util.List;


/**
 * The persistent class for the host database table.
 * 
 */
@Entity
@NamedQuery(name="Host.findAll", query="SELECT h FROM Host h")
public class Host implements Serializable {
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

	@Transient
	private Part photo;

	//bi-directional many-to-one association to House
	@OneToMany(mappedBy="host")
	private List<House> houses;

	public Host() {
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
	
	public Part getPhoto() {
		return this.photo;
	}
	
	public void setPhoto(Part photo) {
		this.photo = photo;
	}

	public List<House> getHouses() {
		return this.houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

	public House addHous(House hous) {
		getHouses().add(hous);
		hous.setHost(this);

		return hous;
	}

	public House removeHous(House hous) {
		getHouses().remove(hous);
		hous.setHost(null);

		return hous;
	}

}