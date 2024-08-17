package cmstricks.ru.TodoistTaskDistributor.services;

import cmstricks.ru.TodoistTaskDistributor.Task;
import cmstricks.ru.TodoistTaskDistributor.repositories.TaskCrudRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    // @TODO move to properties
    private static final String API_TOKEN = System.getenv("TODOIST_API_TOKEN");
    @Value("${todoist.api.path}")
    private String BASE_URL;
    @Value("${todoist.project.id}")
    private String PROJECT_ID;

    @Autowired
    TaskCrudRepository taskCrudRepository;

    public List<Task> getAllTasks() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASE_URL + "tasks?project_id=" + PROJECT_ID)
                .addHeader("Authorization", "Bearer " + API_TOKEN)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);

            }

            assert response.body() != null;
            String jsonData = response.body().string();
            final ObjectMapper objectMapper = new ObjectMapper();

            List<Task> taskList = Arrays.asList(objectMapper.readValue(jsonData, Task[].class));
            taskCrudRepository.saveAll(taskList);

            return taskList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
