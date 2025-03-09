/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mycompany.testjdbcconnect.JDBCConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class TestService {

    public static List<Object[]> testGetWithCondition() throws SQLException {
        List<Object[]> objs = new ArrayList<Object[]>();
        try (Connection connection = JDBCConnection.getConnection()) {
            CallableStatement csm = connection.prepareCall(" { call annotate_question_with_condition(?) } ");
            csm.setString(1, "");

            ResultSet rs = csm.executeQuery();

            while (rs.next()) {
                Object[] obj = new Object[]{rs.getString("id"), rs.getString("content"), rs.getInt("quantity")};
                
                objs.add(obj);
            }
        }
        
        return objs;
    }
}
