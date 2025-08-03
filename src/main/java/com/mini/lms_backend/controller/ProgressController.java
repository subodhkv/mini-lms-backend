package com.mini.lms_backend.controller;
import com.mini.lms_backend.entity.Lesson;
import com.mini.lms_backend.entity.LessonProgress;
import com.mini.lms_backend.repository.LessonProgressRepository;
import com.mini.lms_backend.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class ProgressController {
    private final LessonProgressRepository progressRepo;
    private final LessonRepository lessonRepo;

    @PostMapping("/{lessonId}/progress")
    public ResponseEntity<LessonProgress> markCompleted(@PathVariable Long lessonId, @RequestParam String userId) {
        Lesson lesson = lessonRepo.findById(lessonId).orElseThrow();
        LessonProgress progress = progressRepo.findByLessonIdAndUserId(lessonId, userId)
                .orElse(new LessonProgress());
        progress.setUserId(userId);
        progress.setLesson(lesson);
        progress.setCompleted(true);
        return ResponseEntity.ok(progressRepo.save(progress));
    }
}