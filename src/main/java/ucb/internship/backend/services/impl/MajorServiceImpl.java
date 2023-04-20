package ucb.internship.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.MajorDto;
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
    public List<MajorDto> findAllMajors() {
        List<Major> majors = majorRepository.findAll();
        List<MajorDto> majorDtos = new ArrayList<>();
        for (Major major : majors) {
            majorDtos.add(new MajorDto(major.getMajorId(), major.getName()));
        }
        return majorDtos;
    }
}
