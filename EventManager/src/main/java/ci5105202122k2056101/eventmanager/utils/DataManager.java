/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.utils;

import ci5105202122k2056101.eventmanager.model.Event;
import ci5105202122k2056101.eventmanager.model.Eventmanager;
import ci5105202122k2056101.eventmanager.model.Item;

/**
 *
 * @author k2056101 This will be for file access and save methods
 */
public class DataManager {

    public static String listEventManager(Eventmanager prog) {
        String text = "";
        for (Item item : prog.getItemList()) {
            text += item.getItemtitle() + System.lineSeparator();
            text += item.getItemStartTime() + System.lineSeparator();
        }
        for (Event event : prog.getEventList()) {
            text += event.getTitle() + System.lineSeparator();
            text += event.getOrganiser().getName() + System.lineSeparator();
            text += event.getTime() + System.lineSeparator();
            text += event.getDate() + System.lineSeparator();
            text += event.getLocation() + System.lineSeparator();
            for (Item item : event.getItems()) {
                text += item.getItemtitle() + System.lineSeparator();
                text += item.getItemStartTime() + System.lineSeparator();
            }
        };

        return text;
    }

}
