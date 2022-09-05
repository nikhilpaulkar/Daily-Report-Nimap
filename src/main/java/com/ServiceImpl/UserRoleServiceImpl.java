package com.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.RoleEntity;
import com.entity.User;
import com.entity.UserRoleEntity;
import com.entity.UserRoleId;
import com.exception.ResourceNotFoundException;
import com.payload.UserRoleRequest;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.repository.UserRoleRepository;
import com.service.UserRoleServiceInterface;

@Service
public class UserRoleServiceImpl implements UserRoleServiceInterface

{
	@Autowired
	private UserRoleRepository userrolerepo;
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private RoleRepository rolerepository;

	// add data 
	@Override
	public void add(UserRoleRequest userrolerequest)
	{
		try
		{
			ArrayList<UserRoleEntity> userrole=new ArrayList<>();
			User user=this.userrepository.findById(userrolerequest.getUserid()).orElseThrow(()->new ResourceNotFoundException("user not found with id"));
		    RoleEntity roleenntity = this.rolerepository.findById(userrolerequest.getRoleid()).orElseThrow(()-> new ResourceNotFoundException("user  nOT FOUNd with roleid"));
			UserRoleEntity userroleentity = new UserRoleEntity();
			
		    UserRoleId userroleid = new UserRoleId (user,roleenntity);
		    
		    userroleentity.setTask(userroleid);
            userrole.add(userroleentity);
            userrolerepo.saveAll(userrole);
		}   catch(Exception e)
		{
			e.printStackTrace();
			throw new ResourceNotFoundException("Not found ");
			
			
        }

     }
	//  get all 
	  public List<UserRoleEntity> getall()
		
		{ 
		   List<UserRoleEntity> role =this.userrolerepo.findAll();
		   return role;
		}
	
	
	// update data 
	@Override
	public void updateuserrole(UserRoleRequest userrolerequest) 
	{
		User user=this.userrepository.findById(userrolerequest.getUserid()).orElseThrow(()-> new ResourceNotFoundException("user not found with id"));
		
		RoleEntity roleentity=this.rolerepository.findById(userrolerequest.getRoleid()).orElseThrow(()-> new ResourceNotFoundException("not found"));
		UserRoleId userroleid = new UserRoleId(user, roleentity);
		UserRoleEntity useroleentity = new UserRoleEntity();
		useroleentity.setTask(userroleid);
		userrolerepo.save(userroleid);
	}

	  // delete by id 
	
	  
	
}