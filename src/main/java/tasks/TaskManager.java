package tasks;

import java.util.ArrayList;

public class TaskManager {
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static int counter = 0;

    public static void printTasks(){
        for (int i = 0; i<counter; i++){
            System.out.println((i+1) + "." + tasks.get(i));
        }
    }

    public static void markTask(int index){
        tasks.get(index).setDoneStatus(true);
    }

    public static void unmarkTask(int index){
        tasks.get(index).setDoneStatus(false);
    }

    public static Task getTaskAtIndex(int index){
        return tasks.get(index);
    }

    public static void addTask(Task newTask){
        tasks.add(newTask);
        counter++;
    }

    public static int getCounter(){
        return counter;
    }

    public static void deleteTask(int index){
        tasks.remove(index);
        counter--;
    }
}
