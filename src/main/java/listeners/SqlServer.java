package listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.Test;

import java.sql.*;

public class SqlServer implements ITestListener {

@Test
    public void sendinfo(ITestContext ITC)
    {
    System.out.println(ITC.getName());
    System.out.println(ITC.getClass().getName());
    System.out.println(System.getProperty("OS"));
        System.out.println(ITC.getPassedTests().getAllMethods());
    }

    /*    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1800/Auto_Infra", "SA", "Auto_Infra");
        Statement sqlStatement = con.createStatement();
        String sqlQuery = "SELECT * FROM Auto_Infra_Main";
        try {
            ResultSet resSet = sqlStatement.executeQuery(sqlQuery);
            while (resSet.next()) {
                System.out.println(resSet.getString("PK"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        con.close();
    2}*/
}