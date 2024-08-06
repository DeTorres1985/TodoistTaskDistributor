package cmstricks.ru.TodoistTaskDistributor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
    public String id;
    public String parent_id;
    public String order;
    public String content;
    public String description;
    public Boolean is_completed;
    public String[] labels;
    public int priority;
    public String created_at;
    public String url;

//    public String project_id;
//    public int comment_count;
//    public String due;
//    public String creator_id;
//    public String section_id;
//    public String duration;
//    public String assigner_id;
//    public String assignee_id;

    public Task() {
    }
}
