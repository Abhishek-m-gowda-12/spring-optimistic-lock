package com.abhishek.springoptimisticlock.repository;

import com.abhishek.springoptimisticlock.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
}
