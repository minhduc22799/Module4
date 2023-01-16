package com.example.phone.repository;

import com.example.phone.model.Smartphone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long> {
}
