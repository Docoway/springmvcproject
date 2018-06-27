package org.kb4md.rest.TFInformation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="/ceshi")
public class ceshiController {

    @GetMapping(value="/hello")
    public String ceshi1(){
        return "hello";
    }
}
