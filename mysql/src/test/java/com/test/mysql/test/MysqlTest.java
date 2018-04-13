package com.test.mysql.test;

import com.test.mysql.entity.Users;
import com.test.mysql.repository.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class MysqlTest {
    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    PoheadRepository poheadRepository;
    @Autowired
    PoitemsRepository poitemsRepository;
    @Autowired
    SoheadRepository soheadRepository;
    @Autowired
    SoitemsRepository soitemsRepository;
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    SuppliersRepository suppliersRepository;
    @Autowired
    UsersRepository usersRepository;


    @Before
    public void initData(){
        customersRepository.deleteAll();
        goodsRepository.deleteAll();
        poheadRepository.deleteAll();
        poitemsRepository.deleteAll();
        soheadRepository.deleteAll();
        soitemsRepository.deleteAll();
        storageRepository.deleteAll();
        suppliersRepository.deleteAll();
        usersRepository.deleteAll();

        Users user = new Users();
        user.setUsername("chj");
        BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
        user.setPassword(bpe.encode("654321"));
        user.setAddtime(new Date());
        user.setEmail("87654321@qq.com");
        user.setPostion("admin");
        usersRepository.save(user);
        Assert.notNull(user.getUserid());
    }

    @Test
    public void insertUserRoles(){
        Users user = usersRepository.findByUsername("chj");
        System.out.print("这是User："+ user.getUsername());
        Assert.notNull(user);
    }
}
