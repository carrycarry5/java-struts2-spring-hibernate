package hibernateManyToMany;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private Integer id;
	private String name;
	private String memo;
	
	//一个角色里有多个用户
	private Set<User> setUser = new HashSet<>();
	
	
	public Set<User> getSetUser() {
		return setUser;
	}
	public void setSetUser(Set<User> setUser) {
		this.setUser = setUser;
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
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
