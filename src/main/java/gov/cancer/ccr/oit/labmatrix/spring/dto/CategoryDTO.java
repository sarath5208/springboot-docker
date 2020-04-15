package gov.cancer.ccr.oit.labmatrix.spring.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryDTO
{
    private Long id;

    private String name;

    private String description;

    private LocalDateTime createdOn;
}
