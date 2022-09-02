package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.UserDto;
import com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
  User findByEmail(String email);

User save(UserDto userdto);

void save(Integer id);


void deleteById(User user);

}
