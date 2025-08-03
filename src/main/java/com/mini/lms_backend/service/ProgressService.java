package com.mini.lms_backend.service;

import com.mini.lms_backend.entity.Lesson;
import com.mini.lms_backend.entity.LessonProgress;
import com.mini.lms_backend.repository.LessonProgressRepository;
import com.mini.lms_backend.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgressService {
    private final LessonProgressRepository progressRepo;
    private final LessonRepository lessonRepo;

    public LessonProgress markCompleted(Long lessonId, String userId) {
        Lesson lesson = lessonRepo.findById(lessonId).orElseThrow();
        LessonProgress progress = progressRepo.findByLessonIdAndUserId(lessonId, userId)
                .orElse(new LessonProgress());
        progress.setUserId(userId);
        progress.setLesson(lesson);
        progress.setCompleted(true);
        return progressRepo.save(progress);
    }
}