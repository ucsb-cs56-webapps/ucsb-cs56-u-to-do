import java.util.Comparator;

public class SortByDueDate implements Comparator<ListItem> {
        @Override
        public int compare(ListItem l1, ListItem l2) {
            String[] moDayYr1 = l1.getDueDate().split("/");
            String[] moDayYr2 = l2.getDueDate().split("/");
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
