package ase.en.sqt.models;

import java.util.*;

public class TaskManager {
    private Map<User, List<Task>> manager = new HashMap<>();

    public void addUser(User user)
    {
        manager.put(user, new ArrayList<>());
    }

    public void createTask(String title, String description, User user)
    {
        if (!manager.containsKey(user))
        {
            System.out.println("User not found in TaskManager.");
            return;
        }
        Task task = new Task(title, description, false);
        manager.get(user).add(task);
        System.out.println("Task created: " + task);
    }

    public void updateTask(User user, int taskId, String title, String description)
    {
        Task task = findTask(user, taskId);
        if (task != null)
        {
            task.setTitle(title);
            task.setDescription(description);
            System.out.println("Task updated: " + task);
        } else {
            System.out.println("Task not found.");
        }
    }

    public void deleteTask(User user, int taskId)
    {
        if (!user.canDeleteTask())
        {
            System.out.println("You do not have permission to delete tasks.");
            return;
        }
        List<Task> tasks = manager.get(user);
        if (tasks != null && tasks.removeIf(task -> task.getTaskId() == taskId))
        {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void toggleTaskVisibility(User user, int taskId)
    {
        Task task = findTask(user, taskId);
        if (task != null)
        {
            if(!task.isHidden())
            {
                task.hide();
            } else {
                task.show();
            }
            System.out.println("Task visibility toggled: " + task);
        } else {
            System.out.println("Task not found.");
        }
    }

    public List<Task> getVisibleTasks(User user)
    {
        return manager.getOrDefault(user, Collections.emptyList()).stream().filter(Task::isHidden).toList();
    }

    public List<Task> getAllTasks(User user)
    {
        if (user.canViewAllTasks())
        {
            List<Task> allTasks = new ArrayList<>();
            for (List<Task> tasks : manager.values())
            {
                allTasks.addAll(tasks);
            }
            return allTasks;
        }
        return new ArrayList<>(manager.getOrDefault(user, Collections.emptyList()));
    }

    private Task findTask(User user, int taskId)
    {
        return manager.getOrDefault(user, Collections.emptyList()).stream().filter(task -> task.getTaskId() == taskId).findFirst().orElse(null);
    }

}
