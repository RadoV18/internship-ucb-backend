package ucb.internship.backend.mappers;

import ucb.internship.backend.dtos.InternshipQuestionDto;
import ucb.internship.backend.models.InternshipQuestion;

public class InternshipQuestionMapper {
    public static InternshipQuestionDto entityToDto(InternshipQuestion internshipQuestion) {
        InternshipQuestionDto internshipQuestionDto = new InternshipQuestionDto();
        internshipQuestionDto.setId(internshipQuestion.getInternshipQuestionId());
        internshipQuestionDto.setDescription(internshipQuestion.getDescription());
        return internshipQuestionDto;
    }
}
