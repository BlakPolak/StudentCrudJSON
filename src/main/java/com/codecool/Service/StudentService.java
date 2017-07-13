package com.codecool.Service;


import com.codecool.dao.StudentRepository;
import com.codecool.exceptions.NotFoundError;
import com.codecool.exceptions.ValidationError;
import com.codecool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;


@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

//    public void add(Student student){
//        studentRepository.save(student);
//    }

    public void add(Map<String,String> data) {
        Student student = new Student();
        String id;
        String firstName;
        String lastName;
        String klass;
        for (String key : data.keySet()) {
            id = data.get("id");
            firstName = data.get("firstName");
            lastName = data.get("lastName");
            klass = data.get("klass");
            if (id == null || firstName == null || lastName == null || klass == null) {
                throw new ValidationError();
            } else {
                student.setId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setKlass(klass);
            }
        }
        studentRepository.save(student);
    }

    public void update(String id, Map<String, String>  map){
        Student student = studentRepository.findOne(id);

        for (String key: map.keySet()){
            if (key.equals("firstName")){
                String firstNameToUpdate = map.get("firstName");
                if (firstNameToUpdate != "null"){
                    student.setFirstName(firstNameToUpdate);
                }
            }
            if (key.equals("lastName")){
                String lastNameToUpdate = map.get("lastName");
                if (lastNameToUpdate != "null"){
                    student.setLastName(lastNameToUpdate);
                }
            }

            if (key.equals("klass")){
                String klassToUpdate = map.get("klass");
                if (klassToUpdate != "null"){
                    student.setKlass(klassToUpdate);
                }
            }
        }
        studentRepository.save(student);
    }

    public void remove(String id) {
        studentRepository.delete(id);
    }

    public Student findById(String id) {
        try{
            studentRepository.findOne(id);
        } catch (IllegalArgumentException e){
            throw new NotFoundError();
        }
       return studentRepository.findOne(id);
    }
}
