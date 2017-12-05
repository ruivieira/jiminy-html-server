package com.redhat.analytics.jiminy.htmlserver.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.redhat.analytics.jiminy.htmlserver.model.ValidationErrorList;

/**
 * ApiErrorHandler<br>
 *
 * @author Zak Hassan <zhassan@redhat.com>
 */
@ControllerAdvice
public class ApiErrorHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorList HandleNotFound(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		return convertToValidationErrorList(fieldErrors);
	}

	private ValidationErrorList convertToValidationErrorList(List<FieldError> fieldErrors) {
		ValidationErrorList errorList = new ValidationErrorList();
		for (FieldError fieldError : fieldErrors) {
			errorList.add(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return errorList;
	}

}
