package com.adalicious.adalicious.repository;

import com.adalicious.adalicious.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    
}
