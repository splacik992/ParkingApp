package com.envelo.ParkingApp.repository;

import com.envelo.ParkingApp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user where id =:userId", nativeQuery = true)
    User findUserById(@Param("userId") long id);

    @Query(value = "SELECT * FROM user where email =:email and password=:password",nativeQuery = true)
    User findUserByEmailAndPassword(@Param ("email") String email, @Param("password") String password);

}
