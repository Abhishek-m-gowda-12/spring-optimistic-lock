package com.abhishek.springoptimisticlock.service.impl;

import com.abhishek.springoptimisticlock.entity.StudentEntity;
import com.abhishek.springoptimisticlock.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;

@Service
@Slf4j
public class RetryService {
    private final StudentRepository studentRepository;

    public RetryService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Retryable(include = {ObjectOptimisticLockingFailureException.class, OptimisticLockException.class}, maxAttemptsExpression = "${retry.maxAttempts}", backoff = @Backoff(delayExpression = "${retry.maxDelay}"), listeners = "defaultRetryListener")
    public void retryWhenError(StudentEntity studentEntity) throws ObjectOptimisticLockingFailureException, OptimisticLockException {
        log.info("operation = retryWhenError, result = IN_PROGRESS");

        StudentEntity studentEntity1 = studentRepository.findById(studentEntity.getId()).orElse(null);

        BeanUtils.copyProperties(studentEntity, studentEntity1);

        studentRepository.save(studentEntity1);

    }
}
