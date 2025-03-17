package ase.en.sqt.models;

import java.util.*;

public class TaskManager {
    private Map<User, List<Task>> manager = new HashMap<>();

    public void addUser(User user)
    {
        manager.put(user, new ArrayList<>());
    }

    public Set<User> getAllUsers(){
        return manager.keySet();
    }

    public void createTask(User user)
    {
        if(user!=null){
            Scanner scanner = new Scanner(System.in);
            if (!manager.containsKey(user))
            {
                System.out.println("User not found in TaskManager.");
                return;
            }

            System.out.println("Task title: ");
            String title = scanner.next();
            System.out.println("Task description: ");
            String description = scanner.next();

            Task task = new Task(title, description, false);
            manager.get(user).add(task);
            System.out.println("Task created: " + task);
        } else {
            System.out.println("No user was selected!");
        }

    }

    public void updateTask(User user)
    {
        if(user!=null){
            Scanner scanner = new Scanner(System.in);
            System.out.println("ID of task to be modified:");
            int taskId = scanner.nextInt();
            Task task = findTask(user, taskId);
            if (task != null)
            {
                System.out.println("New task title: ");
                String title = scanner.next();
                System.out.println("New task description: ");
                String description = scanner.next();
                task.setTitle(title);
                task.setDescription(description);
                System.out.println("Task updated: " + task);
            } else {
                System.out.println("Task not found.");
            }
        } else {
            System.out.println("No user was selected!");
        }

    }

    public void deleteTask(User user)
    {
        if(user != null){
            if (!user.canDeleteTask())
            {
                System.out.println("You do not have permission to delete tasks.");
                return;
            }
            List<Task> tasks = manager.get(user);

            Scanner scanner = new Scanner(System.in);
            System.out.println("ID of task to be deleted:");
            int taskId = scanner.nextInt();

            if (tasks != null && tasks.removeIf(task -> task.getTaskId() == taskId))
            {
                System.out.println("Task deleted successfully.");
            } else {
                System.out.println("Task not found.");
            }
        } else {
            System.out.println("No user was selected!");
        }

    }

    public void toggleTaskVisibility(User user)
    {
        if(user != null){
            Scanner scanner = new Scanner(System.in);
            System.out.println("ID of task to toggle visibility:");
            int taskId = scanner.nextInt();

            Task task = findTask(user, taskId);
            if (task != null)
            {
                if(!task.isHidden()){
                    task.hide();
                } else {
                    task.show();
                }
                System.out.println("Task visibility toggled: " + task);
            } else {
                System.out.println("Task not found.");
            }
        } else {
            System.out.println("No user was selected");
        }

    }

    public List<Task> getVisibleTasks(User user)
    {
        if(user != null){
            return manager.getOrDefault(user, Collections.emptyList()).stream().filter(Task::isHidden).toList();
        } else {
            System.out.println("No user was selected");
            return null;
        }
    }

    public List<Task> getAllTasks(User user)
    {
        if(user != null){
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
        } else {
            System.out.println("No user was selected");
            return null;
        }
    }

    private Task findTask(User user, int taskId)
    {
        return manager.getOrDefault(user, Collections.emptyList()).stream().filter(task -> task.getTaskId() == taskId).findFirst().orElse(null);
    }

}
