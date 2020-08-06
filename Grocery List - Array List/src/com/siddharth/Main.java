package com.siddharth;

import java.util.Scanner;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static GroceryList groceryList = new GroceryList();

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem(){
        System.out.print("Enter the item you want to add: ");
        groceryList.addGroceryItem(sc.nextLine());
    }

    public static void modifyItem(){
        System.out.print("Enter the item you want to replace: ");
        String currentItem = sc.nextLine();
        System.out.print("Enter the item you want to keep as replacement: ");
        String newItem = sc.nextLine();
        groceryList.modifyGroceryItem(currentItem, newItem);
    }

    public static void removeItem(){
        int choice;
        System.out.println("\nPress ");
        System.out.println("\t 1 - If you want to proceed with item number.");
        System.out.println("\t 2 - If you want to proceed with item name.");
        choice = sc.nextInt();
        sc.nextLine();
        if(choice==1)
        {System.out.print("Enter the item number you want to remove: ");
        groceryList.removeItem((sc.nextInt()-1));
        }
        if(choice==2) {
            System.out.print("Enter the item name you want to remove: ");
           // String t=sc.nextLine();
            groceryList.removeItem(sc.nextLine()); }
        if(choice!=1&&choice!=2){
            System.out.println("Invalid Input!! Try Again!");
        }
    }

    public static void searchItem(){
        System.out.print("Enter the item you want to search: ");
        groceryList.searchItem(sc.nextLine());
    }

    //public static

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        printInstructions();
        while (!quit) {
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                  //  processArrayList();
              //  case 7:
                    quit = true;
                    break;
            }
        }
    }
}
