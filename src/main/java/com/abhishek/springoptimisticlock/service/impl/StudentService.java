package com.abhishek.springoptimisticlock.service.impl;

import com.abhishek.springoptimisticlock.entity.StudentEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final RetryService retryService;

    public StudentService(RetryService retryService) {
        this.retryService = retryService;
    }

    public void updateWithRetry(StudentEntity studentEntity){
        retryService.retryWhenError(studentEntity);
    }
}
