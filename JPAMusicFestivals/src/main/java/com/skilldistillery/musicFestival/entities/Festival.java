package com.skilldistillery.musicFestival.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Festival {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	private Date date;
	
	private Boolean handicapAccess;
	
	private String venue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getHandicapAccess() {
		return handicapAccess;
	}

	public void setHandicapAccess(Boolean handicapAccess) {
		this.handicapAccess = handicapAccess;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Festival() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Festival other = (Festival) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Festival [id=" + id + ", name=" + name + ", date=" + date + ", handicapAccess=" + handicapAccess
				+ ", venue=" + venue + "]";
	}


}
