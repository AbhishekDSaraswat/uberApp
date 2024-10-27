package com.abhishek.project.uber.uberApp.repositories;

import com.abhishek.project.uber.uberApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //    we did not write any query beacause spring data jpa will handle it
    Optional <User>findByEmail(String email);
}
