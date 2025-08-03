package com.mini.lms_backend.dto;

import com.mini.lms_backend.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private double progress;

    public CourseDTO(Course course, double progress) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.description = course.getDescription();
        this.progress = progress;
    }
}

