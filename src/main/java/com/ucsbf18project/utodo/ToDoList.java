import java.util.TreeSet;

public class ToDoList{
    
    private TreeSet<ListItem> toDoList;
    
    ToDoList() {
        toDoList = new TreeSet<ListItem>();
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
        return toDoList.add(item);
    }
    
    public boolean removeToDo(ListItem item) {
        return toDoList.remove(item);
    }
    
    public void sortByDueDate() {
        TreeSet<ListItem> newList = new TreeSet<ListItem>(new SortByDueDate());
        newList.addAll(toDoList);
        this.toDoList = newList;
    }
    
    public void sortByUrgency() {
        TreeSet<ListItem> newList = new TreeSet<ListItem>(new SortByUrgency());
        newList.addAll(toDoList);
        this.toDoList = newList; 
    }
    
    public ListItem firstItem() {
        return (ListItem)toDoList.first();
    }
}
