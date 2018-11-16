public class ToDoListTest {
   public static void main(String[] args) {

    ListItem i1 = new ListItem(1, "11/12/2018", "Do laundry.");
    ListItem i2 = new ListItem(3, "12/30/2018", "Midterm exam.");
    ListItem i3 = new ListItem(2, "1/30/2017", "Return books to library.");
    
    ToDoList myList = new ToDoList();
    myList.addToDo(i1);
    myList.addToDo(i2);
    myList.addToDo(i3);
    
    System.out.println(myList);
   
    System.out.println("\nSwitched to sorting by urgency:");
    myList.sortByUrgency();
    System.out.println(myList);
    
    System.out.println("\nSwitched back to sorting by due date:");
    myList.sortByDueDate();
    System.out.println(myList);   
    }    
}

