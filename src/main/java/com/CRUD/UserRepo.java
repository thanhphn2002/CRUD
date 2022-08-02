package com.CRUD;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    public Long countById(Long id);
}
