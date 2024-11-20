package com.jaoow.neuroprotalent.dto;

import com.jaoow.neuroprotalent.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Employee}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Serializable {
    private String name;
    private String email;
    private String phone;
    private List<CertificationDto> certifications;
    private List<TechnicalSkillDto> technicalSkills;
    private int experienceTime;
    private String linkedInUrl;

    public static EmployeeDto fromEntity(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setPhone(employee.getPhone());
        dto.setCertifications(CertificationDto.fromEntityList(employee.getCertifications()));
        dto.setTechnicalSkills(TechnicalSkillDto.fromEntityList(employee.getTechnicalSkills()));
        dto.setExperienceTime(employee.getExperienceTime());
        dto.setLinkedInUrl(employee.getLinkedInUrl());
        return dto;
    }

    public Employee toEntity() {
        Employee employee = new Employee();
        employee.setName(this.getName());
        employee.setEmail(this.getEmail());
        employee.setPhone(this.getPhone());
        employee.setCertifications(CertificationDto.toEntityList(this.getCertifications()));
        employee.setTechnicalSkills(TechnicalSkillDto.toEntityList(this.getTechnicalSkills()));
        employee.setExperienceTime(this.getExperienceTime());
        employee.setLinkedInUrl(this.getLinkedInUrl());
        return employee;
    }

}