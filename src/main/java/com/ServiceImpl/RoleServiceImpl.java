package com.ServiceImpl;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dto.RoleDto;
import com.entity.RoleEntity;
import com.exception.ResourceNotFoundException;
import com.repository.RoleRepository;
import com.service.RoleServiceInterface;

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
		roleentity.setRoleName(roledto.getroleName());
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


  // update by id
      @Override
     public  RoleEntity update(RoleEntity roleentity, Integer id)
    {
	  try
	  {
         RoleEntity role= rolerepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("nOT fOUND"));
		 role.setRoleName(roleentity.getRoleName());
         RoleEntity role1= this.rolerepository.save(role);
		 return role1;
	  }
	  catch(Exception e)
	  {
		  throw new ResourceNotFoundException("Not Found Id");
	  }

  }


   

}
