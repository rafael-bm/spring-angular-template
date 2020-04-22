package com.mulecode.sample;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

  private static int port = 31000;

  public static void main(String[] args) throws Exception {

    log.info("Starting frontend stub server");
    var mock = new MockServer(port);
    mock.startServer();
    log.info("Mock server is running: {}", mock.isRunning());
    log.info("Press any key twice to stop.");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    log.info("Stopping, please wait until it stops gracefully.");
    mock.stopServer();
  }



}
