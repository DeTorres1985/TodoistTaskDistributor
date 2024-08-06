package cmstricks.ru.TodoistTaskDistributor.repositories;

import cmstricks.ru.TodoistTaskDistributor.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskPagingRepository extends PagingAndSortingRepository<Task, String> {
}
