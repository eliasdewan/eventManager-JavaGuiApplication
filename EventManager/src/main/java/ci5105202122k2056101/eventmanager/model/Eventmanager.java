/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ci5105202122k2056101.eventmanager.model;

import java.util.ArrayList;

/**
 *Added Array list for eventist and itemlist
 * Constructor that initializes the arrays
 *add to event manager and remove from event manager for both items and events
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
    public boolean eventInList(Event event){
        return this.eventList.contains(event);
                }

    public void addEventToEventManager(Event event) {
        this.eventList.add(event);
    }

    public void removeEventFromEventManager(Event event) {
        this.eventList.remove(event);
    }

    public void addItemToEventManager(Item item) {
        this.itemList.add(item);
    }
    
    public void removeItemFromEventManager(Item item) {
        this.itemList.remove(item);
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

    
    
    
}
