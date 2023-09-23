package org.springers.waa_alumniplatform.dto.authDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Token {
    private String token;
    private int id;
    private String name;
}
