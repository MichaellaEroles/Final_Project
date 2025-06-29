/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apps.logbook.controllers;

import com.apps.logbook.config.DbConnector;
import com.apps.logbook.entities.StudentEntities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Michaella Eroles
 */
public class StudentController {
    
 private final DbConnector dbConnector;

    public StudentController() {
        dbConnector = new DbConnector();
    
}
    
  // CREATE
    public boolean addStudent(StudentEntities student) throws SQLException {
        String sql = "INSERT INTO students (student_id, first_name, middle_name, last_name, program) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dbConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getStudentId());
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getMiddleName());
            stmt.setString(4, student.getLastName());
            stmt.setString(5, student.getProgram());

            return stmt.executeUpdate() > 0;
        }
    }

    // READ
    public List<StudentEntities> getAllStudents() throws SQLException {
        List<StudentEntities> students = new ArrayList<>();
        String sql = "SELECT id, student_id, first_name, middle_name, last_name, program FROM students";

        try (Connection conn = dbConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                students.add(new StudentEntities(
                    rs.getInt("id"),
                    rs.getString("student_id"),
                    rs.getString("first_name"),
                    rs.getString("middle_name"),
                    rs.getString("last_name"),
                    rs.getString("program")
                ));
            }
        }
        return students;
    }


    // UPDATE
    public boolean updateStudent(StudentEntities student) throws SQLException {
       String sql = "UPDATE students SET student_id=?, first_name=?, middle_name=?, last_name=?, program=? WHERE id=?";

        try (Connection conn = dbConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getStudentId());
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getMiddleName());
            stmt.setString(4, student.getLastName());
            stmt.setString(5, student.getProgram());
            stmt.setInt(6, student.getId());

            return stmt.executeUpdate() > 0;
        }
    }


    // DELETE
    public boolean deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id=?";

        try (Connection conn = dbConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}