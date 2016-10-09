package buy.domain.goods;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Goods implements Serializable{
	private static final long serialVersionUID = -8923680561032818058L;
	private int id;
	private String uuid;
	private String name;
	private String description;
	private String image_location;
	private Subdivide subdivide;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage_location() {
		return image_location;
	}
	public void setImage_location(String image_location) {
		this.image_location = image_location;
	}
	@ManyToOne
	@JoinColumn(name="sub_id",referencedColumnName="uuid")
	public Subdivide getSubdivide() {
		return subdivide;
	}
	public void setSubdivide(Subdivide subdivide) {
		this.subdivide = subdivide;
	}
	

}
