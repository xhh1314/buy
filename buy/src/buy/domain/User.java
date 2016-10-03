package buy.domain;

public class User {
	
	private String uuid;
	private String username;
	private String password;
	private String telephone;
	private String email;
	private Role[] role;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role[] getRole() {
		return role;
	}
	public void setRole(Role[] role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [name=" + username + "]";
	}
	

}
