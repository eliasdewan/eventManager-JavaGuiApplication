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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author k2056101 This will be for file access and save methods
 */
public class DataManager {

    static String loadedString = "";
    static Eventmanager prog;

    public DataManager() {
    }
    
    
    
    //As a datamanager it should hold all data in this case eventmanager encapsulates all
    public static Eventmanager getProg() {
        return prog;
    }

    public static void setProg(Eventmanager prog) {
        DataManager.prog = prog;
    }
    
    public static void printLoadedString() {
        System.out.println("Starts here");
        System.out.println(loadedString);
    }

    /**
     *
     * @param prog
     * @return text With all the details going though each item list and event
     * list Incling child parameters and their list
     */
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

    /**
     *
     * @param event
     * @return event data in astring for agendaitem list goes in a loop
     */
    public static String listEvent(Event event) {
        String text = "";
        text += event.getTitle() + System.lineSeparator();
        text += event.getOrganiser().getName() + System.lineSeparator();
        text += event.getTime() + System.lineSeparator();
        text += event.getDate() + System.lineSeparator();
        text += event.getLocation() + System.lineSeparator();
        for (Item item : event.getItems()) {
            text += item.getItemtitle() + System.lineSeparator();
            text += item.getItemStartTime() + System.lineSeparator();
        }
        return text;
    }

    /**
     *
     * @param prog to Clear the event manager data of a event manager object
     */
    public static void clearEventmanager(Eventmanager prog) {
        prog.getEventList().clear();
        prog.getItemList().clear();

    }

    //File file = new File("Eventmanager.csv"); // Temporary
    /**
     *
     * @param fileName is String location of csv This loads every thing into a
     * static String loadedString
     *
     */
    public static void fileToString(String fileName) {
        try {
            File file = new File(fileName);
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
            System.out.println("File reading failed, File not found");
        }
    }

    /**
     * Uses the static string loadedString
     *
     * @param evm Goes through the String file line by line creating object
     * First splitting into lines then looping split comma of each line to
     * identify what it should create Format comment out the clear event manager
     * function to load from file without removing existing data
     * <Eventmanager>
     * <Event>,title,time,date,location
     * <Organiser>,name
     * <Item>,itemtitle,itemstarttime
     */
    public static void loadFromString(Eventmanager evm) {
        //DataManager.clearEventmanager(evm); // If needed to clear event manager
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
                    System.out.println(evm.getEventList().get(evm.getEventList().size() - 1).addIAgendatemToEvent(new Item(creationunit[1], creationunit[2])));
                } else if (locator == 1) {
                    System.out.println("Add item Manager");
                    System.out.println(evm.addItemToManager(new Item(creationunit[1], creationunit[2])));
                }
            }

        }
    }

    public static void saveToFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufwrite = new BufferedWriter(new FileWriter(file));
            bufwrite.write(loadedString);
            bufwrite.newLine();
            // System.out.println(readFile());
            bufwrite.close();
            System.out.println("Write Successfull");
        } catch (IOException e) {
            System.out.println("Write failed");
        }
    }

    /**
     * Creates a string of how it should create the string to save
     *
     * @param prog
     */
    public static void loadToString(Eventmanager prog) {
        loadedString = "<Eventmanager>" + System.lineSeparator();
        for (Item item : prog.getItemList()) {
            loadedString += "<Item>," + item.getItemtitle() + "," + item.getItemStartTime() + System.lineSeparator();
        }
        for (Event event : prog.getEventList()) {
            loadedString += "<Event>," + event.getTitle() + "," + event.getTime() + "," + event.getDate() + "," + event.getLocation() + System.lineSeparator();
            loadedString += "<Organiser>," + event.getOrganiser().getName() + System.lineSeparator();
            for (Item item : event.getItems()) {

                loadedString += "<Item>," + item.getItemtitle() + "," + item.getItemStartTime() + System.lineSeparator();
            }
        }
    }
}
