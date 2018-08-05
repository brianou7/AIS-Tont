package hibernate.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table; 

@Entity
@Table(name="country")
public class Country implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(length=3, unique=true)
	private String code;
	@Column(length=100)
	private String name;
	@ManyToOne
	@JoinColumn(name="zone_id")
	private Zone zone;
	@ManyToMany
	private List<Bird> birds;

	public Country() {}
	
	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}
	
	public List<Bird> getBirds() {
		return birds;
	}

	public void setBirds(List<Bird> birds) {
		this.birds = birds;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", zone=" + zone + ", birds=" + birds + "]";
	}
}
