package kz.bitlab.g128finalproject.service;

import kz.bitlab.g128finalproject.entity.WorkingFormat;
import kz.bitlab.g128finalproject.repository.WorkingFormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingFormatService {

    @Autowired
    private WorkingFormatRepository workingFormatRepository;

    public Double getBonusPercentage(WorkingFormat workingFormat) {
        if (workingFormat == null) {
            return null;
        }

        return switch (workingFormat.getName()) {
            case "Полная занятость" -> 2.0;
            case "Гибрид" -> 1.5;
            case "Уделанная работа" -> 1.2;
            case "Часовая" -> 1.0;
            default -> throw new IllegalStateException("UNSUPPORTED format " + workingFormat.getName());
        };
    }

    public List<WorkingFormat> getAllWorkingFormats() {
        return workingFormatRepository.findAll();
    }

    public WorkingFormat getWorkingFormatById(Long id) {
        return workingFormatRepository.findById(id).orElse(null);
    }
}
