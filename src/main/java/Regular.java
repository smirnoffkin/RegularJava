import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
    public boolean isIpAddress(String ip){
        String filter = "((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}";
        Pattern pattern = Pattern.compile(filter);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public boolean isGuid(String guid) {
        String filter = "([0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12})|" +
                        "(\\(([0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12})\\))|" +
                        "(\\{([0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12})}|" +
                        "(\\[[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12})])";
        Pattern pattern = Pattern.compile(filter);
        Matcher matcher = pattern.matcher(guid);
        return matcher.matches();
    }

    public boolean isValidUrl(String url){
        String filter = "((http(s)?://)?(www\\.)?)?[a-zA-Z0-9@:%._+~#=/][a-zA-Z0-9@:%._+~#=/-]{2,255}" +
                        "[a-zA-Z0-9@:%._+~#=/]\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_+.~#?&/=]*)";
        Pattern pattern = Pattern.compile(filter);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public boolean isCorrectPassword(String password){
        String filter = "(?=[\\w]*[0-9])(?=[\\w]*[a-z])(?=[\\w]*[A-Z])([\\w]*){8,}";
        Pattern pattern = Pattern.compile(filter);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
