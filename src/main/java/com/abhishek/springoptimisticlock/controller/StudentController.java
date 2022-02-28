package com.abhishek.springoptimisticlock.controller;

import com.abhishek.springoptimisticlock.entity.StudentEntity;
import com.abhishek.springoptimisticlock.service.impl.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public void testOptimisticLock(@RequestBody StudentEntity studentEntity) {
        studentService.updateWithRetry(studentEntity);
    }
}
