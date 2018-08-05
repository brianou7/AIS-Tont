package models;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Table;

import models.Country;
import  models.Zone; 

@Entity
@Table(name="bird")
public class Bird implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(length=5, unique=true)
	private String code;
	@Column(length=100)
	private String common_name;
	@Column(length=200)
	private String scientific_name; 
	
	public Bird() {}

	public Bird(String code, String common_name, String scientific_name) {
		super();
		this.code = code;
		this.common_name = common_name;
		this.scientific_name = scientific_name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCommon_name() {
		return common_name;
	}

	public void setCommon_name(String common_name) {
		this.common_name = common_name;
	}

	public String getScientific_name() {
		return scientific_name;
	}

	public void setScientific_name(String scientific_name) {
		this.scientific_name = scientific_name;
	}

	@Override
	public String toString() {
		return "Bird [code=" + code + ", common_name=" + common_name + ", scientific_name=" + scientific_name + "]";
	}
		
}
