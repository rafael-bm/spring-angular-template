package uk.co.mulecode.sample.resource;

import java.time.Instant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.mulecode.sample.resource.dto.UserDetailsResponse;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SampleResource {

  @GetMapping("/me")
  public UserDetailsResponse principalDetails(OAuth2AuthenticationToken principal) {

    return UserDetailsResponse.builder()
        .email(principal.getPrincipal().getAttributes().get("email").toString())
        .picture(principal.getPrincipal().getAttributes().get("picture").toString())
        .name(principal.getPrincipal().getAttributes().get("name").toString())
        .locale(principal.getPrincipal().getAttributes().get("locale").toString())
        .exp(Instant.parse(principal.getPrincipal().getAttributes().get("exp").toString()))
        .build();
  }

}
