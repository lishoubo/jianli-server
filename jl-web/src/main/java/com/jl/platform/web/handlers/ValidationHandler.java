package com.jl.platform.web.handlers;

import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lishoubo on 16/6/18.
 */
@ControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result processValidationError(BindException ex) {
        BindingResult result = ex.getBindingResult();
        FieldError error = result.getFieldError();
        return processFieldError(error);
    }

    private Result processFieldError(FieldError error) {
        if (error != null) {
            return Result.create(StatusCode.CLIENT_INVALID_REQUEST.getCode(), error.getDefaultMessage());
        }
        return Result.create(StatusCode.CLIENT_INVALID_REQUEST);
    }

}
