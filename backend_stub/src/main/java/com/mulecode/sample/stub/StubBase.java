package com.mulecode.sample.stub;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.SneakyThrows;
import org.mockserver.integration.ClientAndServer;

public abstract class StubBase {

  @Getter
  private Faker faker = Faker.instance();

  abstract void configure(ClientAndServer mockServer);

  public void init(ClientAndServer mockServer) {
    configure(mockServer);
  }

  @SneakyThrows
  public String toJson(Object object) {
    return objectMapper().writeValueAsString(object);
  }

  public ObjectMapper objectMapper(){
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.findAndRegisterModules();
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    return objectMapper;
  }
}
