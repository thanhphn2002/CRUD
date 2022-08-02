package com.CRUD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepoTest {
    @Autowired
    private UserRepo repo;

    @Test
    public void testAdd()
    {
        User user = new User();
        user.setName("Nhat Thanh");
        user.setAge(20);
        user.setGender("Male");

        repo.save(user);
    }

    @Test
    public void testUpdate()
    {
        long userId = 12;
        Optional<User> searchUserId = repo.findById(userId);
        User user = searchUserId.get();

        user.setName("Nhat Thong");
        user.setAge(23);
        repo.save(user);
    }

//    @Test
//    public void testDelete()
//    {
//        long userId = 3;
//        repo.deleteById(userId);
//    }
}
