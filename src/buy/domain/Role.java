package buy.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Role implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="role_uuid")
	private String uuid;
	private String name;
	@ManyToMany(mappedBy="roles")
	private Set<User> users;
	@ManyToMany(targetEntity=Source.class)
	@JoinTable(name = "role_source", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_uuid"), inverseJoinColumns = @JoinColumn(name = "source_id", referencedColumnName = "source_uuid"))
	private Set<Source> sources;
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
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Source> getSources() {
		return sources;
	}
	public void setSources(Set<Source> sources) {
		this.sources = sources;
	}
	

}
