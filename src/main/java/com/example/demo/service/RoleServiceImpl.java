package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IRoleRepository;
import com.example.demo.entity.Role;

@Service
public class RoleServiceImpl {

	@Autowired
	public IRoleRepository roleRepo;

	public List<Role> findAll() {
		List<Role> liste = new ArrayList<Role>();
		roleRepo.findAll().forEach(liste::add);
		return liste;
//		return roleRepo.findAll();
	}

//	@Override
//	public Role addRole(Role newRole) {
//		return roleRepo.save(newRole);
//	}
//	
//	@Override
//	public void deleteRole(int id) {
//		roleRepo.deleteById(id);
//	}
	
	public Role findById(int id) {
		return roleRepo.getOne(id);
	}
}
