package com.mini.lms_backend.repository;

import com.mini.lms_backend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}

