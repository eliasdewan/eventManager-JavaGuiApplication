/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.control;

import ci5105202122k2056101.eventmanager.model.*;


/**
 *
 * @author k2056101
 */
public class Main {

    public static void main(String[] args) {
        Event starting = new Event();
        Item smallbreak = new Item();
        Organiser me = new Organiser();
        me.setName("Elias");
        starting.setOrganiser(me);
        starting.addItem(smallbreak);
        String name = starting.getOrganiser().getName();
        System.out.println(name);
        System.out.println(name);
        
    }
    
}
