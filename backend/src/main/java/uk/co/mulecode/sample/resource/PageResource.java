package uk.co.mulecode.sample.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.String.format;

@Slf4j
@Controller
@RequiredArgsConstructor
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

    @GetMapping("/login/**")
    public String welcome() {
        return "login";
    }

}
