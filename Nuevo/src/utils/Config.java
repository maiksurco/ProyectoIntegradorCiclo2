package utils;

import java.util.regex.Pattern;

public class Config {

    public static final String DEFAULT_DATE_STRING_FORMAT_PE = "dd/MM/yyyy";
    public static final String DEFAULT_DATE_STRING_FORMAT_PE_L = "dd/MM/yyyy HH:mm:ss.SSS";
    public static final String DEFAULT_DATE_STRING_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DECIMAL_STRING_FORMAT = "#,##0.00";
    public static final String DEFAULT_DECIMAL_FORMAT = "###0.0000";
    
    //https://www.baeldung.com/java-check-string-number
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

}
