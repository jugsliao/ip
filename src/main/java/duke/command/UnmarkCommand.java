package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class UnmarkCommand extends Command{
    private String input;

    /**
     * Constructor for command "Unmark".
     *
     * @param input The user's input.
     */
    public UnmarkCommand(String input) {
        this.input = input;
    }

    public String execute(TaskList tasks, Ui ui, Storage storage) {
        String[] commandString = input.split(" ");
        int index = Integer.parseInt(commandString[1]) - 1;
        Task task = tasks.get(index);
        task.unmark();
        storage.saveTasks(tasks);
        return "OK, I've marked this task as not done yet:\n" + task;
    };
}
