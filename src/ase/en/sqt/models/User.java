package ase.en.sqt.models;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    public String name;
    private String password;

    public List<Task> taskList = new ArrayList<>();
}
