package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.UserRoleEntity;
import com.entity.UserRoleId;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer>
{

	void save(UserRoleId userroleid);

}
