package com.test.Dao;

import com.test.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    @Query(value="SELECT * FROM users WHERE users.account=:account",nativeQuery=true)
    public Users findByAccount(@Param("account") String account);

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    public List<Users> getAccount();

    @Modifying
    @Query(value="DELETE FROM users WHERE users.account=:account",nativeQuery=true)
    public void deleteByAccount(@Param("account") String account);

    @Modifying
    @Query(value="INSERT INTO users(account,password) VALUES(:account,:password)",nativeQuery=true)
    public void addAccount(@Param("account") String account,@Param("password") String password);
}
