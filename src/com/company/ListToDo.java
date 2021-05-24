package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListToDo {
    private String topic;
    private HashMap<String, Boolean> tasks;
    private Scanner scanner = new Scanner(System.in);

    public ListToDo(String topic) {
        this.topic = topic;
        this.tasks = new HashMap<String, Boolean>();
    }

    public void addTask() {
        while(true) {
            System.out.print("-- Enter a task: ");
            String task = scanner.nextLine();
            if(!task.equals("quit"))
                this.tasks.put(task, false);
            else
                break;
        }
    }

    public void removeTask() {
                System.out.print("-- Enter a task to remove: ");
                String task = scanner.nextLine();
                if (this.tasks.containsKey(task)) {
                    this.tasks.remove(task);
                } else {
                    System.out.println("-- No such task");
                }
    }

    public void replace() {
            System.out.print("-- Enter a task to replace: ");
            String oldTask = scanner.nextLine();
            if (this.tasks.containsKey((oldTask))) {
                System.out.print("-- Enter the new task: ");
                String task = scanner.nextLine();
                this.tasks.put(task, this.tasks.get(oldTask));
                this.tasks.remove(oldTask);
            } else {
                System.out.println("-- No such task");
            }
    }

    public void changeStatus() {
        System.out.print("-- Enter the task to change status: ");
        String completedTask = scanner.nextLine();
        if(this.tasks.containsKey(completedTask)) {
                this.tasks.put(completedTask, !this.tasks.get(completedTask));
        } else {
            System.out.println("No such task");
        }
    }

    public void displayList() {
        if(this.tasks.size() == 0) {
            System.out.println("The list is empty!");
        } else {
            System.out.println("Tasks to do: ");
            for(Map.Entry<String, Boolean> task: this.tasks.entrySet()) {
                if (task.getValue()) {
                    System.out.println("* " + task.getKey() + " | done");
                } else {
                    System.out.println("* " + task.getKey() + " | not done");
                }
            }
        }
    }
}