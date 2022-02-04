package com.ecom.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.app.entity.Policy;

@Repository
public interface IPolicyRepository extends CrudRepository<Policy, Integer> {

}
