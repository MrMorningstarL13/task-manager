import ase.en.sqt.models.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        User currentUser = null;

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("""
                    ------------------------------------
                    Press a key:
                    1 - Create regular user
                    2 - Create admin
                    3 - Select an existing user
                    For the following, you need to have a user selected:
                     4 - Create task
                    5 - Update task
                    6 - Delete task
                    7 - Toggle task visibility
                    8 - Get visibile tasks
                    9 - Get all tasks
                    0 - Exit the program"""
            );

            int input = scanner.nextInt();

            if(input == 0){
                System.out.println("Exiting program");
                break;
            }

            switch(input){
                case 1:
                    System.out.println("Name of user:");
                    String case1Name = scanner.next();
                    User user = new RegularUser(case1Name);
                    taskManager.addUser(user);
                    System.out.println("New user created!");
                    currentUser = user;
                    break;

                case 2:
                    System.out.println("Name of admin:");
                    String case2Name = scanner.next();
                    User admin = new Admin(case2Name);
                    taskManager.addUser(admin);
                    System.out.println("New admin created!");
                    currentUser = admin;
                    break;

                case 3:
                    Set<User> users = taskManager.getAllUsers();
                    if(!users.isEmpty()){
                        System.out.println(users);
                    } else {
                        System.out.println("There are no users created!");
                        break;
                    }
                    System.out.println("Enter the name of the user to log in:");
                    String selectedUser = scanner.next();

                    for (User u : users) {
                        if (u.name.equals(selectedUser)) {
                            currentUser = u;
                            break;
                        }
                    }

                    if(currentUser != null) {
                        System.out.println("Welcome, " + currentUser.name);
                    }
                    break;

                case 4:
                    taskManager.createTask(currentUser);
                    break;

                case 5:
                    taskManager.updateTask(currentUser);
                    break;

                case 6:
                    taskManager.deleteTask(currentUser);
                    break;

                case 7:
                    taskManager.toggleTaskVisibility(currentUser);
                    break;

                case 8:
                    List<Task> visibleTasks = taskManager.getVisibleTasks(currentUser);
                    System.out.println(visibleTasks);
                    break;

                case 9:
                    List<Task> allTasks = taskManager.getAllTasks(currentUser);
                    System.out.println(allTasks);
                    break;

                default:
                    System.out.println("Invalid option. Try again");
                    break;
            }
        }

    }
}