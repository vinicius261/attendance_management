package com.cacauworking.attendance_management.exceptions;

public class InactiveContractException extends RuntimeException {
    public InactiveContractException(){
        super("Esse contrato já esta inativo.");
    }
}
