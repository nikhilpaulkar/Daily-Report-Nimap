package com.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public void add(UserRoleRequest userrolerequest)
	{
		try
		{
			ArrayList<UserRoleEntity> userroles=new ArrayList<>();
			User userI=this.userrepository.findById(userrolerequest.getUserid()).orElseThrow(()->new ResourceNotFoundException("user not found with id"));
		    UserRoleEntity userroleentityId=new UserRoleEntity();
		   // UserRoleId userroleid=new UserRoleId(userid,userroleentityId );
		  //  UserRoleEntity.setTask(userroleid);
         //   userroles.add(userroleentity);
            userrolerepo.saveAll(userroles);
		}catch(Exception e)
		{
			
        }

}
}