package com.abhishek.springoptimisticlock.controller;

import com.abhishek.spring.retry.service.impl.RetryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {
    private final RetryService retryService;

    public Controller(RetryService retryService) {
        this.retryService = retryService;
    }

    @GetMapping
    public void testRetry() {
        retryService.retryWhenError();
    }
}
