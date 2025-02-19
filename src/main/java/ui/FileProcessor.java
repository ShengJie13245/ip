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
    private static final String FILE_PATH = "./saves/taskdata.txt";

    public static void writeToFile(ArrayList<Task> tasks){
        try {
            FileWriter writer = new FileWriter(FILE_PATH);
            for (Task task : tasks){
                String description = task.getDescription();
                boolean isDone = task.getisDone();
                String text = (isDone ? "[X] " + description : "[] " + description);
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
                writer.write(text + System.lineSeparator());
            }
            writer.close();       
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void readFromFile(){
        File file = new File(FILE_PATH);
        int counter = 0;
        try {
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNext()){
                String[] inputArray = fileInput.nextLine().split(" ");
                String description = inputArray[2];
                boolean isDone = inputArray[1].equals("[X]") ? true : false; 
                switch (inputArray[0]){
                case ("[T]"):
                    Task todoTask = new Todo(description, isDone);
                    TaskManager.addTask(todoTask);
                    counter++;
                    break;
                case ("[D]"):
                    String by = inputArray[3];
                    Task deadlineTask = new Deadline(description, by, isDone);
                    TaskManager.addTask(deadlineTask);
                    counter++;
                    break;
                case ("[E]"):
                    String from = inputArray[3];
                    String to = inputArray[4];
                    Task eventTask = new Event(description, from, to, isDone);
                    TaskManager.addTask(eventTask);
                    counter++;
                    break;
                }
            }
            fileInput.close();
        } catch (FileNotFoundException e){
            System.out.println("No previously saved tasks");
        } finally {
            System.out.println("Added " + counter + " tasks based on previous records");
        }
    }
}
