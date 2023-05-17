package com.protonema.test.pendataanbukutest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {
    
    private String title;
    private String author;
    private String publisher;
    private Long publicationYear;
    private Long id;
}
