package cmstricks.ru.TodoistTaskDistributor;

public class Task {
    public String id;
    public String assigner_id;
    public String assignee_id;
    public String project_id;
    public String section_id;
    public String parent_id;
    public String order;
    public String content;
    public String description;
    public Boolean is_completed;
    public String[] labels;
    public int priority;
    public int comment_count;
    public String creator_id;
    public String created_at;
    public String due;
    public String url;
    public String duration;

    public Task() {
    }
}
