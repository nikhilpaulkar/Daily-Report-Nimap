package com.ServiceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.dto.PermissionDto;
import com.entity.PermissionEntity;
import com.repository.PermissionRepo;
import com.service.PermissionInterface;
import com.utility.Pagination;

@Service
public class PermissionServiceImpl implements PermissionInterface
{
	@Autowired
	private PermissionRepo permisssionrepo;

	// add data 
	@Override
	public PermissionDto addpermission(PermissionDto permissiondto) 
	{
		PermissionEntity permissionEntity=this.dtoToUser(permissiondto);
		PermissionEntity permissionEntity2=this.permisssionrepo.save(permissionEntity);
		return this.userToDto(permissionEntity2);
		
	}
	
   private PermissionEntity dtoToUser(PermissionDto permissionDto) 
   {
		
		
	   PermissionEntity  permissionentity= new PermissionEntity();
	   
	   permissionentity.setActionName(permissionDto.getActionName());
	   permissionentity.setBaseUrl(permissionDto.getBaseUrl());
	   permissionentity.setPath(permissionDto.getPath());
	   permissionentity.setMethod(permissionDto.getMethod());
	   return permissionentity;
	   
	   
	}
		
		private PermissionDto userToDto(PermissionEntity permissionEntity)
		{
			PermissionDto permissiondto = new PermissionDto ();
			
			permissiondto.setActionName(permissionEntity.getActionName());
			permissiondto.setBaseUrl(permissionEntity.getBaseUrl());
			permissiondto.setMethod(permissionEntity.getMethod());
			permissiondto.setPath(permissionEntity.getPath());
			return permissiondto;
			
			
	    }

		// get all data 
		@Override
		public Page<?> getpermission(String search, String pageNo, String pagesize)
		{
			org.springframework.data.domain.Pageable pageable =new Pagination().getPagination(pageNo, pagesize);
			if((search=="" )||(search==null)||(search.length()==0) )
				
			{
				return this.permisssionrepo.findAll(pageable);
			}
			else
			{
				return this.permisssionrepo.findByActionName(search,pageable,PermissionEntity.class);
			}
			
		}
     // update data 
		@Override
		public PermissionDto updatePermission(PermissionDto permissionDto, Integer id) 
		{
			PermissionEntity permissionEntity =  this.permisssionrepo.findById(id).get();
			permissionEntity.setId(permissionEntity.getId());
			permissionEntity.setActionName(permissionDto.getActionName());
			permissionEntity.setBaseUrl(permissionDto.getBaseUrl());
			permissionEntity.setPath(permissionDto.getPath());
			permissionEntity.setMethod(permissionDto.getMethod());
			
			permisssionrepo.save(permissionEntity);
			return permissionDto;
			
		}
		
     //delete by id 
		@Override
		public void delete(Integer id) 
		{

			this.permisssionrepo.deleteById(id);
			
		}
   
	//get by id 
		@Override
		public PermissionEntity getById(Integer id)
		{
			return this.permisssionrepo.findById(id).get();
		}

	

}
