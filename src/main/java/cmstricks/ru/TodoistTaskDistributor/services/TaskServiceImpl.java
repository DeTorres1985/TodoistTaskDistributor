package cmstricks.ru.TodoistTaskDistributor.services;

import cmstricks.ru.TodoistTaskDistributor.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    // @TODO move to properties
    private static final String API_TOKEN = System.getenv("TODOIST_API_TOKEN");
    // @TODO move to properties
    private static final String BASE_URL = "https://api.todoist.com/rest/v2/";
    // @TODO move to properties
    private static final String PROJECT_ID = "2333440340";

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

            return Arrays.asList(objectMapper.readValue(jsonData, Task[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
