/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.model;

import java.util.ArrayList;
import java.util.Arrays;// imported for adding the items

/**
 *
 * @author k2056101
 */
public class Event {

    private String title;
    private Organiser organiser;
    private String time;
    private String date;
    private String location;
    private ArrayList<Item> items;

    public Event() {
        items = new ArrayList();
    }

    public void addItem(Item item) {
    items.add(item);
//items = Arrays.copyOf(items, items.length);
       // items[items.length - 1] = item;
    }
}
