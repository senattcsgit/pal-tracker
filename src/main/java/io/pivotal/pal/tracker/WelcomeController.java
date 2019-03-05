package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;


@RestController

public class WelcomeController {

    private String str2;
    @Value("${welcome.message}")
    private String str1;

    public WelcomeController(@Value("${welcome.message}") String str)
    {
        this.str2=str;
        // this.str1=str;
        // this.str1=str;
    }

    @GetMapping("/")
    public String sayHello()
    {
        return str2;
    }
}
