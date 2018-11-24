public class ListItem implements Comparable<ListItem> {
    private int urgency;
    private String dueDate;
    private String message;
    
    ListItem(int urgency, String dueDate, String message) {
        this.urgency = urgency;
        this.dueDate = dueDate;
        this.message = message;
    }
    
    public int getUrgency() {
        return this.urgency;
    }
    
    // Can set urgency on a scale from 1-3. If an argument is passed to this 
    // method that isn't in that range the To-Do gets a default urgency of 1.
    public boolean setUrgency(int urgency) {
        if(urgency >= 0 && urgency <= 3) {
            this.urgency = urgency; 
            return true;
        }
        this.urgency = 1;
        return false;
    }
    
    public String getDueDate() {
        return this.dueDate;
    }
    
    public void setDate(String dueDate) {
        this.dueDate = dueDate;
    }
    
    @Override
    public boolean equals(Object aListItem) {
        if(aListItem == null) {
            return false;
        }
        if( !(aListItem instanceof ListItem) ) {
            return false; 
        }
        ListItem listItemToCheck = (ListItem)aListItem;
        return ( (this.urgency == listItemToCheck.urgency) &&
                this.message.equals(listItemToCheck.message) &&
                this.dueDate.equals(listItemToCheck.dueDate) );
    }
    
    // hashCode uses the dueDate of the ListItem by default.
    @Override
    public int hashCode() {
        return dueDate.hashCode();
    }
    
    @Override
    public String toString() {
        String retStr = "Due Date: " + this.dueDate + "\nUrgency: ";
        if(this.urgency == 1) {
            retStr += "Not Urgent\n";
        } else if(this.urgency == 2) {
            retStr += "Somewhat Urgent\n";
        } else if (this.urgency == 3) {
            retStr += "Very Urgent\n";
        } else {
            retStr += this.urgency + "\n";
        }
        retStr += "To-Do: " + message;
        return retStr;
    } 
    
    // The default sorting method is to sort by due date
    @Override
    public int compareTo(ListItem item) {
        String[] moDayYr1 = this.getDueDate().split("/");
            String[] moDayYr2 = item.getDueDate().split("/");
            // Compare the years
            if( !(moDayYr1[2].equals(moDayYr2[2])) ) {
                return moDayYr1[2].compareTo(moDayYr2[2]);
            // Compare the months
            } else if( !(moDayYr1[0].equals(moDayYr2[0])) ) {
                return moDayYr1[0].compareTo(moDayYr2[0]);
            } else {
                return moDayYr1[1].compareTo(moDayYr2[1]);
            }
    }
}
