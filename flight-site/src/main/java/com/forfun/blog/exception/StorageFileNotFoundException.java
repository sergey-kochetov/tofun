package com.forfun.blog.exception;

public class StorageFileNotFoundException extends RuntimeException {
    public StorageFileNotFoundException(String msg) {
        super(msg);
    }

    public StorageFileNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
