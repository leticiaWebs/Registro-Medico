package com.medicalregistry.medicalregistry.exceptions;

import java.io.Serial;

public class DataBaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 4285766557842589336L;

    public DataBaseException(String msg) {
        super(msg);
    }
}
