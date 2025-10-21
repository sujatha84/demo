package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
