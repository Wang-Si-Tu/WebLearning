package com.test.Dao;

import com.test.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    @Query(value="SELECT * FROM users WHERE users.account=:account",nativeQuery=true)
    public Users findByAccount(@Param("account") String account);
}
