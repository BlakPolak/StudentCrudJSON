package com.codecool.controller;

import com.codecool.Service.StudentService;
import com.codecool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//import com.example.demo.dao.StudentRepository;

@RestController
@RequestMapping("/students" )
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Student> index(){
        return studentService.getAll();
    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(method = RequestMethod.POST, value = "")
//    public void create(@RequestBody Student student){
//        studentService.add(student);
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, value = "")
    public void create(@RequestBody Map<String,String> data){
        studentService.add(data);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Student show(@PathVariable String id){
        return studentService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void update(@PathVariable String id, @RequestBody Map<String,String> data){
        studentService.update(id, data);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void destroy(@PathVariable String id){
        studentService.remove(id);
    }
}
