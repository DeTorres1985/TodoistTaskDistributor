package cmstricks.ru.TodoistTaskDistributor;

import cmstricks.ru.TodoistTaskDistributor.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TasksController {
    @Autowired
    public TaskService taskService;

     @GetMapping("/tasks")
    public List<Task> getTasksList(){
         return taskService.getAllTasks();
     }
}
