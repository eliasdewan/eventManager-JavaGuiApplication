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
public class Item {

    private String itemtitle;
    private String itemStartTime;

    public Item() {
        this.itemStartTime="";
        this.itemStartTime="";
    }
    public Item(String itemtitle, String itemStartTime) {
        this.itemtitle = itemtitle;
        this.itemStartTime = itemStartTime;
    }
    
    // General getter and setters

    public String getItemtitle() {
        return itemtitle;
    }

    public void setItemtitle(String itemtitle) {
        this.itemtitle = itemtitle;
    }

    public String getItemStartTime() {
        return itemStartTime;
    }

    public void setItemStartTime(String itemStartTime) {
        this.itemStartTime = itemStartTime;
    }
    
}
