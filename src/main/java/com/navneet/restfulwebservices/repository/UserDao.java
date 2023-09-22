package com.navneet.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.navneet.restfulwebservices.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

}
