package com.example.webnghenhac.exeception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(999, "Uncategorized error"),
    USERNAME_EXISTED(1001, "Username already exists"),
    USERNAME_INVALID(1002, "Username must be from 8 to 24 characters"),
    PASSWORD_INVALID(1003, "Password must be from 8 to 24 characters"),
    EMAIL_BLANK(1004, "Email cannot be blank"),
    EMAIL_INVALID(1005, "Email is not valid"),
    USER_NOT_EXISTED(1006, "User not existed"),
    UNAUTHENTICATED(1007, "Unauthenticated"),
    MUSIC_NOT_FOUND(2001, "Music not found"),
    AUTHOR_NOT_FOUND(2002, "Author not found"),
    AUTHOR_ALREADY_EXISTS(2003, "Author already exists"),
    PREMIUM_NOT_FOUND(3001, "Premium not found"),
    PREMIUM_ALREADY_EXISTS(3002, "Premium already exists");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
