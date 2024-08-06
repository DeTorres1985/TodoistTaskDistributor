package cmstricks.ru.TodoistTaskDistributor.repositories;

import cmstricks.ru.TodoistTaskDistributor.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskCrudRepository extends CrudRepository<Task, String> {
    long count();
}
