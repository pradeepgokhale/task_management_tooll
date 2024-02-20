package in.taskmanagement.resource;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import in.taskmanagement.exception.TaskException;
import in.taskmanagement.model.TaskModel;

@RequestMapping(path = { "/task" })
public interface TaskResource {

	@PostMapping(path = {
			"/add" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addTask(@Valid @RequestBody TaskModel taskModel) throws TaskException;

	@GetMapping(path = { "/fetch/{task_id}" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TaskModel getTask(@PathVariable("task_id") long taskId) throws TaskException;

	@PutMapping(path = {
			"/update" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public TaskModel updateTask(@Valid @RequestBody TaskModel updatedTaskModel) throws TaskException;

	@DeleteMapping(path = { "/delete/{task_id}" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteTask(@PathVariable("task_id") long taskId) throws TaskException;

}
