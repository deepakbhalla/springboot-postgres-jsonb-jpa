package com.example.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse handleResourceNotFound(final ResourceNotFoundException exception,
                                                                  final HttpServletRequest request) {

        return ExceptionResponse.builder()
                .errorMessage(exception.getMessage())
                .requestedURI(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponse handleBadRequestException(final BadRequestException exception,
                                                                     final HttpServletRequest request) {

        return ExceptionResponse.builder()
                .errorMessage(exception.getMessage())
                .requestedURI(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponse handleHttpMediaTypeNotSupportedException(final HttpMediaTypeNotSupportedException exception,
                                                                                    final HttpServletRequest request) {

        return ExceptionResponse.builder()
                .errorMessage(exception.getMessage())
                .requestedURI(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponse handleMissingServletRequestParameterException(final MissingServletRequestParameterException exception,
                                                                                         final HttpServletRequest request) {

        return ExceptionResponse.builder()
                .errorMessage(exception.getMessage())
                .requestedURI(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(InsufficientAccountBalanceException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponse handleInsufficientAccountBalanceException(final InsufficientAccountBalanceException exception,
                                                                                     final HttpServletRequest request) {

        return ExceptionResponse.builder()
                .errorMessage(exception.getMessage())
                .requestedURI(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionResponse handleException(final Exception exception,
                                                           final HttpServletRequest request) {

        return ExceptionResponse.builder()
                .errorMessage(exception.getMessage())
                .requestedURI(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
