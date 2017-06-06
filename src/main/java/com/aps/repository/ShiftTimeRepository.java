package com.aps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aps.domain.ShiftTime;

@Repository
public interface ShiftTimeRepository extends CrudRepository<ShiftTime, Integer> {

}