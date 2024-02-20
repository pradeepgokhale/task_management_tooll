package in.taskmanagement.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class TaskException extends Exception{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

	private HttpStatus status;

	public TaskException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public TaskException(String code, String message, HttpStatus status) {
		super(message);
		this.code = code;
		this.status = status;
	}
}
