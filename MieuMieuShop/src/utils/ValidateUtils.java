package utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String USERNAME_PATTERN ="^[a-zA-Z0-9_]{4,20}$";
    public static final String PASSWORD_PATTERN ="^([a-zA-Z0-9]{8,})";
    public static final String NAME_REGEX ="^([A-Z]+[a-z]*[ ]?)+$";
    public static final String PHONE_REGEX ="(84|0[3,5,7,9])[0-9]{8}\\b";
    public static final String EMAIL_REGEX ="^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";


    public static boolean isUserNameValid(String userName) {
        return Pattern.compile(USERNAME_PATTERN).matcher(userName).matches();
    }


    public static boolean isPasswordValid(String password){
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }

    public static boolean isNameValid(String name){
        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }

    public static boolean isPhoneValid(String number){
        return Pattern.compile(PHONE_REGEX).matcher(number).matches();
    }

    public static boolean isEmailValid(String email){
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }
}
