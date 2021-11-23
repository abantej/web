package com.abantej.web.dto;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private Long profileId;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
}
