package ase.en.sqt.models;

public class RegularUser extends User {

    public RegularUser(String name)
    {
        super(name);
    }

    @Override
    public boolean canDeleteTask()
    {
        return false;
    }

    @Override
    public boolean canViewAllTasks()
    {
        return false;
    }
}
