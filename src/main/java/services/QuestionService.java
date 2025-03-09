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
import pojo.Choice;
import pojo.Question;

/**
 *
 * @author admin
 */
public class QuestionService {
    
    public List<Question> getQuestions(int number) throws SQLException {
        List<Question> questions = new ArrayList<Question>();
        try (Connection connection = JDBCConnection.getConnection()) {
            CallableStatement csm = connection.prepareCall("{ call get_questions(?) }");
            csm.setInt(1, number);
            
            ResultSet result = csm.executeQuery();
            
            while (result.next()) {
                Question q = new Question(result.getString("id"), result.getString("content"), result.getInt("category_id"));
                questions.add(q);
            }
        }
        
        return questions;
    }
    
    public List<Choice> getChoices(String questionId) throws SQLException {
        List<Choice> choices = new ArrayList<Choice>();
        try (Connection connection = JDBCConnection.getConnection()) {
            CallableStatement csm = connection.prepareCall("{ call get_choices(?) }");
            csm.setString(1, questionId);
            
            ResultSet rs = csm.executeQuery();
            
            while(rs.next()) {
                Choice c = new Choice(rs.getString("id"), rs.getString("content"), rs.getBoolean("is_correct"), rs.getString("question_id"));
                choices.add(c);
            }
        }
        
        return choices;
    }
}
