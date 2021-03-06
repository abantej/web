package com.abantej.web.model;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Profile {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
}
