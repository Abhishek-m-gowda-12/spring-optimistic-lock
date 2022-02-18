package com.abhishek.springoptimisticlock.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RetryService {
    @Retryable(include = {NullPointerException.class, IndexOutOfBoundsException.class}, maxAttemptsExpression = "${retry.maxAttempts}", backoff = @Backoff(delayExpression = "${retry.maxDelay}"), listeners = "defaultRetryListener")
    public void retryWhenError(){
        log.info("operation = retryWhenError, result = IN_PROGRESS");
        throw new NullPointerException("");
    }
}
