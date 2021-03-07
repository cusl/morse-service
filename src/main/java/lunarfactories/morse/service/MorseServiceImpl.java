package lunarfactories.morse.service;

import lunarfactories.morse.service.api.MorseService;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static lunarfactories.morse.service.api.ApiConstants.*;

@Service
public class MorseServiceImpl implements MorseService {

    private final HashMap<Character, String> vocabulary = new HashMap<>();

    @PostConstruct
    private void makeVocabulary() {
        for (int i = 0; i < IP_CHARS.length; i++) {
            vocabulary.put(IP_CHARS[i], CODE[i]);
        }
    }

    @Override
    public String translateIp(String ip) {
        if (!validate(ip))
            return "Wrong IP";
        StringBuilder res = new StringBuilder();
        for (char c: ip.toCharArray()) {
            res.append(vocabulary.get(c));
        }
        return res.toString();
    }

    private boolean validate(String ip) {
        return Objects.nonNull(ip) && ip.matches(IP_PATTERN);
    }

}
