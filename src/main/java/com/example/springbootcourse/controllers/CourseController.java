package com.example.springbootcourse.controllers;

import com.example.springbootcourse.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    List<Course> courseList = new ArrayList<>();


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Course> createCourse (@RequestBody Course course) {
        System.out.println(course.getName());
        System.out.println(course.getLengthInSecond());
        courseList.add(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getCourses () {

        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.POST)
    public Course buyCourse (@PathVariable (value = "id") Long id) {
        System.out.println("buyCourse");
        return getCourseById(id);
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public Course buyCourse2 (@RequestParam (value = "id") Long id) {
        System.out.println("buyCourse2");
        return getCourseById(id);
    }

    private Course getCourseById (Long id) {
        Course course = null;
        for (Course c : courseList) {
            if (c.getId().equals(id)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            System.out.println("null");
        }
        return course;
    }


}
