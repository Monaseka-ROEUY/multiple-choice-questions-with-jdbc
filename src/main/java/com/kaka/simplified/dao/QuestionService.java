package com.kaka.simplified.dao;

import com.kaka.simplified.model.Question;
import com.kaka.simplified.utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {
    public List<Question> getQuestions(int questionSize) {
        if (questionSize <= 0) {
            throw new IllegalArgumentException("Question size must be greater than 0");
        }
        List<Question> questions = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM questions ORDER BY RANDOM() LIMIT ?");
            ps.setInt(1, questionSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                questions.add(new Question(rs.getInt("id"), rs.getString("title")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }

    public int getNumberOfRecords() {
        int total = 0;
        try (Connection con = DatabaseConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM questions");

            while (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }

    public void displayQuestion(Question question) {
        System.out.println("#" + question.getId() + ". " + question.getTitle());
    }
}
