package lunarfactories.morse.service.api;

public interface ApiConstants {
    char[] IP_CHARS = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.'};
    String[] CODE = {".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", ".-.-.-"};
    String IP_PATTERN = "((\\d|[01]\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(\\d|[01]\\d{2}|2[0-4]\\d|25[0-5])";
}
