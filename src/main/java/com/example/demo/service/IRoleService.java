package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Role;

public interface IRoleService {

	public List<Role> getRoles();
	
//	public Role addRole(Role newRole);
	
//	public void deleteRole(int id);
	
	public Role getRoleById(int id);
}
