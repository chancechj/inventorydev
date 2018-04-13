package com.test.mysql.repository;

import com.test.mysql.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

  @Query("select t from Users t where t.username like :username")
     Page<Users> findByUsername(@Param("username") String username, Pageable pageRequest);


    Users findByUsername(String name);

}
