package com.etrieu00.springblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.etrieu00.springblog.entities.Users;

@Repository
public interface UsersJPA extends JpaRepository<Users,Long> {

}
