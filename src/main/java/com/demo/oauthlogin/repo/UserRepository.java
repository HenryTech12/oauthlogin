package com.demo.oauthlogin.repo;
import com.demo.oauthlogin.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
         Optional<UserData> findByUsername(String username);
         Optional<UserData> findByEmail(String email);
      
}