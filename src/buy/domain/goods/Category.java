package buy.domain.goods;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Category implements Serializable{
	private static final long serialVersionUID = -961502453496240226L;
	private int id;
	private String name;
	private String uuid;
	private String description;
	private Set<Subdivide> subdivides;
	@Id
	@GeneratedValue
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
	@Column(unique=true)
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@OneToMany(mappedBy="category",targetEntity=Subdivide.class)
	public Set<Subdivide> getSubdivides() {
		return subdivides;
	}
	public void setSubdivides(Set<Subdivide> subdivides) {
		this.subdivides = subdivides;
	}
	
	

}
