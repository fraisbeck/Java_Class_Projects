package java112.project4;

import java.io.*;
import java.sql.*;

/**
 *
 *@author     fRaisbeck
 *
 */
public class JDBCInsertEmployee {


    //Declare local variables
    private String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    private String DB_URL = "jdbc:mysql://localhost/student";
    private String userName = "student";
    private String userPassword = "student";

    /**
     * The main program for the JDBCInsertEmployees class
     * @param  args  The command line arguments
     */
    public static void main(String[] args) {

        JDBCInsertEmployee employees = new JDBCInsertEmployee();

        employees.runInsert(args);

    }

    public void runInsert(String[] arguments) {

        Connection connection = null;
        Statement statement = null;

        try {
            //Register JDBC Driver
            Class.forName(JDBC_Driver);

            // Open a connection
            connection = DriverManager.getConnection(
                    DB_URL, userName, userPassword);

            // Execute a query
            statement = connection.createStatement();

            //Set arguments to variables
            String firstName = arguments[0];
            String lastName = arguments[1];
            String ssn = arguments[2];
            String dept = arguments[3];
            String room = arguments[4];
            String phone = arguments[5];

            // Create the query string
            String queryString = "INSERT INTO employees (first_name, last_name, ssn, dept, room, phone)" +
                    "VALUES ('" + firstName + "', '" + lastName + "', '" +
                    ssn + "', '" + dept +"', '" + room + "', '" + phone + "')";

            System.out.println("queryString: " + queryString);

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
}
