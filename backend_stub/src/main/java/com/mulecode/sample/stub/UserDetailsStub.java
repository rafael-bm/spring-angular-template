package com.mulecode.sample.stub;

import com.mulecode.sample.stub.dto.UserDetailsResponse;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class UserDetailsStub extends StubBase {

  @Override
  void configure(ClientAndServer mockServer) {
    mockServer
        .when(
            HttpRequest.request()
                .withMethod("GET").withPath("/api/me")
        )
        .respond(
            HttpResponse.response()
                .withStatusCode(200)
                .withBody(toJson(
                    UserDetailsResponse.builder()
                        .email(getFaker().internet().emailAddress())
                        .picture("https://lh3.googleusercontent.com/a-/AOh14GhPMRht5KL77QPzLF2HjtQOcJlhBOmCikRYGDm5RQ=s96-c")
                        .name(getFaker().name().fullName())
                        .locale(getFaker().address().countryCode())
                        .exp(Instant.now())
                        .build()
                ))
                .withDelay(TimeUnit.SECONDS, 1)
        );
  }
}
