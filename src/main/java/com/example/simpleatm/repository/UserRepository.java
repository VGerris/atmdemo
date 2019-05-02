package com.example.simpleatm.repository;

import com.example.simpleatm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ashish on 13/5/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
