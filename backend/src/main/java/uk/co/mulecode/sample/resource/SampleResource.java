package uk.co.mulecode.sample.resource;

import java.time.Instant;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SampleResource {

  @GetMapping("/samples")
  public Map<String, Object> getSamples() {

    return Map.of("time", Instant.now().toString());
  }

}
