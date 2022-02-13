/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.model;

/**
 *
 * @author k2056101
 */
public class Organiser {

    private String name;

    public Organiser() {
        name = "Name not set";
    }

    public Organiser(String name) {
        this.name = name;
    }

    //Basic setter and getters
    public String getName() {
        if (this.name == null) {
            return "Name not set";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
