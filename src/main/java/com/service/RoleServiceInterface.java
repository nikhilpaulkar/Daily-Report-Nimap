package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.RoleDto;
import com.entity.RoleEntity;

@Service
public interface RoleServiceInterface {

	RoleEntity addrole(RoleDto roledto);

	List<RoleEntity> getallroles();

	RoleEntity getbyid(Integer id);

	void deletebyid(Integer id);

	RoleEntity update(RoleEntity roleentity, Integer id);

}
