package ase.en.sqt.models;

public class Admin extends User {

    public Admin(String name)
    {
        super(name);
    }

    @Override
    public boolean canDeleteTask()
    {
        return true;
    }

    @Override
    public boolean canViewAllTasks()
    {
        return true;
    }
}
