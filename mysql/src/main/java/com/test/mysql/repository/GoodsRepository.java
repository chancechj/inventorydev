package com.test.mysql.repository;

import com.test.mysql.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    @Query("select t from Goods t where t.goodname like :goodname")
    Page<Goods> findByGoodname(@Param("goodname") String goodname, Pageable pageRequest);


    Goods findByGoodname(String name);


}
