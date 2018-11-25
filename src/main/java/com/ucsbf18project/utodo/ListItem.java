package com.ucsbf18project.utodo;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ListItem implements Serializable, Comparable<ListItem> {
    private int urgency;
    private Date dueDateAndTime;
    private String message;
    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("M/d/yyyy h:mm a");
    
    ListItem() {  
    }
    
    ListItem(int urgency, String dueDateAndTime, String message) {
        changeUrgency(urgency);
        changeDueDateAndTime(dueDateAndTime);
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public int getUrgency() {
        return this.urgency;
    }
    
    public void setUrgency(int urgency) {
        changeUrgency(urgency);
    }
    
    public Date getDueDatAndTime() {
        return this.dueDateAndTime;
    }
    
    public void setDueDateAndTime(String dueDateAndTime) {
        changeDueDateAndTime(dueDateAndTime);
    }
    
    private boolean changeDueDateAndTime(String dueDateAndTime) {
        try {
            dateTimeFormat.parse(dueDateAndTime);
            this.dueDateAndTime = new Date(dueDateAndTime);
            return true;
        } catch(Exception e) {
            this.dueDateAndTime = new Date("01/01/2018 12:00 PM");
            return false;
        }
    }
    
    // Can set urgency on a scale from 1-3. If an argument is passed to this 
    // method that isn't in that range the To-Do gets a default urgency of 1.
    private boolean changeUrgency(int urgency) {
        if(urgency >= 0 && urgency <= 3) {
            this.urgency = urgency; 
            return true;
        }
        this.urgency = 1;
        return false;
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
                this.dueDateAndTime.equals(listItemToCheck.dueDateAndTime) );
    }
  
    @Override
    public int hashCode() {
        return (this.message + this.urgency + dueDateAndTime.toString()).hashCode();
    }
    
    @Override
    public String toString() {
        String retStr = "Due Date: " + dateTimeFormat.format(this.dueDateAndTime) + "\nUrgency: ";
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
        if(this.dueDateAndTime.equals(item.dueDateAndTime)) {
            return item.getUrgency() - this.getUrgency();
        } else {
            return this.dueDateAndTime.compareTo(item.dueDateAndTime);
        }
    }     
}
