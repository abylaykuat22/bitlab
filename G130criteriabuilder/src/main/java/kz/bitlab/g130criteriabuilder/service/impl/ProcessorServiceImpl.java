package kz.bitlab.g130criteriabuilder.service.impl;

import kz.bitlab.g130criteriabuilder.entity.Processor;
import kz.bitlab.g130criteriabuilder.repository.ProcessorRepository;
import kz.bitlab.g130criteriabuilder.service.ProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessorServiceImpl implements ProcessorService {

    private final ProcessorRepository processorRepository;

    public List<Processor> getAllProcessors() {
        return processorRepository.findAll();
    }
}
