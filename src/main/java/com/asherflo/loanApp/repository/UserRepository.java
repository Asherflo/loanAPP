package com.asherflo.loanApp.repository;

import com.asherflo.loanApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true,value = "select * from user where email =:email ")
    User findByEmail(String email);
}
