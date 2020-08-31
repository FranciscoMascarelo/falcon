package com.falcon.falcon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falcon.falcon.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
