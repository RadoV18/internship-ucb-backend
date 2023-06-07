package ucb.internship.backend.services;

import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.dtos.ProfileDto;
import ucb.internship.backend.exceptions.FileStorageException;

public interface ProfileService {
    ProfileDto getStudentProfileByEmail(String email);

    String updateStudentProfile(ProfileDto studentProfileDto, MultipartFile cv) throws FileStorageException;
}
