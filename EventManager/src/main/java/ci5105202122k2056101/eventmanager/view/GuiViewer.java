/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.view;

import ci5105202122k2056101.eventmanager.control.GUIControl;
import ci5105202122k2056101.eventmanager.model.Event;
import ci5105202122k2056101.eventmanager.utils.DataManager;
import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author k2056101
 */
public class GuiViewer extends JFrame {

    // private JTextArea textArea = new JTextArea();
    private JMenuBar menubar;
    private static GuiViewer start;
    private static JPanel eventPanel = new JPanel(new BorderLayout());

    public void view() { // Make viewer visible and size 500 -500
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(rootPaneCheckingEnabled);
    }

    public static void updateView() {
        eventPanel.removeAll();
        System.out.println("Triggered update view");
        int n = 0;// For button action
        for (Event event : DataManager.getEventManager().getEventList()) {
            eventPanel.add(new JTextArea(DataManager.listEvent(event)), BorderLayout.CENTER);
            eventPanel.add(GUIControl.getView(), BorderLayout.WEST);
            eventPanel.add(new JTextArea(DataManager.listEvent(event)), BorderLayout.EAST);
        }
        
        start.add(eventPanel);
        SwingUtilities.updateComponentTreeUI(start);
        //start.update(start.getGraphics());// ----Works but slow

    }

    public void viewData() {

    }

    public void viewMenuBar() { //Add menubar to viewer with file (Load and save) and exit
        GUIControl controls = new GUIControl();
        menubar = GUIControl.getMb();
        this.setJMenuBar(menubar);
        menubar.add(GUIControl.getFile());
        menubar.add(GUIControl.getExit());
        GUIControl.getFile().add(GUIControl.getLoadFile());
        GUIControl.getFile().add(GUIControl.getSaveFile());

    }

    public static void GuiViewerStart() { //Start point of gui
        start = new GuiViewer(); // New gui viewer
        GUIControl controls = new GUIControl();//New gui control element
        controls.actionForButtons(); // Assign action listener
        start.viewMenuBar();// Jmenubar add to view
        //GuiViewer.updateView();
        //start.updateView();// Loading the content into the panel ----------
        start.view();//make frame visible

    }
}
