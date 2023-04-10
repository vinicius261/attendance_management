package com.cacauworking.attendance_management.exceptions;

public class FogetToRegisterException extends RuntimeException {
    public FogetToRegisterException() {
        super("Esqueceu de registrar");
    }
}
