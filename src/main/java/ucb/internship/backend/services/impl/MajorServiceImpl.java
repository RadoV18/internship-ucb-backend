package ucb.internship.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.MajorDTO;
import ucb.internship.backend.models.Major;
import ucb.internship.backend.repositories.MajorRepository;
import ucb.internship.backend.services.MajorService;

import java.util.ArrayList;
import java.util.List;
@Service
public class MajorServiceImpl implements MajorService {
    private MajorRepository majorRepository;
    @Autowired
    public MajorServiceImpl(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    @Override
    public List<MajorDTO> findAllMajors() {
        List<Major> majors = majorRepository.findAll();
        List<MajorDTO> majorDTOS = new ArrayList<>();
        for (Major major : majors) {
            majorDTOS.add(new MajorDTO(major.getMajorId(), major.getName()));
        }
        return majorDTOS;
    }
}
