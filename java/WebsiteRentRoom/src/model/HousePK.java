package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the house database table.
 * 
 */
@Embeddable
public class HousePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String location;

	@Temporal(TemporalType.DATE)
	@Column(name="`first date`")
	private java.util.Date first_date;

	@Temporal(TemporalType.DATE)
	@Column(name="`last date`")
	private java.util.Date last_date;

	@Column(name="`max number of persons`")
	private int max_number_of_persons;

	@Column(name="`min value of tenancy`")
	private double min_value_of_tenancy;

	public HousePK() {
	}
	public String getLocation() {
		return this.location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public java.util.Date getFirst_date() {
		return this.first_date;
	}
	public void setFirst_date(java.util.Date first_date) {
		this.first_date = first_date;
	}
	public java.util.Date getLast_date() {
		return this.last_date;
	}
	public void setLast_date(java.util.Date last_date) {
		this.last_date = last_date;
	}
	public int getMax_number_of_persons() {
		return this.max_number_of_persons;
	}
	public void setMax_number_of_persons(int max_number_of_persons) {
		this.max_number_of_persons = max_number_of_persons;
	}
	public double getMin_value_of_tenancy() {
		return this.min_value_of_tenancy;
	}
	public void setMin_value_of_tenancy(double min_value_of_tenancy) {
		this.min_value_of_tenancy = min_value_of_tenancy;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HousePK)) {
			return false;
		}
		HousePK castOther = (HousePK)other;
		return 
			this.location.equals(castOther.location)
			&& this.first_date.equals(castOther.first_date)
			&& this.last_date.equals(castOther.last_date)
			&& (this.max_number_of_persons == castOther.max_number_of_persons)
			&& (this.min_value_of_tenancy == castOther.min_value_of_tenancy);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.location.hashCode();
		hash = hash * prime + this.first_date.hashCode();
		hash = hash * prime + this.last_date.hashCode();
		hash = hash * prime + this.max_number_of_persons;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.min_value_of_tenancy) ^ (java.lang.Double.doubleToLongBits(this.min_value_of_tenancy) >>> 32)));
		
		return hash;
	}
}