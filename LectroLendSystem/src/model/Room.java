/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class Room {

    private String roomNumber; 
    private int capacity; 
    private String campus; 
    private boolean hasScreen; 
    private LocalDateTime createdAt;

    public Room() {
    }

    public Room(String roomNumber, int capacity, String campus, boolean hasScreen, LocalDateTime createdAt) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.campus = campus;
        this.hasScreen = hasScreen;
        this.createdAt = createdAt;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public boolean isHasScreen() {
        return hasScreen;
    }

    public void setHasScreen(boolean hasScreen) {
        this.hasScreen = hasScreen;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    
    
}
