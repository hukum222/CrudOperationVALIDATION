package com.springValidation.CrudOperation.dao;

import com.springValidation.CrudOperation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {

}
