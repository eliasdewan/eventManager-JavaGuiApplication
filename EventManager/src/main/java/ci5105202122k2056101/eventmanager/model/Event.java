/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.model;

import java.util.ArrayList;

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
        this.items.add(item);

//items = Arrays.copyOf(items, items.length);
        // items[items.length - 1] = item;
    }

    public boolean removeItem(Item item) {
        boolean remove = this.items.remove(item);
        return remove;
    }
    
    // General getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Organiser getOrganiser() {
        return organiser;
    }

    public void setOrganiser(Organiser organiser) {
        this.organiser = organiser;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    
    
}
