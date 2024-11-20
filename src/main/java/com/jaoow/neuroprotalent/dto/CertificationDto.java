package com.jaoow.neuroprotalent.dto;

import com.jaoow.neuroprotalent.entity.Certification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO for {@link Certification}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificationDto implements Serializable {
    private String name;
    private String description;
    private String institution;
    private LocalDate startDate;
    private LocalDate expirationDate;

    public static List<CertificationDto> fromEntityList(List<Certification> certifications) {
        return certifications.stream().map(CertificationDto::fromEntity).collect(java.util.stream.Collectors.toList());
    }

    public static CertificationDto fromEntity(Certification certification) {
        CertificationDto dto = new CertificationDto();
        dto.setName(certification.getName());
        dto.setDescription(certification.getDescription());
        dto.setInstitution(certification.getInstitution());
        dto.setStartDate(certification.getStartDate());
        dto.setExpirationDate(certification.getExpirationDate());
        return dto;
    }

    public static List<Certification> toEntityList(List<CertificationDto> certifications) {
        return certifications.stream().map(CertificationDto::toEntity).collect(Collectors.toList());
    }

    public Certification toEntity() {
        Certification certification = new Certification();
        certification.setName(this.getName());
        certification.setDescription(this.getDescription());
        certification.setInstitution(this.getInstitution());
        certification.setStartDate(this.getStartDate());
        certification.setExpirationDate(this.getExpirationDate());
        return certification;
    }

}