package pl.coderslab.assertJ;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void createTaskTest() {
        Task task = taskService.createTask(1, "zakupy", "kupic maslo i chleb", Status.NOT_STARTED);
        assertThat(task).isNotNull();
        assertThat(task.getTitle()).isEqualTo("zakupy");
        assertThat(task.getDescription()).isEqualTo("kupic maslo i chleb");
        assertThat(task.getStatus()).isEqualTo(Status.NOT_STARTED);

    }

    @Test
    void updateTaskTest() {
        Task task = taskService.createTask(1, "zakupy", "kupic maslo i chleb", Status.NOT_STARTED);
        assertThat(task).isNotNull();
        Task taskUpdated = taskService.updateTask(1, "zakupy", "kupic mleko", Status.IN_PROGRESS);
        assertThat(taskUpdated.getTitle()).isEqualTo("zakupy");
        assertThat(taskUpdated.getDescription()).isEqualTo("kupic mleko");
        assertThat(taskUpdated.getStatus()).isEqualTo(Status.IN_PROGRESS);
    }

    @Test
    void deleteTaskTest() {
        Task task = taskService.createTask(1, "zakupy", "kupic maslo i chleb", Status.NOT_STARTED);
        assertThat(task).isNotNull();

        taskService.deleteTask(1);
        assertThat(taskService.getTask(task.getId())).isEmpty();
    }

    @Test
    void findByTitleTest() {
        taskService.createTask(1, "zakupy", "kupic maslo i chleb", Status.NOT_STARTED);
        taskService.createTask(2, "zakupy", "kupic maslo i mleko", Status.IN_PROGRESS);
        taskService.createTask(3, "sprzatanie", "umyc podloge", Status.COMPLETED);

        List<Task> tasks = taskService.findByTitle("zakupy");

        assertThat(tasks).contains(taskService.getTask(1).orElseThrow());
        assertThat(tasks).contains(taskService.getTask(2).orElseThrow());

    }

    @Test
    void findByDescription() {
        taskService.createTask(1, "zakupy", "kupic maslo i chleb", Status.NOT_STARTED);
        taskService.createTask(2, "zakupy", "kupic maslo i mleko", Status.IN_PROGRESS);
        taskService.createTask(3, "sprzatanie", "umyc podloge", Status.COMPLETED);

        List<Task> tasks = taskService.findByDescription("umyc podloge");

        assertThat(tasks).hasSize(1).extracting(Task::getId).containsExactly(3);
    }

    @Test
    void createTaskWithNoTitle() {
        assertThatThrownBy(() -> taskService.createTask(1, "", "kupic maslo i chleb", Status.NOT_STARTED)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Title cannot be null or empty");
        assertThatThrownBy(() -> taskService.createTask(2, null, "kupic maslo i chleb", Status.NOT_STARTED)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Title cannot be null or empty");

    }

    @Test
    void createTasksTest() {
        Task task = taskService.createTask(1, "zakupy", "kupic maslo i chleb", Status.NOT_STARTED);
        Task task1 = taskService.createTask(2, "zakupy", "kupic maslo i mleko", Status.IN_PROGRESS);
        assertThat(taskService.getTasks()).hasSize(2).containsOnly(task, task1);
    }

    @Test
    void creationDateTest() {
        Task task = taskService.createTask(1, "zakupy", "kupic maslo i chleb", Status.NOT_STARTED);
        Task task1 = taskService.createTask(2, "zakupy", "kupic maslo i mleko", Status.IN_PROGRESS);

        LocalDate today = LocalDate.now();
        List<Task> tasksByDate = taskService.searchTasks(today);

        assertThat(tasksByDate).isNotNull().hasSize(2).allMatch(t -> t.getDate().equals(today));
    }



}