package com.example.validateform.service;

import com.example.validateform.model.User;
import com.example.validateform.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
@Autowired
   private IUserRepository iUserRepository;


    @Override
    public Iterable<User> findAll() {
       return iUserRepository.findAll();
    }
    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }



    @Override
    public void remove(Long id) {

    }
}
