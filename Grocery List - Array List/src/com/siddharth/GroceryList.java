package com.siddharth;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList {

    private ArrayList<String> groceryList;

    public GroceryList() {
        this.groceryList = new ArrayList<String>();
    }
    private static Scanner sc = new Scanner(System.in);

    public void printGroceryList(){
        System.out.println("You have checked in " + groceryList.size() + " item.");
        for(int i=0; i<groceryList.size(); i++){
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    public String capitalizer(String item){
        String capitalizedItem = item.substring(0,1).toUpperCase() + item.substring(1).toLowerCase();
        return capitalizedItem;
    }

    public void addGroceryItem(String addItem){
        addItem = capitalizer(addItem);
        if(!checkAvailability(addItem)) {
            groceryList.add(addItem);
            System.out.println(addItem + " is added to the grocery list.");
        }else{
            System.out.println(addItem + " is already present in the grocery list.");
        }
    }

    public void modifyGroceryItem(String currentItem, String newItem){
        currentItem = capitalizer(currentItem);
        newItem = capitalizer(newItem);
        if(checkAvailability(currentItem)){
            if(checkAvailability(newItem)) {
                System.out.println(currentItem + " already present in the grocery list.");
            }else{

            int index = groceryList.indexOf(currentItem);
            groceryList.set(index, newItem);
            System.out.println(currentItem + " is successfully replaced by " + newItem);
            }
        }
    }

    public void removeItem(String remItem){
        remItem= capitalizer(remItem);
        if(!checkAvailability(remItem)){
            System.out.println(remItem + " is not present in the grocery list.");
        }else{
            groceryList.remove(remItem);
            System.out.println(remItem + " is deleted from the grocery list.");
        }
    }

    public void removeItem(int index){
        if(groceryList.size()>=(index)){
            String temp = groceryList.get(index);
            groceryList.remove(index);
            System.out.println(temp + " deleted from the grocery list.");
        }else{
            System.out.println("Invalid position!!");
        }
    }

    public boolean checkAvailability(String toCheckItem){
        toCheckItem = capitalizer(toCheckItem);
        int position = groceryList.indexOf(toCheckItem);
        if(position>=0) {
            return true;
        }
        return false;
    }

    public void searchItem(String searchItem){
        searchItem = capitalizer(searchItem);
        if(checkAvailability(searchItem)){
            int position = groceryList.indexOf(searchItem);
            System.out.println(searchItem + " present at position " + position);
        }else{
            System.out.println(searchItem + " is not present in the grocery list.");
        }
    }
}
