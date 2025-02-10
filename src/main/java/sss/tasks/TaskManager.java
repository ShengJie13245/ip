package sss.tasks;

public class TaskManager {
    public static Task[] tasks = new Task[100];
    public static int counter = 0;

    public static void printTasks(){
        for (int i = 0; i<counter; i++){
            System.out.println((i+1) + "." + tasks[i]);
        }
    }

    public static void markTask(int index){
        tasks[index].setDoneStatus(true);
    }

    public static void unmarkTask(int index){
        tasks[index].setDoneStatus(false);
    }

    public static Task getTaskAtIndex(int index){
        return tasks[index];
    }

    public static void addTask(Task newTask){
        tasks[counter] = newTask;
        counter++;
    }

    public static int getCounter(){
        return counter;
    }
}
