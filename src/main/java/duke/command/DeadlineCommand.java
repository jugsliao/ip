package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.TaskList;
import duke.ui.Ui;

public class DeadlineCommand extends Command {
    private String input;

    /**
     * Constructor for command "deadline".
     *
     * @param input The user's input.
     */
    public DeadlineCommand(String input) {
        this.input = input;
    }

    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        int dashIndex = input.indexOf("/");
        String taskName = input.substring(9, dashIndex);
        String by = input.substring(dashIndex + 4);
        Deadline deadline = new Deadline(taskName, by);
        tasks.add(deadline);
        storage.saveTasks(tasks);
        return "Got it. I've added this task: \n" + deadline +
                "\nNow you have " + tasks.getSize() + " tasks in the list.";
    };
}
