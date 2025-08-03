package com.mini.lms_backend.controller;
import com.mini.lms_backend.entity.Lesson;
import com.mini.lms_backend.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @PostMapping("/module/{moduleId}")
    public ResponseEntity<Lesson> createLesson(@PathVariable Long moduleId, @RequestBody Lesson lesson) {
        return ResponseEntity.ok(lessonService.createLesson(moduleId, lesson));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.getLessonById(id));
    }
}
