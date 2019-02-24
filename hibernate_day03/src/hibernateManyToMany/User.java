package hibernateManyToMany;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer id;
	private String name;
	private String password;
	
	//一个用户中有多个角色
	private Set<Role> setRole = new HashSet<>();
	

	public Set<Role> getSetRole() {
		return setRole;
	}
	public void setSetRole(Set<Role> setRole) {
		this.setRole = setRole;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
