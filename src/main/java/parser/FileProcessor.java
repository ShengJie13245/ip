package parser;

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
                String text = "/isDone " + (isDone ? "Done /description " + description : "Not Done /description " + description);
                if (task instanceof Deadline){
                    String by = ((Deadline) task).getBy();
                    text = "/task deadline " + text + " /by " + by;
                } else if (task instanceof Event){
                    String from = ((Event) task).getFrom();
                    String to = ((Event) task).getTo();
                    text = "/task event " + text + " /from " + from + " /to " + to;
                } else if (task instanceof Todo){
                    text = "/task todo " + text;
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
                String[] inputArray = fileInput.nextLine().split("/task | /description | /isDone | /by | /from | /to" );
                for (int i = 0; i < inputArray.length; i++){
                    inputArray[i] = inputArray[i].trim();
                }

                String taskType = inputArray[1];
                String description = inputArray[3];
                boolean isDone = inputArray[2].equals("Done") ? true : false; 
                switch (taskType){
                case ("todo"):
                    Task todoTask = new Todo(description, isDone);
                    TaskManager.addTask(todoTask);
                    counter++;
                    break;
                case ("deadline"):
                    String by = inputArray[4];
                    Task deadlineTask = new Deadline(description, by, isDone);
                    TaskManager.addTask(deadlineTask);
                    counter++;
                    break;
                case ("event"):
                    String from = inputArray[4];
                    String to = inputArray[5];
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
