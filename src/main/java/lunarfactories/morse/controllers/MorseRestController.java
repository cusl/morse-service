package lunarfactories.morse.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lunarfactories.morse.service.MorseServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@AllArgsConstructor
public class MorseRestController {

    private final MorseServiceImpl service;

    @RequestMapping("/")
    public String getClientIp(HttpServletRequest request) {
        log.info(request.getRemoteAddr());
        return service.translateIp(request.getRemoteAddr());
    }

}
