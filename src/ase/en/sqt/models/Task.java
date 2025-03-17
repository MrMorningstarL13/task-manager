package ase.en.sqt.models;

public class Task {
    private final int id;
    private static int counter = 1;
    private String title;
    private String description;
    private boolean isHidden;

    public Task(String title, String description, boolean isHidden)
    {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.isHidden = isHidden;
    }

    public int getTaskId()
    {
        return id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isHidden()
    {
        return isHidden;
    }


    public void hide()
    {
        this.isHidden = true;
        System.out.println("Task is now hidden!");

    }

    public void show()
    {
        this.isHidden = false;
        System.out.println("Task is now shown!");
    }

    @Override
    public String toString()
    {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isHidden=" + isHidden +
                '}';
    }
}

