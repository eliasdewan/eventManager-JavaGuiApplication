/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.control;

import javax.swing.JButton;

/**
 *
 * @author k2056101
 */
public class GUIControl {

    private static JButton load = new JButton("Load");
    private static JButton save = new JButton("Save");
    private static JButton add = new JButton("Add");

    public static JButton getLoad() {
        return load;
    }

    public static JButton getSave() {
        return save;
    }

    public static JButton getAdd() {
        return add;
    }

}
