package com.example.todomanagement.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoDto {
    private Long id;
    private String title;
    private  String description;
    private boolean completed;
}
