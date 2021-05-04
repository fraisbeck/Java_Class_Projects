package java112.employee;

import java.io.*;
import java.sql.*;
import java.util.*;
import java112.utilities.*;

/**
 * @author fRaisbeck
 */

public class EmployeeDirectory {


    private Properties properties;

    /**
     * Empty Constructor for the EmployeeDirectory class
     */
    public EmployeeDirectory() {

    }

    /**
     * Constructor for the EmployeeDirectory class
     * @param property the properties file to use
     */
    public EmployeeDirectory(Properties property) {
        this();
        this.properties = property;
    }

    /**
     * Establishes a connection to the database and return the connection to
     * the calling method.
     */
    private Connection establishConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(properties.getProperty("url"),
            properties.getProperty("username"), properties.getProperty("password"));

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return connection;
    }

    /**
     * Adds a new record to the Employee table in the database
     */
    public void addNewRecord(String[] arguments) {

        Connection connection = null;
        Statement statement = null;

        try {
            // Register JDBC Driver
             Class.forName(properties.getProperty("driver"));

             // Establishes a connection
             connection = establishConnection();

             // Enables you to execute a query
             statement = connection.createStatement();

             //Set arguments to variables
             String firstName = arguments[0];
             String lastName = arguments[1];
             String ssn = arguments[2];
             String dept = arguments[3];
             String room = arguments[4];
             String phone = arguments[5];

             // Create the an sql insert statement
             String queryString = "INSERT INTO employees (first_name, last_name, "
                    + "ssn, dept, room, phone) "
                    + "VALUES ('" + firstName + "', '" + lastName + "', '" +
                     ssn + "', '" + dept +"', '" + room + "', '" + phone + "')";

            // Execute the query
            statement.executeUpdate(queryString);

        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {

            // Close the connection
            try {

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Searches through the Employee database and returns the Search object once
     * it's found
     * @param  searchTerm [description]
     * @param  searchType [description]
     * @return            the search object found
     */
    public Search searchEmployeeDatabase(String searchTerm, String searchType) {

        Search newSearch = new Search();
        newSearch.setSearchTerm(searchTerm);
        newSearch.setSearchType(searchType);
        searchByTerm(newSearch);
        return newSearch;
    }

    /**
     * Uses a search object to locate an Employee in the employee database
     * using the search Term found from a web page
     * @param searchObject the search object used to search the database
     */
    private void searchByTerm (Search searchObject) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Register JDBC Driver
             Class.forName(properties.getProperty("driver"));

            // Establishes a connection
            connection = establishConnection();

            // Enables you to execute a query
            statement = connection.createStatement();

            String type = searchObject.getSearchType();
            String term = searchObject.getSearchTerm();

            // Generate an SQL select statement using the employee ID from the search object
            String resultQueryString = "SELECT * "
                    + "FROM employees WHERE " + type
                    + " like '" + term + "%'";

            // Execute the query
            resultSet = statement.executeQuery(resultQueryString);

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            //If the query returns any rows then set the boolean in the searchObject
            //to True, if not set it to false
            if (columns > 0) {
                searchObject.setEmployeeFound(true);

                //If the query returns rows then instantiate the new Employee object
                //for each row and set it's instance variables from the row from the database.
                //Each new Employee object will be added to the Search object with the
                //addFoundEmployee() method
                while (resultSet.next()) {
                    Employee employee = new Employee(resultSet.getString("emp_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("lastn_name"),
                            resultSet.getString("ssn"),
                            resultSet.getString("dept"),
                            resultSet.getString("room"),
                            resultSet.getString("phone"));
                    searchObject.addFoundEmployee(employee);
                }
            } else {
                searchObject.setEmployeeFound(false);
            }

        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {

            // Close the connection
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
