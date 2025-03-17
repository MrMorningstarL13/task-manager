package ase.en.sqt.models;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    public String name;

    public User(String name)
    {
        this.name = name;
    }


    public abstract boolean canDeleteTask();
    public abstract boolean canViewAllTasks();

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

}
