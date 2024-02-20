package in.taskmanagement.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import in.taskmanagement.exception.TaskException;
import in.taskmanagement.model.TaskModel;
import in.taskmanagement.service.TaskService;

@RestController
public class TaskResourceImpl implements TaskResource{

	@Autowired
	private TaskService taskService;
	
	@Override
	public void addTask(@Valid TaskModel taskModel) throws TaskException {
		taskService.insertTask(taskModel);
	}

	@Override
	public TaskModel getTask(long taskId) throws TaskException {
		return taskService.getTaskById(taskId);
		
	}

	@Override
	public TaskModel updateTask(@Valid TaskModel updatedTaskModel) throws TaskException {
		return taskService.updateTask(updatedTaskModel);
	}

	@Override
	public void deleteTask(long taskId) throws TaskException {
		taskService.deleteBytaskId(taskId);
		
	}

}
