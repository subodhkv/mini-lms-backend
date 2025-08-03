package com.mini.lms_backend.controller;

import com.mini.lms_backend.dto.ModuleDTO;
import com.mini.lms_backend.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mini.lms_backend.entity.Module;

@RestController
@RequestMapping("/modules")
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService moduleService;

    @PostMapping("/course/{courseId}")
    public ResponseEntity<Module> createModule(@PathVariable Long courseId, @RequestBody Module module) {
        return ResponseEntity.ok(moduleService.createModule(courseId, module));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDTO> getModuleWithProgress(@PathVariable Long id, @RequestParam String userId) {
        return ResponseEntity.ok(moduleService.getModuleWithProgress(id, userId));
    }
}