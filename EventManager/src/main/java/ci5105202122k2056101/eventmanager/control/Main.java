/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.control;

import ci5105202122k2056101.eventmanager.model.*;
import ci5105202122k2056101.eventmanager.utils.DataManager;
import ci5105202122k2056101.eventmanager.view.GuiViewer;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import javax.swing.JButton;

/**
 *
 * @author k2056101
 */
public class Main {

    /**
     *
     * @param args
     *
     * For Event manager requires initialize an event manager; Eventmanager prog
     * = new Eventmanager(); // Like this
     */
    public static void main(String[] args) {
        //Objects creation - testing initialization
        Eventmanager prog = new Eventmanager();
        System.out.println(prog.getClass());
        //Creating event and  testing the add and remove methods
        //From eventmanager Eventlist
        Event local = new Event();
        local.setTitle("First item");
        Event global = new Event();
        System.out.println(prog.addEventToManager(local));
        System.out.println(prog.addEventToManager(local));
        System.out.println(prog.eventInList(local));
        System.out.println(prog.removeEventFromManager(local));
        System.out.println(prog.eventInList(local));
        System.out.println(prog.removeEventFromManager(global));

//Adding and removing item testing from eventmanager itemList
        Item localItem = new Item();
        Item globalItem = new Item();
        System.out.println(prog.addItemToManager(localItem));
        System.out.println(prog.addItemToManager(localItem));
        System.out.println(prog.itemInList(localItem));
        System.out.println(prog.removeItemFromManager(localItem));
        System.out.println(prog.itemInList(localItem));
        System.out.println(prog.removeItemFromManager(localItem));

        //Creating organiser for Association organiser
        Organiser me = new Organiser();
        Organiser you = new Organiser();
        System.out.println(prog.addEventToManager(local));
        //Associating event with organiser and testing
        System.out.println(local.setOrganiser(me));
        System.out.println(local.setOrganiser(me));
        System.out.println(local.setOrganiser(you));
        System.out.println(local.getOrganiser().equals(you));

        //Load From file 
        //  DataManager.fileToString("Eventmanager.csv");//Convert from file to string in a parameter
        // DataManager.loadFromString(prog); // Load and create all data when string is loaded
        //System.out.println(DataManager.listEventManager(prog));//Printing all the data
        //Add agenda item to Event
        System.out.println(local.addIAgendatemToEvent(new Item("Break", "12:20")));
        //Edit agenda items
        local.setTitle("Complete event");
        local.setDate("2022-05-15");
        local.setTime("09:00");
        local.setLocation("Outside Park ☠");
        System.out.println(DataManager.listEvent(local));
        //Saving file testing
        //DataManager.loadToString(prog); // Load current data to the sting
        //DataManager.printLoadedString();// Printing file format of all the data when its loaded
        //DataManager.saveToFile("Eventmanager.csv");
        //
        /*
        
        //Setting event Attributes
        starting.setTitle("Starting");
        starting.setOrganiser(me);
        starting.setTime("12:12");
        starting.setDate("2020-12-25");
        /*starting.setTime(LocalTime.of(12, 12));
        starting.setDate(LocalDate.of(2010, 12, 15));*/
 /* starting.setLocation("Here");
        prog.getEventList().add(starting);
        //Setting organiser attributes
        me.setName("Elias");
        System.out.println(DataManager.listEventManager(prog));
         */
        //starting.addItem(smallbreak);
        //String name = starting.getOrganiser().getName();
        //System.out.println(name);
        // System.out.println(prog.eventInList(starting));

        /*GUI TESTING
        GuiViewer view = new GuiViewer();
        GUIControl controls = new GUIControl();
        view.setLayout(new BorderLayout());
        view.add(GUIControl.getLoad(),BorderLayout.CENTER);
        view.view();*/
    }

}
