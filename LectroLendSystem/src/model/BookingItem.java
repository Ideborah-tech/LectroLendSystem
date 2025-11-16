/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
class BookingItem {
    private int bookingItemId;
    private int bookingId;
    private int equipmentId;
    private int quantity;

    public BookingItem() {
    }

    public BookingItem(int bookingItemId, int bookingId, int equipmentId, int quantity) {
        this.bookingItemId = bookingItemId;
        this.bookingId = bookingId;
        this.equipmentId = equipmentId;
        this.quantity = quantity;
    }

    public int getBookingItemId() {
        return bookingItemId;
    }

    public void setBookingItemId(int bookingItemId) {
        this.bookingItemId = bookingItemId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
