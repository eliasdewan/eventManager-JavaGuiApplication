/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci5105202122k2056101.eventmanager.model;

import java.time.LocalTime;

/**
 *
 * @author k2056101
 */
public class Item {

    private String itemtitle;
    private LocalTime itemStartTime;

    public Item() {
        itemtitle="Not set";
        itemStartTime= LocalTime.of(0, 0);
    }

    public Item(String itemtitle, LocalTime itemStartTime) {
        this.itemtitle = itemtitle;
        this.itemStartTime = itemStartTime;
    }

    public Item(String itemtitle, String itemStartTime) {
        this.itemtitle = itemtitle;
        this.itemStartTime = LocalTime.parse(itemStartTime);
    }

    // General getter and setters
    public String getItemtitle() {
        return itemtitle;
    }

    public void setItemtitle(String itemtitle) {
        this.itemtitle = itemtitle;
    }
    
    //Local time methods
    public LocalTime getItemStartTime() {
        return itemStartTime;
    }

    public void setItemStartTime(String itemStartTime) {
        this.itemStartTime = LocalTime.parse(itemStartTime);
    }

    public void setItemStartTime(LocalTime itemStartTime) {
        this.itemStartTime = itemStartTime;
    }

}
