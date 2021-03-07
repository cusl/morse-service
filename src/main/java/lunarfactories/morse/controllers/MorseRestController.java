package lunarfactories.morse.controllers;

import lunarfactories.morse.service.MorseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MorseRestController {

    @Autowired
    MorseServiceImpl service;

    @RequestMapping("/")
    public String getClientIp(HttpServletRequest request) {
        System.out.println(request.getRemoteAddr());
        return service.translateIp(request.getRemoteAddr());
    }

}
