package com.mini.lms_backend.repository;

import com.mini.lms_backend.entity.LessonProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface LessonProgressRepository extends JpaRepository<LessonProgress, Long> {
    List<LessonProgress> findByLessonModuleCourseIdAndUserId(Long courseId, String userId);
    List<LessonProgress> findByLessonModuleIdAndUserId(Long moduleId, String userId);
    Optional<LessonProgress> findByLessonIdAndUserId(Long lessonId, String userId);
}