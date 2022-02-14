/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.view;

import ci5105202122k2056101.eventmanager.control.GUIControl;
import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author k2056101
 */
public class GuiViewer extends JFrame {

    private JTextArea textArea = new JTextArea();
    private JMenuBar menubar;

    public void view() { // Make viewer visible and size 500 -500
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(rootPaneCheckingEnabled);

    }

    public void viewTextArea() {
        textArea.setText("Woring example");
        this.add(textArea, BorderLayout.CENTER);
    }

    public void viewMenuBar() { //Add menubar to viewer
        GUIControl controls = new GUIControl();
        menubar = GUIControl.getMb();
        this.setJMenuBar(menubar);
        menubar.add(GUIControl.getFile());
        menubar.add(GUIControl.getExit());
        GUIControl.getFile().add(GUIControl.getLoadFile());
        GUIControl.getFile().add(GUIControl.getSaveFile());

    }

    public static void GuiViewerStart() {
        GuiViewer start = new GuiViewer();
        
        GUIControl controls = new GUIControl();
        
        controls.actionForButtons(); // Assign action listener

        start.setLayout(new BorderLayout());//Button and layout setting
        start.viewTextArea();
        //start.add(GUIControl.getLoad(), BorderLayout.CENTER);

        start.viewMenuBar();// Jmenubar add to view

        start.view();//make frame visible

    }
}
