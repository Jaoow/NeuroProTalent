package com.jaoow.neuroprotalent.dto;

import com.jaoow.neuroprotalent.entity.TechnicalSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO for {@link TechnicalSkill}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnicalSkillDto implements Serializable {
    private String name;
    private String description;
    private String level;

    public static List<TechnicalSkillDto> fromEntityList(List<TechnicalSkill> technicalSkills) {
        return technicalSkills.stream().map(TechnicalSkillDto::fromEntity).collect(Collectors.toList());
    }

    public static TechnicalSkillDto fromEntity(TechnicalSkill technicalSkill) {
        TechnicalSkillDto dto = new TechnicalSkillDto();
        dto.setName(technicalSkill.getName());
        dto.setDescription(technicalSkill.getDescription());
        dto.setLevel(technicalSkill.getLevel());
        return dto;
    }

    public static List<TechnicalSkill> toEntityList(List<TechnicalSkillDto> technicalSkills) {
        return technicalSkills.stream().map(TechnicalSkillDto::toEntity).collect(Collectors.toList());
    }

    public TechnicalSkill toEntity() {
        TechnicalSkill technicalSkill = new TechnicalSkill();
        technicalSkill.setName(this.getName());
        technicalSkill.setDescription(this.getDescription());
        technicalSkill.setLevel(this.getLevel());
        return technicalSkill;
    }
}