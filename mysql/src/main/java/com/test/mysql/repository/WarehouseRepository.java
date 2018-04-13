package com.test.mysql.repository;

import com.test.mysql.entity.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    @Query("select t from Warehouse t where t.storagename like :storagename")
    Page<Warehouse> findByStoragename(@Param("storagename") String storagename, Pageable pageRequest);

    Warehouse findByStoragename(String name);

}
