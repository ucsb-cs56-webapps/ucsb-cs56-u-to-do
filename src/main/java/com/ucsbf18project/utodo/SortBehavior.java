package com.ucsbf18project.utodo;

import java.util.Comparator;
import java.io.Serializable;

public interface SortBehavior extends Comparator<ListItem>, Serializable {
    @Override
    public int compare(ListItem listItem1, ListItem listItem2);
}

