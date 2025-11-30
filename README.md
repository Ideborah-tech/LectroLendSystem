# LectroLend – Smart Equipment Booking System

LectroLend is a robust desktop-based application designed to modernize and automate the management of shared educational and office equipment within the AUCA environment. It replaces cumbersome paper-based logs with an intuitive digital system to ensure accountability, real-time tracking, and efficient resource allocation.

---

## 1. Introduction & Problem Statement

### Introduction
The project aims to transform the process of borrowing shared classroom resources (projectors, cables, remotes) by providing a unified, digital platform for students, lecturers, and staff.

### Problem Statement
Currently, AUCA manages shared resources through a manual, paper-based logbook requiring a visit to the IT office. This manual process frequently results in:

- Confusion over equipment availability
- Wasted time and operational delays
- Double bookings and resource mismanagement
- Poor accountability for lost or damaged assets

---

## 2. Project Description & Objectives

LectroLend addresses these issues by automating the entire borrowing workflow. It utilizes a Java Swing graphical interface connected to a PostgreSQL database via JDBC.

### Key Objectives
- Digitize and automate the manual log sheet process.
- Provide real-time visibility into equipment availability and reservation status.
- Categorize and track equipment based on classroom types.
- Improve accountability and ensure timely returns through administrative oversight.

---

## 3. Target Users

The system supports three primary user roles:

| User Role       | Primary Function                                          |
|-----------------|-----------------------------------------------------------|
| Students        | Reserve equipment for assignments and group studies.      |
| Lecturers       | Book resources needed for teaching and meetings.          |
| IT/Admin Staff  | Manage inventory, approve bookings, and configure system. |

---

## 4. Core System Features

The application provides a comprehensive set of functionalities through its Swing interface:

- Secure role-based login
- Equipment catalog with full CRUD operations
- Reservation system to book, view, and cancel reservations
- Real-time tracking of equipment status
- Categorization of assets by room compatibility
- User feedback and confirmation dialogs via `JOptionPane`
- Data reporting through interactive tables (inventory, users, booking history)

---

## 5. System Architecture & Technology Stack

LectroLend uses the Model–View–DAO architecture for maintainability and scalability.

### Architecture Breakdown
- **View Layer (Java Swing):** Handles the graphical user interface and captures input.
- **Controller Layer (Java):** Manages business logic and communication between layers.
- **Model/DAO Layer (Java + JDBC):** Contains all database CRUD operations.

### Technology Stack

| Component         | Technology     | Rationale                                         |
|------------------|----------------|---------------------------------------------------|
| Programming       | Java           | Reliable, enterprise-grade language               |
| GUI Framework     | Java Swing     | Native desktop UI, cross-platform                 |
| DBMS              | PostgreSQL     | Stable, open-source relational database           |
| Database Access   | JDBC           | Standard Java API for connecting to databases     |
| IDE               | NetBeans 8.2   | Suitable for Swing and JDBC development           |

---

## 6. Non-Functional Requirements (NFRs)

| Requirement Category | Description                                                                 |
|----------------------|-----------------------------------------------------------------------------|
| Usability            | Clean UI/UX with clear instructions to minimize user errors.               |
| Reliability          | Accurate data with strong validation and error handling.                    |
| Performance          | CRUD operations and queries execute within acceptable time (under 2 sec).   |
| Security             | Role-based access control and secure authentication.                        |
| Maintainability      | Model–View–DAO pattern ensures easy debugging and future enhancements.      |
| Portability          | Runs on Windows/Linux using the standard Java Runtime Environment (JRE).    |

# ✅ LectroLend Validation Documentation

This documentation outlines the complete set of Technical and Business validation rules implemented for the core tables in the LectroLend Equipment Booking System, ensuring data integrity and correct application flow.

---

## 1.  Users Table Validation

| Rule Type | Field            | Rule Description                                               | Implementation Scope                                      |
|----------|------------------|---------------------------------------------------------------|-----------------------------------------------------------|
| Technical | username (PK)    | Uniqueness & Not Null: Username must be unique and cannot be null. | Database Constraint: `UNIQUE (username)`, `NOT NULL`      |
| Technical | phone_number     | Format Check: Must be 8–15 digits (numeric only).             | DB Check: `CHECK (phone_number ~ '^[0-9]{8,15}$')`        |
| Technical | role             | Allowed Values: staff, admin, student.                        | DB Check: `CHECK (role IN ('staff','admin','student'))`   |
| Business  | department       | Required Field: Cannot be blank.                              | Java Validation: `!department.trim().isEmpty()`           |

---

## 2.  Rooms Table Validation

| Rule Type | Field              | Rule Description                                        | Implementation Scope                           |
|-----------|--------------------|---------------------------------------------------------|------------------------------------------------|
| Technical | room_number (PK)   | Format Check: Must be alphanumeric (e.g., B204).        | Java Validation: pattern `[A-Za-z0-9]{2,}`     |
| Technical | capacity           | Range: Must be a positive integer.                      | Java Validation: `Integer.parseInt(capacity) > 0` |
| Technical | room_type          | Allowed Values: classroom, lab, office.                 | DB Check: `CHECK (room_type IN (...))`         |
| Business  | campus             | Selection Required: Cannot be default index.            | Java Validation: JComboBox index > 0           |
| Business  | has_screen         | Explicit Selection: Must be Yes/No.                     | Java Validation: `ButtonGroup.getSelection() != null` |


---

## 3.  Equipment Table Validation

| Rule Type | Field      | Rule Description                                           | Implementation Scope                      |
|-----------|------------|------------------------------------------------------------|-------------------------------------------|
| Technical | id (PK)    | Format Check: Must match internal ID pattern.              | Java Validation: `String.matches()`       |
| Technical | status     | Allowed Values: available, booked, damaged, maintenance.   | DB Check: `CHECK (status IN (...))`       |
| Business  | name       | Uniqueness: Equipment name must be unique.                 | DB Constraint: `UNIQUE (name)`            |
| Business  | campus     | Matching Check: Must match a valid campus name.            | Java Validation: checked against list      |


---

## 4.  Bookings Table Validation

| Rule Type | Field             | Rule Description                                                           | Implementation Scope                                                 |
|-----------|-------------------|---------------------------------------------------------------------------|----------------------------------------------------------------------|
| Technical | status            | Allowed Values: pending, approved, active, completed, cancelled.          | DB Check: `CHECK (status IN (...))`                                 |
| Technical | end_time          | Temporal Order: Must be later than start_time.                            | DB Check: `CHECK (end_time > start_time)`                            |
| Business  | start_time/end_time | Required: Valid HH:mm values must be provided.                           | Java Validation: `LocalTime.parse()` with try/catch                 |
| Business  | username (FK)     | Foreign Key Check: User must exist in Users table.                        | Java Validation: checked against `usersTable` before DAO call        |
| Business  | equipment         | Required: At least one equipment item must be selected.                   | Java Validation: checking selected list                              |
| Business  | room (FK)         | Equipment–Room Logic: Cannot book projector if room already has screen.   | Java Validation: filters equipment using room `has_screen`           |
| Business  | Time fields       | Conflict Prevention: Avoid overlapping bookings.                           | DAO SQL overlap check (implied)                                      |



