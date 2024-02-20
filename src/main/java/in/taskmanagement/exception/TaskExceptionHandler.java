package in.taskmanagement.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import in.taskmanagement.model.ApiError;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class TaskExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		body.put("message", "validation error");
		body.put("code", "RL07");
		Map<String, String> errordetails = null;
		if (!ex.getBindingResult().getFieldErrors().isEmpty())
			errordetails = new LinkedHashMap<String, String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors())
			errordetails.put(error.getField(), error.getDefaultMessage());
		body.put("errors", errordetails);
		return new ResponseEntity<Object>(body, headers, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TaskException.class)
	public ResponseEntity<ApiError> handleLoginServiceException(TaskException exception) {

		ApiError error = new ApiError();
		error.setCode(exception.getCode());
		error.setMessage(exception.getMessage());

		return new ResponseEntity<ApiError>(error,
				(null != exception.getStatus()) ? exception.getStatus() : HttpStatus.BAD_REQUEST);
	}


}
