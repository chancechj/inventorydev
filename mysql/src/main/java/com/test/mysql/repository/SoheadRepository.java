package com.test.mysql.repository;

import com.test.mysql.entity.Sohead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoheadRepository extends JpaRepository<Sohead,Long> {

}
