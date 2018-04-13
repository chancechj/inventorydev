package com.test.mysql.repository;

import com.test.mysql.entity.Poitems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoitemsRepository extends JpaRepository<Poitems,Long> {
}
