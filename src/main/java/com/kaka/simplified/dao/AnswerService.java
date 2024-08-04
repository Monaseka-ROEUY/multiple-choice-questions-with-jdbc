package com.kaka.simplified.dao;

import com.kaka.simplified.model.Answer;
import com.kaka.simplified.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerService {
    public List<Answer> getAllAnswersByQuestionId(int questionId) {
        List<Answer> answers = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM answers WHERE question_id = ?");
            ps.setInt(1, questionId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                answers.add(new Answer(rs.getInt("id"), rs.getString("answer_text"),
                        rs.getBoolean("is_correct"), rs.getInt("question_id")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return answers;
    }

    public String getCorrectAnswerText(List<Answer> answers) {
        return answers.stream()
                .filter(Answer::isCorrect)
                .findFirst()
                .get()
                .getAnswerText();
    }

    public String getAnswerFromUser(List<Answer> answers, int userOptionNumber) {
        if (userOptionNumber > answers.size()) {
            throw new RuntimeException("You cannot choose option bigger than " + answers.size());
        }
        return answers.get(userOptionNumber - 1).getAnswerText();
    }


    public void displayAllAnswer(List<Answer> answers) {
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(i + 1 + ". " + answers.get(i).getAnswerText());
        }
    }

    public boolean isCorrect(String userAnswerText, String correctAnswerText) {
        return userAnswerText.equalsIgnoreCase(correctAnswerText);
    }
}
