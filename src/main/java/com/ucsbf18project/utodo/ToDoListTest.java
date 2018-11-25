import com.ucsbf18project.utodo;

public class ToDoListTest {
    
    public static void main(String[] args) {
        ListItem i1 = new ListItem(1, "11/12/2018 12:30 PM", "Do laundry.");
        ListItem i2 = new ListItem(3, "12/30/2018 2:00 PM", "Midterm exam.");
        ListItem i3 = new ListItem(2, "1/30/2017 7:00 AM", "Return books to library.");
        ListItem i4 = new ListItem(3, "11/12/2018 1:15 PM", "Some important thing");
        ListItem i5 = new ListItem(2, "01/30/2017 7:00 AM", "Another important thing");
        ToDoList myList = new ToDoList();
        myList.addToDo(i1);
        myList.addToDo(i2);
        myList.addToDo(i3);
        myList.addToDo(i4);
        myList.addToDo(i5);
        System.out.println(myList);

        System.out.println("\nSwitched to sorting by urgency:");
        myList.sortByUrgency();
        System.out.println(myList);

        System.out.println("\nSwitched back to sorting by due date:");
        myList.sortByDueDateAndTime();
        System.out.println(myList);   
        


     System.out.println(myList.removeToDo(3));
     System.out.println(myList);       
        
    }  
}

