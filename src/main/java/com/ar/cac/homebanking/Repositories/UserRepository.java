package com.ar.cac.homebanking.Repositories;


import com.ar.cac.homebanking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
      User findByMail(String mail);
}
