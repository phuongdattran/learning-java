package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of th todo list: ");

        String topic = scanner.nextLine();
        ListToDo list = new ListToDo(topic);
        String action = "";

        System.out.println("//////// TO DO LIST: " + topic + " ///////");

        while (!action.equals("end")) {
            System.out.print("Enter an action (add/replace/remove/statusChange/end): ");
            action = scanner.next();

            switch (action) {
                case "add":
                    list.addTask();
                    break;
                case "remove":
                    list.removeTask();
                    break;
                case "replace":
                    list.replace();
                    break;
                case "statusChange":
                    list.changeStatus();
                    break;
                default:
                    System.out.println("Invalid action type");
            }
            list.displayList();
        }
    }
}
