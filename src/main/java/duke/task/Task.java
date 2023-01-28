package duke.task;

import java.io.Serializable;

public class Task implements Serializable{
    private String taskName;
    private boolean done;

    /**
     * Constructor for Task object.
     *
     * @param taskName The name of the task.
     */
    public Task(String taskName) {
        this.taskName = taskName;
        this.done = false;
    }

    /**
     * Mark the task as done.
     */
    public void mark() {
        this.done = true;
    }

    /**
     * Unmark the task as not done.
     */
    public void unmark() {
        this.done = false;
    }

    /**
     * Returns true if taskName contains keyword and false otherwise
     *
     * @return True if taskName contains keyword and false otherwise
     */
    public boolean contains(String keyword) {
        return this.taskName.contains(keyword);
    }

    /**
     * Returns string representation of the task and its status.
     *
     * @return String representation of the task and the marked status.
     */
    @Override
    public String toString() {
        if (this.done) {
            return "[X] " + this.taskName;
        } else {
            return "[ ] " + this.taskName;
        }
    }
}
