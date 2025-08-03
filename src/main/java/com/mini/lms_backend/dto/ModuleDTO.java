package com.mini.lms_backend.dto;
import com.mini.lms_backend.entity.Module;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModuleDTO {
    private Long id;
    private String title;
    private String summary;
    private double progress;

    public ModuleDTO(Module module, double progress) {
        this.id = module.getId();
        this.title = module.getTitle();
        this.summary = module.getSummary();
        this.progress = progress;
    }
}