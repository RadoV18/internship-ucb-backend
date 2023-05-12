package ucb.internship.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.MajorDto;
import ucb.internship.backend.mappers.MajorMapper;
import ucb.internship.backend.models.Major;
import ucb.internship.backend.repositories.MajorRepository;
import ucb.internship.backend.services.MajorService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorRepository majorRepository;

    public List<MajorDto> getAllMajors(String sort) {
        ArrayList<MajorDto> result = new ArrayList<>();
        Sort sortProperty = Sort.by(Sort.Direction.ASC, sort);
        List<Major> majors = majorRepository.findAll(sortProperty);
        for(Major major : majors) {
            result.add(MajorMapper.entityToDto(major));
        }
        return result;
    }
}
