package com.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.PermissionEntity;
import com.entity.RoleEntity;
import com.entity.RolePermissionEntity;
import com.entity.RolePermissionId;
import com.exception.ResourceNotFoundException;
import com.payload.RolePermissionRequest;
import com.repository.PermissionRepo;
import com.repository.RolePermissionRepo;
import com.repository.RoleRepository;

import com.service.RolePermissionServiceInterface;


@Service
public class RolePermissionServiceImpl implements RolePermissionServiceInterface
{
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private RolePermissionRepo rolePermissionRepo;
	
	@Autowired
	private PermissionRepo permissionRepo;
	
	

	// add data 
	@Override
	public void add(RolePermissionRequest rolePermissionRequest) 
	{
		try 
		{
			ArrayList<RolePermissionEntity> permissions = new ArrayList<>();
			RoleEntity roleEntityId = this.roleRepo.findById(rolePermissionRequest.getRoleid()).orElseThrow(()-> new ResourceNotFoundException("Not Found roleid"));
			PermissionEntity permissionEntityId = this.permissionRepo.findById(rolePermissionRequest.getPermissionid()).orElseThrow(()-> new ResourceNotFoundException("Not Found permissionid"));
			
			RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();
			
			RolePermissionId rolePermissionId = new RolePermissionId(roleEntityId,permissionEntityId);
			rolePermissionEntity.setPk(rolePermissionId);
			permissions.add(rolePermissionEntity);
			rolePermissionRepo.saveAll(permissions);
			
		} catch (Exception e) 
		{
		
            throw new ResourceNotFoundException("not found");
		}
		
		
		
		
	}


    // get all data 
	@Override
	public List<RolePermissionEntity> getAll() {
		
		return this.rolePermissionRepo.findAll();
	}

    // update role permission 
	@Override
	public void updateRolePermission(RolePermissionRequest rolePermissionRequest)
	{
		RoleEntity roleEntity = this.roleRepo.findById(rolePermissionRequest.getRoleid()).get();
		PermissionEntity permissionEntity = this.permissionRepo.findById(rolePermissionRequest.getPermissionid()).get();
		
		RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();
		RolePermissionId rolePermissionId = new RolePermissionId(roleEntity,permissionEntity);
		rolePermissionEntity.setPk(rolePermissionId);
		this.rolePermissionRepo.updateRolePermission(roleEntity.getId(), permissionEntity.getId());
		
	}

    // delete by id 
	@Override
	public void deleteRolePermission(RolePermissionRequest rolePermissionRequest)
	{
		RoleEntity roleEntity=this.roleRepo.findById(rolePermissionRequest.getRoleid()).get();
		
		PermissionEntity permissionEntity=this.permissionRepo.findById(rolePermissionRequest.getPermissionid()).get();
		
		RolePermissionEntity rolePermissionEntity=new RolePermissionEntity();
		
		RolePermissionId rolePermissionId=new RolePermissionId(roleEntity,permissionEntity);
		rolePermissionEntity.setPk(rolePermissionId);
		rolePermissionRepo.delete(rolePermissionEntity);
	}



	
	
	
	
	
}

