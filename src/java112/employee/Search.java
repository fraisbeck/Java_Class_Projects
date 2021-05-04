package java112.employee;

import java.io.*;
import java.util.*;

/**
 *  This is a JavaBean class to search the employee database
 *  @author fRaisbeck
 */
public class Search {

    /**The catagory the search is using */
    private String searchType;

    /**The keyword the search is looking for in the database */
    private String searchTerm;

    /**A list of Employee objects the search results have found */
    private ArrayList<Employee> results;

    /**A boolean to tell if the search found anything in the database */
    private boolean employeeFound;

    /**
     * Constructor for the Search class
     */
    public Search() {
        results = new ArrayList<Employee>();
    }

    /**
     * [getSearchType description]
     * @return [description]
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * [setSearchType description]
     * @param searchType [description]
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     * [getSearchTerm description]
     * @return [description]
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * [setSearchTerm description]
     * @param searchTerm [description]
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     * [getResults description]
     * @return [description]
     */
    public ArrayList<Employee> getResults() {
        return results;
    }

    /**
     * [setResults description]
     * @param  results [description]
     * @return         [description]
     */
    public void setResults(ArrayList<Employee> results) {
        this.results = results;
    }

    /**
     * [getEmployeeFound description]
     * @return [description]
     */
    public boolean getEmployeeFound() {
        return employeeFound;
    }

    /**
     * [setEmployeeFound description]
     * @param employeeFound [description]
     */
    public void setEmployeeFound (boolean employeeFound) {
        this.employeeFound = employeeFound;
    }

    /**
     * Adds the employee object to the list of found Employee objects
     * @param employee the employee found
     */
    public void addFoundEmployee(Employee employee) {
        results.add(employee);
    }

    /**
     * Used to test print results to the web page
     */
    public void testPrint() {
        for (Employee emp : results) {
            emp.toString();
        }
    }
}
