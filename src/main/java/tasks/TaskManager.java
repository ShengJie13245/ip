package tasks;

import java.util.ArrayList;

import parser.FileProcessor;

public class TaskManager {
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static int counter = 0;

    /**
     * Prints out all tasks that has been added
     */
    public static void printTasks(){
        for (int i = 0; i<counter; i++){
            System.out.println((i+1) + "." + tasks.get(i));
        }
    }

    /**
     * Marks a task completed based on index
     * @param index An integer to specify which task to mark
     */
    public static void markTask(int index){
        tasks.get(index).setDoneStatus(true);
    }

    /**
     * Marks a task incomplete based on index
     * @param index An integer to specify which task to unmark
     */
    public static void unmarkTask(int index){
        tasks.get(index).setDoneStatus(false);
    }

    /**
     * Returns a {@link Task} object based on the index
     * @param index An integer to specify which task to return
     * @return A task object
     */
    public static Task getTaskAtIndex(int index){
        return tasks.get(index);
    }

    /**
     * Append the newTask to the ArrayList 
     * @param newTask A task to be added to the list
     */
    public static void addTask(Task newTask){
        tasks.add(newTask);
        counter++;
    }

    /**
     * Saves the current list of tasks
     */
    public static void saveTasks(){
        FileProcessor.writeToFile(tasks);
    }

    /**
     * Return the number of tasks currently in the list
     * @return number of tasks in list
     */
    public static int getCounter(){
        return counter;
    }

    /**
     * Removing a task from the list based on the index
     * @param index An integer to specify which task to remove
     */
    public static void deleteTask(int index){
        tasks.remove(index);
        counter--;
    }
}
