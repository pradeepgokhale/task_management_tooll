package in.taskmanagement.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ApiError implements Serializable {

	private static final long serialVersionUID = -738190959022632854L;

	private String code;

	private String message;

	private HttpStatus status;

}