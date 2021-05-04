package java112.employee;

import java.io.*;
import java.util.*;

/**
 * This is an object that holds all the information of an employee from
 * the Employee database
 * @author fRaisbeck
 */

public class Employee {

    /** The employee's ID number */
    private String employeeID;

    /** The employee's first name */
    private String firstName;

    /** The employee's last name */
    private String lastName;

    /** The employee's social security number */
    private String socialSecurityNumber;

    /** The employee's working department */
    private String department;

    /** The employee's room number */
    private String roomNumber;

    /** The employee's phone number */
    private String phoneNumber;

    /**
     * Creates an Employee
     */
    public Employee() {

    }

    /**
     * [Employee description]
     * @param employeeID           The employee's ID number
     * @param firstName            The employee's first name
     * @param lastName             The employee's last name
     * @param socialSecurityNumber The employee's social security number
     * @param department           The employee's working department
     * @param roomNumber           The employee's room number
     * @param phoneNumber          The employee's phone number
     */
    public Employee(String employeeID, String firstName, String lastName,
            String socialSecurityNumber, String department, String roomNumber,
            String phoneNumber) {
        this();
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.department = department;
        this.roomNumber = roomNumber;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the employees ID number
     * @return the employees ID number
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * Sets the employees ID number
     * @param employeeID The employees ID number
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Gets the employees first name
     * @return the employees first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the employees first name
     * @param firstName the employees first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the employees last name
     * @return the employees last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the employees last name
     * @param lastName the emplyees last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the emplyees social security number
     * @return the employees social security number
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * Sets the emplyees social security number
     * @param socialSecurityNumber the employees social security number
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Gets the employees working department
     * @return the employees department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the employees working department
     * @param department the employees department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the employees room number
     * @return the employees room number
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the employees room number
     * @param roomNumber the employees room number
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Gets the employees phone number
     * @return the employees phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the employees phone number
     * @param phoneNumber the employees phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the employees information
     * @return the employees data information including ID number, first name, last name
     *          social security number, department, room number, and phone number
     */
    public String toString() {
        return "Employee{" +
        "employeeID='" + employeeID + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
        ", department='" + department + '\'' +
        ", roomNumber='" + roomNumber + '\'' +
        ", phoneNumber='" + phoneNumber +
        "}";
    }
}
