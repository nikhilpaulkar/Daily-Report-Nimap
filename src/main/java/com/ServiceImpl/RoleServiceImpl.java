package com.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.dto.RoleDto;

import com.entity.RoleEntity;
import com.entity.User;
import com.exception.ResourceNotFoundException;
import com.repository.RoleRepository;
import com.service.RoleServiceInterface;
import com.utility.Pagination;
@Service
public class RoleServiceImpl  implements RoleServiceInterface
{
	@Autowired
	private RoleRepository rolerepository;

	
	// add data
	@Override
	public RoleEntity addrole(RoleDto roledto)
	{
		RoleEntity roleentity=new RoleEntity();
		roleentity.setRolename(roledto.getroleName());
		return rolerepository.save(roleentity);
	}
	
	
	
	//get by id 
	  public RoleEntity getbyid (Integer id)
	   {
		return this.rolerepository.findById(id).get();
		}
	

    // get all roles 
		@Override
		public List<RoleEntity> getallroles()
		{
			List<RoleEntity> list = rolerepository.findAll();
			return  rolerepository.findAll();
		}
   
		
   // delete by id 
		@Override
		public void deletebyid(Integer id)
		{
		  rolerepository.deleteById(id);
        }


   

  // update data by id 
   @Override
  public RoleEntity save(Integer id) 
  {
	return rolerepository.save(id);
  }



	






		


		


	}
