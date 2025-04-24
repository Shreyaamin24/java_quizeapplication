package dao;

import model.QuizAttempt;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizAttemptDAO {

    public static void saveAttempt(QuizAttempt attempt) {
        String sql = "INSERT INTO quiz_attempts (user_id, quiz_id, score, total_questions) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, attempt.getUserId());
            stmt.setInt(2, attempt.getQuizId());
            stmt.setInt(3, attempt.getScore());
            stmt.setInt(4, attempt.getTotalQuestions());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving attempt: " + e.getMessage());
        }
    }

    public static List<QuizAttempt> getAttemptsByUser(int userId) {
        List<QuizAttempt> list = new ArrayList<>();
        String sql = """
            SELECT qa.*, q.title 
            FROM quiz_attempts qa
            JOIN quizzes q ON qa.quiz_id = q.id
            WHERE qa.user_id = ?
            ORDER BY qa.attempt_timestamp DESC
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                QuizAttempt qa = new QuizAttempt();
                qa.setQuizId(rs.getInt("quiz_id"));
                qa.setScore(rs.getInt("score"));
                list.add(qa);
            }
        } catch (SQLException e) {
            System.out.println("");
        }

        return list;
    }
}
