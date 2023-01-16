package com.example.validateform.service;

import com.example.validateform.model.User;
import com.example.validateform.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
@Autowired
   private IUserRepository iUserRepository;


    @Override
    public Iterable<User> findAll() throws Exception {
        if (true) throw new Exception("a dummy exception");
       return iUserRepository.findAll();
    }
    @Override
    public void save(User user) throws DuplicateEmailException {
        try {
            iUserRepository.save(user);
        }catch (DataIntegrityViolationException e){
            throw new DuplicateEmailException();
        }
    }

    @Override
    public Optional<User> findById(Long id) throws Exception {
        Optional<User> customerOptional = iUserRepository.findById(id);
        if (!customerOptional.isPresent()) {
            throw new Exception("customer not found!");
        }
        return customerOptional;
    }



    @Override
    public void remove(Long id) {

    }
}
