package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlgebraController {
    private Logger logger = LoggerFactory.getLogger(AlgebraController.class);

    @GetMapping("/test")
    public String testServices(){
        return "Services Up";
    }
}
