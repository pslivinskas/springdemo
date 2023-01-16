package lt.povilas.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/customermapping")
public class CustomerController {
@GetMapping(path = "/test")
    public @ResponseBody String getTestPage(){
        return "This is some test from Spring";
    }
}
