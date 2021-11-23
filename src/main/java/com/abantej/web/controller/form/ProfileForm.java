package com.abantej.web.controller.form;

import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProfileForm {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
}
