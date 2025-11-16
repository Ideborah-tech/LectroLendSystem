/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author User
 */
public class Booking {
    private int bookingId;
    private String username;
    private String course;
    private String lecturer;
    private String purpose;
    private String booking_phone_number;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
      private List<BookingItem> equipmentItems;

    public Booking() {
    }

    public Booking(int bookingId, String username, String course, String lecturer, String purpose, String booking_phone_number, LocalDateTime startTime, LocalDateTime endTime, String status, LocalDateTime createdAt, LocalDateTime updatedAt, List<BookingItem> equipmentItems) {
        this.bookingId = bookingId;
        this.username = username;
        this.course = course;
        this.lecturer = lecturer;
        this.purpose = purpose;
        this.booking_phone_number = booking_phone_number;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.equipmentItems = equipmentItems;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getBooking_phone_number() {
        return booking_phone_number;
    }

    public void setBooking_phone_number(String booking_phone_number) {
        this.booking_phone_number = booking_phone_number;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<BookingItem> getEquipmentItems() {
        return equipmentItems;
    }

    public void setEquipmentItems(List<BookingItem> equipmentItems) {
        this.equipmentItems = equipmentItems;
    }


}

    

    