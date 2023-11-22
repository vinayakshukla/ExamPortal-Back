package com.exam.examserver.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="roles")
public class Role {
	@Id
	private Long roleId;
	private String roleName;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy= "role")
	private Set<UserRole> userRoles=new HashSet<>();
	
	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Role(Long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
