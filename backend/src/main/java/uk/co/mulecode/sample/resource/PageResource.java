package uk.co.mulecode.sample.resource;

import static java.lang.String.format;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class PageResource {

  @Value("${server.servlet.context-path:''}")
  private String basePath;

  @GetMapping("/")
  public void index(HttpServletResponse response) throws IOException {
    response.sendRedirect(format("%s/ui", basePath));
  }

  @GetMapping("/ui/**")
  public String indexUi() {
    return "index";
  }

}
