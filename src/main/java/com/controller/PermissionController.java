package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceImpl.PermissionServiceImpl;
import com.dto.PermissionDto;
import com.dto.SuccessResponseDto;
import com.entity.PermissionEntity;

@RestController
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private PermissionServiceImpl permissioninterfacce;
	
	@PostMapping
	public ResponseEntity<?> addpermission(@RequestBody PermissionDto permissionDto)
	{
		
		PermissionDto permissionDto1 = permissioninterfacce.addpermission(permissionDto);
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", permissionDto1),HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(
			@RequestParam (defaultValue = "")String search,
			@RequestParam (defaultValue = "1")String pageNo ,
			@RequestParam (defaultValue = "5")String pagesize)
	{
		Page<?> entity = permissioninterfacce.getpermission(search,pageNo,pagesize);
		if(entity.getTotalElements()!=0)
		{
			return new ResponseEntity<>(entity.getContent(),HttpStatus.ACCEPTED);
		}else
		{
			return  new ResponseEntity<>("failed",HttpStatus.NOT_FOUND);
		}
	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatepermission(@RequestBody PermissionDto permissionDto,@PathVariable Integer id)
	{
		PermissionDto permissionDto1= permissioninterfacce.updatePermission(permissionDto,id);
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", permissionDto1),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public void deletePermission(@PathVariable Integer id)
	{
		permissioninterfacce.delete(id);
	}
	
	@GetMapping("/{id}")
	public PermissionEntity getById(@PathVariable Integer id)
	{
		
		return permissioninterfacce.getById(id);
		
		
	}
	
	
}
