package ase.en.sqt.models;

public class Task {
    private final int id;
    private static int counter = 1;
    public String title;
    public String description;
    public boolean isHidden;

    public Task(String title, String description, boolean isHidden) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.isHidden = isHidden;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isHidden=" + isHidden +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public int getTaskId() {
        return id;
    }

    public void hide() {
        if(!this.isHidden) {
            this.isHidden = true;
        } else {
            System.out.println("Task is already hidden!");
        }
    }

    public void show() {
        if(this.isHidden) {
            this.isHidden = false;
        } else {
            System.out.println("Task is already shown!");
        }
    }
}
