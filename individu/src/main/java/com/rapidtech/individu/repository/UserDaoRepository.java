package com.rapidtech.individu.repository;

import com.rapidtech.individu.model.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDaoRepository extends JpaRepository<DAOUser, Long> {
    DAOUser findByUsername(String username);
}
