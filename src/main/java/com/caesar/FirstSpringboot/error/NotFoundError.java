package com.caesar.FirstSpringboot.error;

public class NotFoundError extends Exception{
    public NotFoundError() {
        super();
    }

    public NotFoundError(String message) {
        super(message);
    }

    public NotFoundError(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundError(Throwable cause) {
        super(cause);
    }

    protected NotFoundError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
