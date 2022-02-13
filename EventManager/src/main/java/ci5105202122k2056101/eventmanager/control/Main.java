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

    public static void main(String[] args) {
        //Objects creation
        Eventmanager prog = new Eventmanager();
        System.out.println(prog.getClass());
        Event local = new Event();
        Event global = new Event();
        System.out.println(prog.addEventToManager(local));
        System.out.println(prog.addEventToManager(local));
        System.out.println(prog.eventInList(local));
        System.out.println(prog.removeEventFromManager(local));
        System.out.println(prog.eventInList(local));
        System.out.println(prog.removeEventFromManager(global));

        Item localItem = new Item();
        Item globalItem = new Item();
        System.out.println(prog.addItemToManager(localItem));
        System.out.println(prog.addItemToManager(localItem));
        System.out.println(prog.itemInList(localItem));
        System.out.println(prog.removeItemFromManager(localItem));
        System.out.println(prog.itemInList(localItem));
        System.out.println(prog.removeItemFromManager(localItem));
        
        Organiser me = new Organiser();
        Organiser you = new Organiser();
        System.out.println(prog.addEventToManager(local));
        
        System.out.println(local.setOrganiser(me));
        System.out.println(local.setOrganiser(me));
        System.out.println(local.setOrganiser(you));
        System.out.println(local.getOrganiser().equals(you));
        
        
         
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
