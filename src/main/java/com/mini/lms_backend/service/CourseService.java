package com.mini.lms_backend.service;

import com.mini.lms_backend.dto.CourseDTO;
import com.mini.lms_backend.entity.Course;
import com.mini.lms_backend.entity.LessonProgress;
import com.mini.lms_backend.repository.CourseRepository;
import com.mini.lms_backend.repository.LessonProgressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mini.lms_backend.entity.Module;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepo;
    private final LessonProgressRepository progressRepo;

    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public CourseDTO getCourseWithProgress(Long courseId, String userId) {
        Course course = courseRepo.findById(courseId).orElseThrow();
        List<LessonProgress> progresses = progressRepo.findByLessonModuleCourseIdAndUserId(courseId, userId);
        long totalModules = course.getModules().size();

        double courseProgress = 0;
        for (Module m : course.getModules()) {
            long completedLessons = progresses.stream()
                    .filter(p -> p.getLesson().getModule().getId().equals(m.getId()) && p.isCompleted())
                    .count();
            long totalLessons = m.getLessons().size();
            double moduleProgress = totalLessons == 0 ? 0 : (completedLessons * 100.0 / totalLessons);
            courseProgress += moduleProgress;
        }
        double averageProgress = totalModules == 0 ? 0 : (courseProgress / totalModules);
        return new CourseDTO(course, averageProgress);
    }
}
