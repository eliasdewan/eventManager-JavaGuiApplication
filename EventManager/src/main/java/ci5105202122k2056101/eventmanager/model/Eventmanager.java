/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ci5105202122k2056101.eventmanager.model;

import java.util.ArrayList;

/**
 * Added Array list for eventList and itemList Constructor that initializes the
 * arrays add to event manager and remove from event manager for both items and
 * events
 *
 * @author come1
 */
public class Eventmanager {

    private ArrayList<Event> eventList;
    private ArrayList<Item> itemList;

    public Eventmanager() {
        this.eventList = new ArrayList();
        this.itemList = new ArrayList();
    }

    // Testing ----------------
    public boolean eventInList(Event event) {
        return this.eventList.contains(event);
    }
    public boolean itemInList(Item item) {
        return this.itemList.contains(item);
    }

    //General getters and setters
    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public String addEventToManger(Event event) {
        if (this.eventInList(event)) {
            return "Already exist in list!";
        } else {
            this.eventList.add(event);
            return "Added to the EventManager event list";
        }
    }

    public String removeEventFromManger(Event event) {
        if (this.eventInList(event)) {
            this.eventList.remove(event);
            return "Removed!";
        } else {
            return "Does not exist";
        }
    }
    
    public String addItemToManger(Item item) {
        if (this.itemInList(item)) {
            return "Already exist in list!";
        } else {
            this.itemList.add(item);
            return "Added to the EventManager item list";
        }
    }

}
