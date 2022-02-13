/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.utils;

import ci5105202122k2056101.eventmanager.model.Event;
import ci5105202122k2056101.eventmanager.model.Eventmanager;
import ci5105202122k2056101.eventmanager.model.Item;
import ci5105202122k2056101.eventmanager.model.Organiser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author k2056101 This will be for file access and save methods
 */
public class DataManager {

    static String loadedString = "";

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
    //File file = new File("Eventmanager.csv"); // Temporary

    /**
     *
     * @param file Reads file and stores as string in loadedString
     */
    public static void fileToString() {
        try {
            File file = new File("Eventmanager.csv");
            loadedString = "";
            BufferedReader bufread = new BufferedReader(new FileReader(file));
            while (bufread.ready()) {
                //String[] currentLine = bufread.readLine().split(",");
                String currentLine = bufread.readLine();

                loadedString += currentLine;
                loadedString += System.lineSeparator();
            }
            System.out.println(loadedString);
        } catch (IOException FileNotFoundException) {
            //System.out.println("File reading failed, File not found");
        }
    }

    public static void loadFromFile(Eventmanager evm) {
        int locator = 0; // For adding item to manager or event
        String[] splitLoadedString = loadedString.split(System.lineSeparator());
        for (String singleline : splitLoadedString) {
            //System.out.println(singleline);
            String[] creationunit = singleline.split(",");

            if (creationunit[0].equals("<Eventmanager>")) {
                System.out.println("Manager found");
                locator = 1;

            } else if (creationunit[0].equals("<Event>")) {
                System.out.println("Event found");
                evm.addEventToManager(new Event(creationunit[1], creationunit[2], creationunit[3], creationunit[4]));
                locator = 0;
            } else if (creationunit[0].equals("<Organiser>")) {
                System.out.println("Organiser found");
                //Last event created
                System.out.println(evm.getEventList().get(evm.getEventList().size() - 1).setOrganiser(new Organiser(creationunit[1])));

            } else if (creationunit[0].equals("<Item>")) {
                if (locator == 0) {
                    System.out.println("Add item Event");
                    System.out.println(evm.getEventList().get(evm.getEventList().size() - 1).addItemToEvent(new Item(creationunit[1], creationunit[2])));
                } else if (locator == 1) {
                    System.out.println("Add item Manager");
                    System.out.println(evm.addItemToManager(new Item(creationunit[1], creationunit[2])));
                }
            }

        }
    }


    /* public void saveToFile(){
        <Eventmanager>
        <Event>
        <Organiser>
        <Item>
     */
}
