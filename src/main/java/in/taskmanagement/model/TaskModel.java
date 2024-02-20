package in.taskmanagement.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "task_id")
	private Long taskId;

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "address")
	private String address;

	@JsonProperty(value = "task")
	private String task;
}
