package pl.coderslab.assertJ;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public Task createTask(int id, String title, String description, Status status) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        Task task = new Task(id, title, description, status);
        tasks.add(task);
        return task;
    }

    public Optional<Task> getTask(int id) {

        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }

    public Task updateTask(int id, String title, String description, Status status) {
        Task task = getTask(id).orElseThrow(() -> new NoSuchElementException("Task not found"));
        task.setDescription(description);
        task.setStatus(status);
        task.setTitle(title);

        return task;
    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public List<Task> findByTitle(String title) {
        return tasks.stream().filter(task -> task.getTitle().contains(title)).toList();
    }

    public List<Task> findByStatus(Status status) {
        return tasks.stream().filter(t -> t.getStatus() == status).toList();
    }

    public List<Task> findByDescription(String description) {
        return tasks.stream().filter(task -> task.getDescription().contains(description)).toList();
    }

    public List<Task> searchTasks(LocalDate creationDate) {
        return tasks.stream()
                .filter(task -> task.getDate().equals(creationDate))
                .collect(Collectors.toList());
    }

}
