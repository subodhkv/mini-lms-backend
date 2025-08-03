package com.mini.lms_backend.service;

import com.mini.lms_backend.dto.ModuleDTO;
import com.mini.lms_backend.entity.Course;
import com.mini.lms_backend.entity.LessonProgress;
import com.mini.lms_backend.repository.CourseRepository;
import com.mini.lms_backend.repository.LessonProgressRepository;
import com.mini.lms_backend.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mini.lms_backend.entity.Module;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleService {
    private final CourseRepository courseRepo;
    private final ModuleRepository moduleRepo;
    private final LessonProgressRepository progressRepo;

    public Module createModule(Long courseId, Module module) {
        Course course = courseRepo.findById(courseId).orElseThrow();
        module.setCourse(course);
        return moduleRepo.save(module);
    }

    public ModuleDTO getModuleWithProgress(Long moduleId, String userId) {
        Module module = moduleRepo.findById(moduleId).orElseThrow();
        List<LessonProgress> progresses = progressRepo.findByLessonModuleIdAndUserId(moduleId, userId);
        long completed = progresses.stream().filter(LessonProgress::isCompleted).count();
        long total = module.getLessons().size();
        double progressPercent = total == 0 ? 0 : (completed * 100.0 / total);
        return new ModuleDTO(module, progressPercent);
    }
}
