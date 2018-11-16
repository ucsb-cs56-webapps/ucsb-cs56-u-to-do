import java.util.Comparator;

public class SortByUrgency implements Comparator<ListItem> {
        @Override
        public int compare(ListItem l1, ListItem l2) {
            return l2.getUrgency() - l1.getUrgency();
        }
    } 
