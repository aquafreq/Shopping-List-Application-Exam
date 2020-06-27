package java_web_exam.demo.constants;

public class GlobalConstants {
    public static final String USERS_REGISTER = "/users/register";
    public static final String USERS_LOGIN = "/users/login";
    public static final String INDEX = "/";
    public static final String ERROR = "/error";
    public static final String STATIC = "/static/*";
    public static final String ADMIN_HOME = "/admin/home";

    public static final String NO_SUCH_USER_FOUND = "No such user found";
    public static final String USER_USERNAME_EXISTS = "Such user with this username already exists";
    public static final String USER_EMAIL_EXISTS = "Such user with this email already exists";

    public static final String USERNAME_LENGTH_VALIDATION = "Username length must be between 3 and 20 characters (inclusive 3 and 20).";
    public static final String PASSWORD_LENGTH_VALIDATION = "Password length must be between 3 and 20 characters (inclusive 3 and 20).";

    public static final String NULL_FOR_EMAIL = "No null for email";
    public static final String VALID_EMAIL = "Enter valid email";
    public static final String BLANK_VALUES_FOR_FIELD = "No null or blank values for field";
    public static final String DESCRIPTION_LENGTH = "Description min length must be minimum 5(inclusive) characters";
    public static final String POSITIVE_PRICE_NUMBER = "Price must be a positive number";
    public static final String DATE_CANNOT_BE_IN_THEPAST = "Date and Time, that cannot be in the past";
    public static final String CATEGOR_NOT_NULL = "Category cannot be null.";

}
