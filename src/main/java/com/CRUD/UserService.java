package com.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public List<User> getUserList()
    {
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User search(Long id) throws UserNotFoundException {
        Optional<User> findUser = repo.findById(id);
        if (!findUser.isEmpty())
            return findUser.get();
        throw new UserNotFoundException("404 ERROR - USER NOT FOUND");
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
