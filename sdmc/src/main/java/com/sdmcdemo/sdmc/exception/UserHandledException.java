package com.sdmcdemo.sdmc.exception;

public class UserHandledException  extends  RuntimeException {
    public UserHandledException(Long id) {
        super("User id "+id+ " not found in the record");
    }
}
