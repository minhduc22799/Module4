package com.example.validateform.repository;

import com.example.validateform.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<User,Long> {

}
