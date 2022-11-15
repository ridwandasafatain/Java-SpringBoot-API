package com.rapidtech.springdatajpapgspl.repository;

import com.rapidtech.springdatajpapgspl.model.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoRepository extends JpaRepository<DAOUser, Long> {
    DAOUser findByUsername(String username);
}
