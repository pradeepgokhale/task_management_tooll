package in.taskmanagement.service;

import in.taskmanagement.exception.TaskException;
import in.taskmanagement.model.TaskModel;

public interface TaskService {

	public void insertTask(TaskModel taskModel) throws TaskException;

	public TaskModel getTaskById(long taskId) throws TaskException;

	public TaskModel updateTask(TaskModel taskModel) throws TaskException;

	public void deleteBytaskId(long taskId) throws TaskException;

}
