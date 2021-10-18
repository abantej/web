package com.abantej.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@ToString
public class Profile {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
}
