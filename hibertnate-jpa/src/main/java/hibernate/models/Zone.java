package hibernate.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity
@Table(name="zone")
public class Zone implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(length=3, unique=true)
	private String code;
	@Column(length=45)
	private String name;
	
	public Zone() {
		
	}
	
	public Zone(String code, String name) {
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
	
	@Override
	public String toString() {
		return "Zone [code=" + code + ", name=" + name + "]";
	} 

}
