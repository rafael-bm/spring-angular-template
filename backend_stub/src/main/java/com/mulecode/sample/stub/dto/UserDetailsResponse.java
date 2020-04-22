package com.mulecode.sample.stub.dto;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailsResponse {

  private String name;
  private String picture;
  private String email;
  private String locale;
  private Instant exp;
}
