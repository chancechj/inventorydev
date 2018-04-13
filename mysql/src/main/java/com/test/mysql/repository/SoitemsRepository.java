package com.test.mysql.repository;

import com.test.mysql.entity.Soitems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoitemsRepository extends JpaRepository<Soitems,Long> {
}
