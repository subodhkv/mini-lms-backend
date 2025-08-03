package com.mini.lms_backend.service;

import com.mini.lms_backend.entity.Lesson;
import com.mini.lms_backend.repository.LessonRepository;
import com.mini.lms_backend.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mini.lms_backend.entity.Module;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final ModuleRepository moduleRepo;
    private final LessonRepository lessonRepo;

    public Lesson createLesson(Long moduleId, Lesson lesson) {
        Module module = moduleRepo.findById(moduleId).orElseThrow();
        lesson.setModule(module);
        return lessonRepo.save(lesson);
    }

    public Lesson getLessonById(Long id) {
        return lessonRepo.findById(id).orElseThrow();
    }
}
