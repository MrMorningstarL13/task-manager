package ase.en.sqt.models;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String name;

    public User(String name)
    {
        this.name = name;
    }


    public abstract boolean canDeleteTask();
    public abstract boolean canViewAllTasks();
}
