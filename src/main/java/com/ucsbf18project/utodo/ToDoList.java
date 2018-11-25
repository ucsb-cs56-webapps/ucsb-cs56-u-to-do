package com.ucsbf18project.utodo;

import java.io.Serializable;
import java.util.ArrayList;

public class ToDoList implements Serializable {
    
    private ArrayList<ListItem> toDoList;
    private SortBehavior sortBehavior;
    
    ToDoList() {
        toDoList = new ArrayList<ListItem>();
        sortBehavior = (listItem1, listItem2) -> listItem1.compareTo(listItem2);
    }

    public ArrayList<ListItem> getToDoList() {
        return toDoList;
    }

    public void setToDoList(ArrayList<ListItem> toDoList) {
        this.toDoList = toDoList;
    }

    public SortBehavior getSortBehavior() {
        return sortBehavior;
    }

    public void setSortBehavior(SortBehavior sortBehavior) {
        this.sortBehavior = sortBehavior;
    }
    
    @Override
    public String toString() {
        String retStr = "===========To-Do List===========\n";
        for(ListItem i : toDoList) {
            retStr += i.toString() + "\n--------------------------------\n";
        }
        return retStr;
    }
    
    public boolean addToDo(ListItem item) {
        if(toDoList.add(item) == true) {
            toDoList.sort(sortBehavior);
            return false;
        }   
        else 
            return false;  
    }
    
    public boolean removeToDo(ListItem item) {
        return toDoList.remove(item);
    }
    
    public boolean removeToDo(int index) {
        if(index >= 0 && index <= toDoList.size() - 1) {
            toDoList.remove(index);
            return true;
        } else {
            return false;
        }  
    }
   
    public int size() {
        return toDoList.size();
    }
    
    public void sortByDueDateAndTime() {
        sortBehavior = (listItem1, listItem2) -> listItem1.compareTo(listItem2);
        toDoList.sort(sortBehavior);
    }
    
    public void sortByUrgency() {
        sortBehavior = (listItem1, listItem2) -> {
            if(listItem1.getUrgency() == listItem2.getUrgency()) {
                    return listItem1.compareTo(listItem2);
                } else 
            return listItem2.getUrgency() - listItem1.getUrgency();
        };
        toDoList.sort(sortBehavior);
    }
}
