package com.company.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDTO {
	
    private Integer id;
    private String name;
    private String description;
}
