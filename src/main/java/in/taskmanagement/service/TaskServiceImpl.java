package in.taskmanagement.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.taskmanagement.exception.TaskException;
import in.taskmanagement.model.TaskModel;

@Service
public class TaskServiceImpl implements TaskService {

	private final Map<Long, TaskModel> taskModelMap = new HashMap<>();

	@Override
	public void insertTask(TaskModel taskModel) throws TaskException {
		if (taskModelMap.containsKey(taskModel.getTaskId())) {
			throw new TaskException("TS-409", "TASK_EXISTS", HttpStatus.CONFLICT);
		} else {
			taskModelMap.put(taskModel.getTaskId(), taskModel);
			System.out.println("Task posted successfully. Status Code: 201 Created");
		}
	}

	@Override
	public TaskModel getTaskById(long taskId) throws TaskException {
		TaskModel task = taskModelMap.get(taskId);
		if (task != null) {
			return task;
		} else {
			throw new TaskException("TS-404", "Task with ID " + taskId + " not found", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public TaskModel updateTask(TaskModel updatedTaskModel) throws TaskException {
	    Long taskId = updatedTaskModel.getTaskId();
	    if (taskModelMap.containsKey(taskId)) {
	        taskModelMap.put(taskId, updatedTaskModel);
	        return taskModelMap.get(taskId);
	    } else {
	        throw new TaskException("TS-404", "Task with ID " + taskId + " not found for update", HttpStatus.NOT_FOUND);
	    }
	}


	@Override
	public void deleteBytaskId(long taskId) throws TaskException {
	    if (taskModelMap.containsKey(taskId)) {
	        taskModelMap.remove(taskId);
	    } else {
	        throw new TaskException("TS-404", "Task with ID " + taskId + " not found for deletion", HttpStatus.NOT_FOUND);
	    }
	}


}
