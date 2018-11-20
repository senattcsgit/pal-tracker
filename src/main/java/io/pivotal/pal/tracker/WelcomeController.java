package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;


@RestController

public class WelcomeController {
    @Value("${welcome.message}")
    private String str;

    @GetMapping("/")
    public String sayHello()
    {

        return str.toString();
           }
}
