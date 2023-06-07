package ucb.internship.backend.services;

import org.springframework.web.multipart.MultipartFile;

import ucb.internship.backend.dtos.GraduateDto;
import ucb.internship.backend.dtos.InstitutionSignUpDto;
import ucb.internship.backend.dtos.StudentDto;
import ucb.internship.backend.dtos.VerificationCodeDto;
import ucb.internship.backend.exceptions.FileStorageException;

public interface SignUpService {

    /**
     * signs up an institution
     * 
     * @param institutionSignUpDto the institution to sign up.
     * @param image                the logo of the institution that will be used as
     *                             the profile picture.
     * @return a uuid and the email that will be used to verify the user.
     */
    public VerificationCodeDto institutionSignUp(InstitutionSignUpDto institutionSignUpDto, MultipartFile image)
            throws FileStorageException;

    /**
     * signs up a student
     * 
     * @param studentDto     the student to sign up.
     * @param profilePicture the profile picture of the student.
     * @param cvFile         the cv of the student.
     * @return a uuid and the email that will be used to verify the user.
     */
    public VerificationCodeDto studentSignUp(StudentDto studentDto, MultipartFile profilePicture, MultipartFile cvFile)
            throws FileStorageException;

    /**
     * signs up a graduate student
     * 
     * @param graduateDto    the student to sign up.
     * @param profilePicture the profile picture of the student.
     * @param cvFile         the cv of the student.
     * @return a uuid and the email that will be used to verify the user.
     */
    public VerificationCodeDto graduateSignUp(GraduateDto graduateDto, MultipartFile profilePicture,
            MultipartFile cvFile) throws FileStorageException;
}
