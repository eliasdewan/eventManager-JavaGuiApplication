/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.view;

import ci5105202122k2056101.eventmanager.control.GUIControl;
import ci5105202122k2056101.eventmanager.model.Event;
import ci5105202122k2056101.eventmanager.model.Eventmanager;
import ci5105202122k2056101.eventmanager.model.Item;
import ci5105202122k2056101.eventmanager.utils.DataManager;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

/**
 *
 * @author k2056101
 */
public class GuiViewer extends JFrame {

    // private JTextArea textArea = new JTextArea();
    private JMenuBar menubar;
    private static GuiViewer start;
    private static ScrollPane mainPane = new ScrollPane();//Main scrollable area
    private static GUIControl controls;

    public void view() { // Make viewer visible and size 500 -500
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(rootPaneCheckingEnabled);
    }

    //JFrame-->mainPane-->eventList-->buttonPanel,view,textarea
    public static void updateView() {//======================================
        JPanel eventList = new JPanel(new GridLayout(0, 1));// List of events
        //eventList.setPreferredSize(new Dimension(450, 100));
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));// Panel for east side buttons
        //BoxLayout box = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        JPanel eventPanel = new JPanel(new BorderLayout()); // // Panel new 
        //eventPanel.setPreferredSize(new Dimension(1000, 1000));
        JPanel eventData = new JPanel(new GridLayout(0, 1)); // // Panel new  
        JPanel viewButton = new JPanel(new GridLayout(0, 1)); // // Panel new  

        int en = 0;// For button action
        int in = 0;

        for (Item item : DataManager.getEventManager().getItemList()) {
            viewButton.add(new JLabel("Item"));
            JTextArea text = new JTextArea(DataManager.listItem(item));
            text.setPreferredSize(new Dimension(300, 100));
            eventData.add(text);
            eventPanel.add(viewButton, BorderLayout.WEST);
            eventPanel.add(eventData, BorderLayout.CENTER);
            eventPanel.add(buttonPanel, BorderLayout.EAST);

            JButton edit = new JButton("Edit");
            edit.addActionListener(controls);
            edit.setActionCommand("EdItem" + in);
            buttonPanel.add(edit);

            JButton delete = new JButton("Delete");
            delete.addActionListener(controls);
            delete.setActionCommand("DelItem" + in);
            buttonPanel.add(delete);

            in++;
            eventList.add(eventPanel);
        }

        for (Event event : DataManager.getEventManager().getEventList()) {//    LOOP
            JButton view = new JButton("View");
            view.setActionCommand("View" + en);
            view.addActionListener(controls);
            viewButton.add(view);

            JTextArea text = new JTextArea(DataManager.listEvent(event));
            text.setPreferredSize(new Dimension(300, 100));
            eventData.add(text);
            eventPanel.add(viewButton, BorderLayout.WEST);
            eventPanel.add(eventData, BorderLayout.CENTER);
            eventPanel.add(buttonPanel, BorderLayout.EAST);

            JButton edit = new JButton("Edit");
            edit.addActionListener(controls);
            edit.setActionCommand("Edit" + en);
            buttonPanel.add(edit);

            JButton delete = new JButton("Delete");
            delete.addActionListener(controls);
            delete.setActionCommand("Delete" + en);
            buttonPanel.add(delete);
            en++;
            eventList.add(eventPanel);
        }

        System.out.println(en + " Times looped"); // niber counter XXXXXXXX REMOVE LATER

        //Main elements and containers
        //Adding the panelcreated
        mainPane.add(eventList);//Add the list at the end to the scroll pane
        start.add(mainPane, BorderLayout.CENTER);// For updating its at the end
        SwingUtilities.updateComponentTreeUI(start); // uPDATE WINDOW
        //start.update(start.getGraphics());// ----Works but slow

    }//-------------------------------------------------

    public static void viewEvent(Event event) {

        JDialog addWindow = new JDialog();
        addWindow.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JPanel form = new JPanel(new GridLayout(0, 2));
        addWindow.add(form);
        JTextArea text = new JTextArea(DataManager.listEvent(event));;
        text.setPreferredSize(new Dimension(400, 100));
        form.add(text);

        addWindow.setSize(400, 400);
        addWindow.setVisible(true);

    }

    public static void addEventForm() {
        JDialog addWindow = new JDialog();
        addWindow.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JPanel form = new JPanel(new GridLayout(0, 2));
        addWindow.add(form);

        JTextField Time = new JTextField("00:00", 15);
        JTextField Date = new JTextField("2000-01-01", 15);
        JTextField Location = new JTextField("Not set", 15);
        JTextField EventTitle = new JTextField("Not set", 15);

        form.add(new JLabel("Event Title"));
        form.add(EventTitle);
        form.add(new JLabel("Event Time HH:FF Fornat"));
        form.add(Time);
        form.add(new JLabel("Event Date YYYY-MM-DD Format"));
        form.add(Date);
        form.add(new JLabel("Event Location"));
        form.add(Location);

        ActionListener window;
        window = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Add")) {
                    DataManager.getEventManager().addEventToManager(new Event(EventTitle.getText(), Time.getText(), Date.getText(), Location.getText()));
                    GuiViewer.updateView();
                    addWindow.dispose();
                } else if (e.getActionCommand().equals("Cancel")) {
                    addWindow.dispose();
                }
            }
        };

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(window);
        form.add(cancel);
        JButton add = new JButton("Add");//Added button add
        add.addActionListener(window);
        form.add(add);

        addWindow.setSize(400, 400);
        addWindow.setVisible(true);
    }

    public static void addItems() {
        JDialog addWindow = new JDialog();
        addWindow.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JPanel form = new JPanel(new GridLayout(0, 2));
        addWindow.add(form);

        JTextField Time = new JTextField("00:00", 15);
        JTextField ItemTitle = new JTextField("Not set", 15);

        form.add(new JLabel("Item Title"));
        form.add(ItemTitle);
        form.add(new JLabel("Event Time start HH:FF Fornat"));
        form.add(Time);

        ActionListener window;
        window = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Add")) {
                    DataManager.getEventManager().addItemToManager(
                            new Item(ItemTitle.getText(), Time.getText()));
                    GuiViewer.updateView();
                    addWindow.dispose();
                } else if (e.getActionCommand().equals("Cancel")) {
                    addWindow.dispose();
                }
            }
        };

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(window);
        form.add(cancel);
        JButton save = new JButton("Add");//Added button add
        save.addActionListener(window);
        form.add(save);

        addWindow.setSize(400, 400);
        addWindow.setVisible(true);
    }

    public static void editItems(Item item) {
        JDialog addWindow = new JDialog();
        addWindow.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JPanel form = new JPanel(new GridLayout(0, 2));
        addWindow.add(form);

        JTextField Time = new JTextField(item.getItemStartTime().format(DateTimeFormatter.ofPattern("hh:mm")), 15);
        JTextField ItemTitle = new JTextField(item.getItemtitle(), 15);

        form.add(new JLabel("Item Title"));
        form.add(ItemTitle);
        form.add(new JLabel("Event Time HH:FF Fornat"));
        form.add(Time);

        ActionListener window;
        window = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Save")) {
                    // DataManager.getEventManager().addEventToManager(new Event(EventTitle.getText(), Time.getText(), Date.getText(), Location.getText()));

                    item.setItemtitle(ItemTitle.getText());
                    item.setItemStartTime(Time.getText());
                    GuiViewer.updateView();
                    addWindow.dispose();
                } else if (e.getActionCommand().equals("Cancel")) {
                    addWindow.dispose();
                }
            }
        };

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(window);
        form.add(cancel);
        JButton save = new JButton("Save");//Added button add
        save.addActionListener(window);
        form.add(save);

        addWindow.setSize(400, 400);
        addWindow.setVisible(true);
    }

    public static void editEventForm(Event event) {
        JDialog addWindow = new JDialog();
        addWindow.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JPanel form = new JPanel(new GridLayout(0, 2));
        addWindow.add(form);

        JTextField Time = new JTextField(event.getTime().format(DateTimeFormatter.ofPattern("hh:mm")), 15);
        JTextField Date = new JTextField(event.getDate().format(DateTimeFormatter.ISO_DATE));
        JTextField Location = new JTextField(event.getLocation(), 15);
        JTextField EventTitle = new JTextField(event.getTitle(), 15);

        form.add(new JLabel("Event Title"));
        form.add(EventTitle);
        form.add(new JLabel("Event Time HH:FF Fornat"));
        form.add(Time);
        form.add(new JLabel("Event Date YYYY-MM-DD Format"));
        form.add(Date);
        form.add(new JLabel("Event Location"));
        form.add(Location);

        ActionListener window;
        window = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Save")) {
                    // DataManager.getEventManager().addEventToManager(new Event(EventTitle.getText(), Time.getText(), Date.getText(), Location.getText()));

                    event.setTitle(EventTitle.getText());
                    event.setTime(Time.getText());
                    event.setLocation(Location.getText());
                    event.setDate(Date.getText());
                    GuiViewer.updateView();
                    addWindow.dispose();
                } else if (e.getActionCommand().equals("Cancel")) {
                    addWindow.dispose();
                }
            }
        };

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(window);
        form.add(cancel);
        JButton save = new JButton("Save");//Added button add
        save.addActionListener(window);
        form.add(save);

        addWindow.setSize(400, 400);
        addWindow.setVisible(true);
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

    /**
     *Start point set DataManager.setEventManager(new Eventmanager());
     * if not done in main method and only using gui
     * 
     */
    public static void GuiViewerStart() { //Start point of gui
        DataManager.setEventManager(new Eventmanager());// Comment out if using test console
        start = new GuiViewer(); // New gui viewer
        start.setLayout(new BorderLayout()); // New gui viewer      
        controls = new GUIControl();//New gui control element
        controls.actionForButtons(); // Assign action listener
        start.viewMenuBar();// Jmenubar add to view
        start.viewMenuBar();
        mainPane.removeAll();
        JButton add = new JButton("Add Event");
        add.addActionListener(controls);
        start.add(add, BorderLayout.NORTH);
        JButton addItem = new JButton("Add Item");
        addItem.addActionListener(controls);
        start.add(addItem, BorderLayout.SOUTH);
        GuiViewer.updateView();
        start.view();
        //make frame visible

    }
}
