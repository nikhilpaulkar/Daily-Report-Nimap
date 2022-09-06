package com.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.entity.UserRoleEntity;
import com.entity.UserRoleId;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer>
{

	void save(UserRoleId userroleid);

	
	// query for update
    @Transactional
	@Modifying(clearAutomatically=true)
	@Query(value="update userrole u SET role_id=:role_id WHERE u.user_id=:user_id", nativeQuery=true)
	void updateuserrole (@Param("user_id")Integer user_id,@Param("role_id")Integer role_id);

	
}
 