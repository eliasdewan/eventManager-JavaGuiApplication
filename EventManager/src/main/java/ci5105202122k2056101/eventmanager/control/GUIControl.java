/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.control;

import ci5105202122k2056101.eventmanager.utils.DataManager;
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

    private static JButton load = new JButton("Load");
    private static JButton save = new JButton("Save");
    private static JButton add = new JButton("Add");
    private static JMenuBar mb = new JMenuBar();
    private static JMenu file = new JMenu("File");
    private static JMenuItem exit = new JMenuItem("Exit");
    private static JMenuItem loadFile = new JMenuItem("Load from file");
    private static JMenuItem saveFile = new JMenuItem("Save to file");
    private static JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

    public void actionForButtons() {//Adding listener to all buttons
        load.addActionListener(this);
        save.addActionListener(this);
        add.addActionListener(this);
        file.addActionListener(this);
        loadFile.addActionListener(this);
        saveFile.addActionListener(this);
        exit.addActionListener(this);
    }

    public static JButton getLoad() {
        return load;
    }

    public static JButton getSave() {
        return save;
    }

    public static JButton getAdd() {
        return add;
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
                fileChooser.setSelectedFile(file);
            }
        } else if (e.getActionCommand().equals("Save to file")) {
            System.out.println("Clicked save to file");
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                fileChooser.setFileFilter(new FileNameExtensionFilter("CSV file", "csv"));
                File file = fileChooser.getSelectedFile();
                System.out.println(file.getAbsoluteFile());
                
              //  DataManager.loadToString(); //Requires data manager
                DataManager.saveToFile(file.getAbsolutePath());
            }
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }
}
