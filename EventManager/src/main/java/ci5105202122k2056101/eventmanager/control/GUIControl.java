/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.control;

import ci5105202122k2056101.eventmanager.utils.DataManager;
import ci5105202122k2056101.eventmanager.view.GuiViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File; // remove later
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author k2056101
 */
public class GUIControl implements ActionListener {

    private static JMenuBar mb = new JMenuBar();
    private static JMenu file = new JMenu("File");
    private static JMenuItem exit = new JMenuItem("Exit");
    private static JMenuItem loadFile = new JMenuItem("Load from file");
    private static JMenuItem saveFile = new JMenuItem("Save to file");
    private static JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

    public void actionForButtons() {//Adding listener to all buttons

        file.addActionListener(this);
        loadFile.addActionListener(this);
        saveFile.addActionListener(this);
        exit.addActionListener(this);

    }

    public static JMenuBar getMb() {
        return mb;
    }

    public static JMenuItem getExit() {
        return exit;
    }

    public static JMenu getFile() {
        return file;
    }

    public static JMenuItem getLoadFile() {
        return loadFile;
    }

    public static JMenuItem getSaveFile() {
        return saveFile;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Load from file")) {
            System.out.println("Clicked load from file");

            fileChooser.setFileFilter(new FileNameExtensionFilter("CSV file", "csv"));
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                System.out.println(file.getAbsoluteFile());//Prints the location of file
                DataManager.fileToString(file.getAbsolutePath()); //String from file
                DataManager.loadFromString(DataManager.getEventManager()); //Requires data manager to load data to
                GuiViewer.updateView();
            }
        } else if (e.getActionCommand().equals("Save to file")) {
            System.out.println("Clicked save to file");
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                fileChooser.setFileFilter(new FileNameExtensionFilter("CSV file", "csv"));
                File file = fileChooser.getSelectedFile();
                System.out.println(file.getAbsoluteFile());
                DataManager.loadToString(DataManager.getEventManager()); //Requires data manager - loads in string
                DataManager.saveToFile(file.getAbsolutePath()); // Saves to file selected if file not exist will create
            }
        } else if (e.getActionCommand().contains("View")) {
            System.out.println("Clicked view");
            //System.out.println("Given substing:"+e.getActionCommand().substring(4));
            //System.out.println("Given replaced:"+e.getActionCommand().replace("View", ""));
            int n = Integer.valueOf(e.getActionCommand().replace("View", ""));

            //System.out.println("Got this number:"+n);
            System.out.println(DataManager.listEvent(DataManager.getEventManager().getEventList().get(n)));
            GuiViewer.viewEvent(DataManager.getEventManager().getEventList().get(n));

        } else if (e.getActionCommand().contains("Edit")) {
            System.out.println("Clicked edit");
            //System.out.println("Given replaced:"+e.getActionCommand().replace("View", ""));
            int n = Integer.valueOf(e.getActionCommand().replace("Edit", ""));

            //System.out.println("Got this number:"+n);
            //System.out.println(DataManager.listEvent(DataManager.getEventManager().getEventList().get(n)));
            GuiViewer.editEventForm(DataManager.getEventManager().getEventList().get(n));

        } else if (e.getActionCommand().equals("Add Event")) {
            System.out.println("Clicked add");
            GuiViewer.addEventForm();

        } else if (e.getActionCommand().equals("Add")) {
            System.out.println("Clicked add ftom creating event");

        } else if (e.getActionCommand().contains("Delete")) {
            System.out.println("Clicked delete event");
            int n = Integer.valueOf(e.getActionCommand().replace("Delete", ""));
            DataManager.getEventManager().getEventList().remove(n);
            GuiViewer.updateView();
        } else if (e.getActionCommand().contains("DelItem")) {
            System.out.println("Clicked Item event");
            int n = Integer.valueOf(e.getActionCommand().replace("DelItem", ""));

            DataManager.getEventManager().getItemList().remove(n);
            GuiViewer.updateView();
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }
}
