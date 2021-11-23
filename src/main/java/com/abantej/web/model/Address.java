package com.abantej.web.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private Long id;
    private Long profileId;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
}
