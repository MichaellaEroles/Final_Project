/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apps.logbook.utilities;

/**
 *
 * @author Michaella Eroles
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentUtilities {

    /**
     * Checks if a student ID already exists in the database.
     *
     * @param conn       Active SQL connection
     * @param studentId  The student ID to check
     * @return           True if the student ID already exists, false otherwise
     * @throws SQLException
     */
    public static boolean studentIdExists(Connection conn, String studentId) throws SQLException {
        String query = "SELECT COUNT(*) FROM Student WHERE student_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, studentId);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }
}
