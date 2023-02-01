package module13.task3;

public class ToDoSomething {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ToDoSomething{");
        sb.append("userId=").append(userId);
        sb.append(", id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", completed=").append(completed);
        sb.append('}');
        return sb.toString();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
