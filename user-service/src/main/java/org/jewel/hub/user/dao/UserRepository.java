package org.jewel.hub.user.dao;

import org.jewel.hub.entity.user.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AdminUser,Long>{

    @Query("SELECT u FROM AdminUser u WHERE u.userId = :username")
    AdminUser findByUsername(String username);
}

