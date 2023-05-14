package ucb.internship.backend.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ucb.internship.backend.dtos.InternshipApiDto;
import ucb.internship.backend.models.Internship;
import ucb.internship.backend.models.InternshipBenefit;
import ucb.internship.backend.models.InternshipMajor;
import ucb.internship.backend.models.InternshipRequirement;
import ucb.internship.backend.models.InternshipRole;

public class InternshipMapper {

    public static InternshipApiDto entityToApiDto(Internship gInternship) {
        List<String> listBenefit = new ArrayList<>();
        List<String> listRoles = new ArrayList<>();
        List<String> listRequeriments = new ArrayList<>();
        List<String> listMajors = new ArrayList<>();
        String date = gInternship.getStartingDate().toString();
        String dateEnd = gInternship.getEndingDate().toString();
        String[] fecha = date.split(" ");
        String fechaInit = fecha[0];
        String[] fechafin = dateEnd.split(" ");
        String fechaEnd = fechafin[0];
        InternshipApiDto internshipApiDto = new InternshipApiDto();
        internshipApiDto.setInternshipId(gInternship.getInternshipId());
        internshipApiDto.setInstitutionId(gInternship.getInstitutionId().getName());
        System.out.println(gInternship.getCityId());
        internshipApiDto.setCityId(gInternship.getCityId().getName());
        internshipApiDto.setTitle(gInternship.getTitle());
        internshipApiDto.setDescription(gInternship.getDescription());
        internshipApiDto.setApproved(gInternship.getIsApproved());
        internshipApiDto.setStartingDate(fechaInit);
        internshipApiDto.setEndingDate(fechaEnd);
        
        for (InternshipBenefit beneficios : gInternship.getInternshipBenefits()) {
            listBenefit.add(beneficios.getDescription());
        }
        for (InternshipRole role : gInternship.getInternshipRoles()) {
            listRoles.add(role.getDescription());
        }
        for (InternshipRequirement requeriment : gInternship.getInternshipRequirements()) {
            listRequeriments.add(requeriment.getDescription());
        }
        for (InternshipMajor major : gInternship.getMajorList()) {
            listMajors.add(major.getMajor().getName());
        }
        internshipApiDto.setMajorList(listMajors);
        internshipApiDto.setInternshipRequirements(listRequeriments);
        internshipApiDto.setInternshipRoles(listRoles);
        internshipApiDto.setInternshipBenefits(listBenefit);
        return internshipApiDto;
    }
    
}
