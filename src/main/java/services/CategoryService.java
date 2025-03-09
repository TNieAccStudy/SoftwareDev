package services;

import com.mycompany.testjdbcconnect.JDBCConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class CategoryService {
    
    public HashMap<String, Integer> annotateQuestionsByCategory(String cateKw) throws SQLException {
        HashMap<String, Integer> questionsAnnotation = new HashMap<String, Integer>();
        try (Connection connection = JDBCConnection.getConnection()) {
            CallableStatement csm = connection.prepareCall("{ call annotate_questions_by_category(?) }");
            csm.setString(1, cateKw);
            
            ResultSet rs = csm.executeQuery();
            
            while(rs.next()) {
                questionsAnnotation.put(rs.getString("category_name"),rs.getInt("questions_count"));
            }
        }
        
        return questionsAnnotation;
    }
}
