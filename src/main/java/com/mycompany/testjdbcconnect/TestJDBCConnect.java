/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.testjdbcconnect;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Choice;
import pojo.Question;
import services.CategoryService;
import services.QuestionService;
import services.TestService;

/**
 *
 * @author admin
 */
public class TestJDBCConnect {

    public static void main(String[] args) throws SQLException {
        Scanner sn = new Scanner(System.in);
//        
//        QuestionService qService = new QuestionService();
//        List<Question> questions = qService.getQuestions(3);
//
//        questions.forEach((q) -> {
//            System.out.println(q);
//            try {
//                List<Choice> choices = qService.getChoices(q.getId());
//                for (int i = 0; i < choices.size(); i++) {
//                    System.out.printf("%d - %s\n", i + 1, choices.get(i));
//                }
//                
//                int choice = sn.nextByte();
//                if (choices.get(choice-1).isCorrect()) {
//                    System.out.println("PASS");
//                } else {
//                    System.out.println("FAIL");
//                }
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(TestJDBCConnect.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        });


//        CategoryService cService = new CategoryService();
//        
//        String kw = "";
//        HashMap<String, Integer> annotate = cService.annotateQuestionsByCategory(kw);
//        
//        annotate.forEach((k, v) -> {
//            System.out.printf("%s - %d\n", k,v);
//        });
        
        List<Object[]> objs = TestService.testGetWithCondition();
        
        objs.forEach((obj) -> {
            System.out.printf("%s - %s: %d", obj[0], obj[1], obj[2]);
        });
    }
}
