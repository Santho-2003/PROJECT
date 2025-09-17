package com.Santho.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController 
{
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public StudentEntity createStudent(@RequestBody StudentEntity students) 
    {
        return studentRepository.save(students);
    }

    @GetMapping
    public List<StudentEntity> getAllStudents() 
    {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public StudentEntity getStudentById(@PathVariable int id)
    {
        return studentRepository.findById(id)
                .orElseThrow(() -> 
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + id));
    }
}

