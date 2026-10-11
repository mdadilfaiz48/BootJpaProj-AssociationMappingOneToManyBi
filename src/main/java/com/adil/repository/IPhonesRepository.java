package com.adil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adil.entity.PhoneNumber;

public interface IPhonesRepository extends JpaRepository<PhoneNumber, Integer> {

}
