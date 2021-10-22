package com.abantej.web.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
}
