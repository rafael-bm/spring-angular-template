package com.mulecode.sample;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;

import com.mulecode.sample.stub.StubBase;
import java.util.Set;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.mockserver.configuration.ConfigurationProperties;
import org.mockserver.integration.ClientAndServer;
import org.reflections.Reflections;

@Slf4j
public class MockServer {

  private Integer port;
  private ClientAndServer clientAndServer;

  public MockServer(int port) {
    this.port = port;
  }

  public void startServer() {
    log.info("Starting frontend stub server");
    clientAndServer = startClientAndServer(port);
    ConfigurationProperties.enableCORSForAllResponses(true);
    registerStubs(clientAndServer);
  }

  public void stopServer() {
    log.info("Stopping frontend stub server");
    clientAndServer.stop();
  }

  public Boolean isRunning() {
    return clientAndServer.isRunning();
  }

  @SneakyThrows
  private static void registerStubs(ClientAndServer clientAndServer) {
    Reflections reflections = new Reflections("com.mulecode.sample");
    Set<Class<? extends StubBase>> subTypes = reflections.getSubTypesOf(StubBase.class);
    for (Class<? extends StubBase> aClass : subTypes) {
      log.info("stub: {}", aClass.getName());
      StubBase newInstance = aClass.getConstructor().newInstance();
      newInstance.init(clientAndServer);
    }
  }


}
