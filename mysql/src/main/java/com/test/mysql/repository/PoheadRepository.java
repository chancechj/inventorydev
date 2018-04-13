package com.test.mysql.repository;

import com.test.mysql.entity.Pohead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoheadRepository extends JpaRepository<Pohead, Long> {
}
