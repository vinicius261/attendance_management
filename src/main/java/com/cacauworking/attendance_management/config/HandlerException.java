package com.cacauworking.attendance_management.config;

import com.cacauworking.attendance_management.dto.ErrorDTO;
import com.cacauworking.attendance_management.exceptions.DataAlreadyExistisException;
import com.cacauworking.attendance_management.exceptions.DataNotFoundException;
import com.cacauworking.attendance_management.exceptions.InactiveContractException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DataNotFoundException.class)
    public ErrorDTO handlerDataNotFound(DataNotFoundException ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(DataAlreadyExistisException.class)
    public ErrorDTO handlerDataAlreadyExistis(DataAlreadyExistisException ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InactiveContractException.class)
    public ErrorDTO handlerInactiveContract(InactiveContractException ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }
}
