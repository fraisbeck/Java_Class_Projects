package java112.project4;

import java.io.*;
import java.sql.*;

/**
 *
 *@author     fRaisbeck
 *
 */
public class JDBCPreparedStatement {


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

        JDBCPreparedStatement prepStatement = new JDBCPreparedStatement();

        prepStatement.runPrep(args);

    }

    public void runPrep(String[] arguments) {

        Connection connection = null;
        PreparedStatement prepStatement = null;
        ResultSet resultSet = null;

        try {
            //Register JDBC Driver
            Class.forName(JDBC_Driver);

            // Open a connection
            connection = DriverManager.getConnection(
                    DB_URL, userName, userPassword);

            // Create a prepared statement for the query
            prepStatement = connection.prepareStatement("INSERT INTO employees " +
                    "(first_name, last_name, ssn, dept, room, phone)" +
                    "VALUES (?, ?, ?, ?, ?, ?)");

            //Set arguments to variables
            prepStatement.setString(1, arguments[0]);
            prepStatement.setString(2, arguments[1]);
            prepStatement.setString(3, arguments[2]);
            prepStatement.setString(4, arguments[3]);
            prepStatement.setString(5, arguments[4]);
            prepStatement.setString(6, arguments[5]);

            prepStatement.executeUpdate();

            Statement statement = connection.createStatement();

            String resultQueryString = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone"
                    + " FROM employees WHERE ssn like '" + arguments[2] + "%'";

            resultSet = statement.executeQuery(resultQueryString);

            System.out.println("resultQueryString: " + resultQueryString);

            System.out.println();

            while (resultSet.next()) {
                String resultedEmployeeId = resultSet.getString("emp_id");
                String resultedFirstName = resultSet.getString("first_name");
                String resultedLastName = resultSet.getString("last_name");
                String resultedSocialSecurityNumber = resultSet.getString("ssn");
                String resultedDepartment = resultSet.getString("dept");
                String resultedRoomNumber = resultSet.getString("room");
                String resultedPhoneNumber = resultSet.getString("phone");
                System.out.println(" Row: " + resultedEmployeeId + " "
                            + resultedFirstName + " " + resultedLastName + " " + resultedSocialSecurityNumber
                            + " " + resultedDepartment + " " + resultedRoomNumber + " " + resultedPhoneNumber);
            }

            System.out.println();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            String nameOne = resultSetMetaData.getColumnName(1);
            String typeOne = resultSetMetaData.getColumnTypeName(1);
            String labelOne = resultSetMetaData.getColumnLabel(1);
            System.out.println(" Column count : " + columns);
            System.out.println(" Column 1 name : " + nameOne);
            System.out.println(" Column 1 type : " + typeOne);
            System.out.println(" Column 1 label name : " + labelOne);

            System.out.println();

        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {

                if (prepStatement != null) {
                    prepStatement.close();
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
