package duke.command;

import duke.storage.Storage;
import duke.task.Event;
import duke.task.TaskList;
import duke.ui.Ui;

public class EventCommand extends Command{
    private String input;

    /**
     * Constructor for command "Event".
     *
     * @param input The user's input.
     */
    public EventCommand(String input) {
        this.input = input;
    }

    public String execute(TaskList tasks, Ui ui, Storage storage) {
        int firstDashIndex = input.indexOf("/");
        int secondDashIndex = input.lastIndexOf("/");
        String taskName = input.substring(6, firstDashIndex);
        String from = input.substring(firstDashIndex + 6, secondDashIndex);
        String to = input.substring(secondDashIndex + 4);
        Event event = new Event(taskName, from, to);
        tasks.add(event);
        storage.saveTasks(tasks);
        return "Got it. I've added this task: " + event +
                "\nNow you have " + tasks.getSize() + " tasks in the list.";
    };
}