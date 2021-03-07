package lunarfactories.morse.service;

import lunarfactories.morse.service.api.MorseService;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import static lunarfactories.morse.service.api.ApiConstants.*;

@Service
public class MorseServiceImpl implements MorseService {

    private HashMap<Character, String> vocabulary = new HashMap<>();

    @PostConstruct
    private void makeVocabulary() {
        for (int i = 0; i < IP_CHARS.length; i++) {
            vocabulary.put(IP_CHARS[i], CODE[i]);
        }
    }

    @Override
    public String translateIp(String ip) {
        String res = "";
        if (isIp(ip)) {
            for (int i = 0; i < ip.length(); i++) {
                res = res + vocabulary.get(ip.charAt(i));
            }
        } else {
            res = "Not IP";
        }
        return res;
    }

    private Boolean isIp(String ip) {
        return ip.matches(IP_PATTERN);
    }

}
