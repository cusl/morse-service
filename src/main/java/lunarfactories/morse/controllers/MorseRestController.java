package lunarfactories.morse.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MorseRestController {

    @RequestMapping("/")
    public String getClientIp(HttpServletRequest request) {
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteHost());
        return request.getRemoteAddr();
    }

}
