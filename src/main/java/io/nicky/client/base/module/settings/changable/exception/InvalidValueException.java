package io.nicky.client.base.module.settings.changable.exception;

public class InvalidValueException extends IllegalStateException {

    public InvalidValueException() {
    }

    public InvalidValueException(String s) {
        super(s);
    }

    public InvalidValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidValueException(Throwable cause) {
        super(cause);
    }
}
