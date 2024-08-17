package cmstricks.ru.TodoistTaskDistributor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loadTasksFromTodoist")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
    @Id
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    public String id;
    @Column(name="parent_id", columnDefinition = "VARCHAR(50)")
    public String parent_id;
    @Column(name="task_order", columnDefinition = "VARCHAR(255)")
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
