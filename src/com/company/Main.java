package com.company;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean run = true;
        String menu = """
         Please choose an option:
         [1] Add a task.
         [2] Remove a task.
         [3] Update a task.
         [4] List all tasks.
         [0] Exit.
         Enter:""";
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("sleep");
        tasks.add("eat");
        tasks.add("run");
        tasks.add("walk");
        String num;
        String task_add;
        String task_remove;
        String task_upNum;
        String task_upd;
        String s = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
        while(run){
            System.out.println(menu);
            num = input.nextLine();
            switch (num) {
                case "1":{
                    System.out.println("What task would you like to add?");
                    task_add = input.nextLine();
                    task_add = task_add.replaceAll(" ", "_");
                    tasks.add(task_add);
                    System.out.println(s + "Updated tasks list:\n");
                    show_list(tasks);
                    break;
                }
                case "2":{
                    System.out.println("\nTasks:");
                    show_list(tasks);
                    System.out.println("What task would you like to remove? \n Enter the tasks number: (1 - " + (tasks.size()) + ")");
                    task_remove = input.nextLine();
                    if(isNum(task_remove)) {
                        if(Integer.parseInt(task_remove) <= tasks.size() & Integer.parseInt(task_remove) > 0) {
                            tasks.remove(Integer.parseInt(task_remove) - 1);
                            System.out.println(s + "Updated tasks list:\n");
                            show_list(tasks);
                        }
                        else{
                            System.out.println(s + "Number is out of range, enter a valid number.");
                        }
                    }
                    else{
                        System.out.println(s + "Error - Enter a valid number.");
                    }
                    break;
                }
                case "3":{
                    System.out.println("\nTasks:");
                    show_list(tasks);
                    System.out.println("What task would you like to update? \n Enter the tasks number: (1 - " + (tasks.size()) + ")");
                    task_upNum = input.nextLine();
                    if(isNum(task_upNum)) {
                        if(Integer.parseInt(task_upNum) <= tasks.size() & Integer.parseInt(task_upNum) > 0) {
                            System.out.println("What would you want to replace task " + task_upNum + " with?:");
                            task_upd = input.nextLine();
                            tasks.set((Integer.parseInt(task_upNum) - 1), task_upd);
                            System.out.println(s + "Updated tasks list:\n");
                            show_list(tasks);
                        }
                        else{
                            System.out.println(s + "Number is out of range, enter a valid number.");
                        }
                    }
                    else{
                        System.out.println(s + "Error - Enter a valid number.");
                    }
                    break;
                }
                case "4":{
                    System.out.println(s + "\nAll Tasks are listed below:");
                    show_list(tasks);
                    break;
                }
                case "0":{
                    System.out.println("Exiting...");
                    run = false;
                    break;
                }
                default: System.out.println(s + "Invalid Input, enter numbers 0-4");
            }
        }
    }
    public static void show_list(ArrayList<String> tasks) {
        String tasks_list = "";
        for (int i = 0; i < tasks.size(); i++) {
            tasks_list = tasks_list + ("(" + (i+1) + ")" +tasks.get(i)) + "\n";
        }
        System.out.println(tasks_list);
    }
    public static boolean isNum(String string) {
        int Value;
        if(string == null || string.equals("")) {
            return false;
        }
        try {
            Value = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
