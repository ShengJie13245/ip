package ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import tasks.TaskManager;
import tasks.Todo;
import tasks.Deadline;
import tasks.Event;
import tasks.Task;

public class FileProcessor {
    private static final String FILE_PATH = "text-ui-test\\taskdata.txt";

    public static void writeToFile(ArrayList<Task> tasks){
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            for (Task task : tasks){
                String description = task.getDescription();
                boolean isDone = task.getisDone();
                String text = (isDone ? "[X] " + description : "[ ] " + description);
                if (task instanceof Deadline){
                    String by = ((Deadline) task).getBy();
                    text = "[D] " + text + " " + by;
                } else if (task instanceof Event){
                    String from = ((Event) task).getFrom();
                    String to = ((Event) task).getTo();
                    text = "[E] " + text + " " + from + " " + to;
                } else if (task instanceof Todo){
                    text = "[T] " + text;
                }
                fw.write(text + System.lineSeparator());
            }
            fw.close();       
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
