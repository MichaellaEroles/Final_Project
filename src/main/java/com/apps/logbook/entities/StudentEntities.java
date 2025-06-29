package com.apps.logbook.entities;

/**
 * Student entity class for representing records in the `students` table.
 */
public class StudentEntities {
    private int id;
    private String studentId;
    private String fname;
    private String mname;
    private String lname;
    private String program;

    
    public StudentEntities(String studentId, String firstName, String middleName, String lastName, String program) {
        this.studentId = studentId;
        this.fname = firstName;
        this.mname = middleName;
        this.lname = lastName;
        this.program = program;
    }

    
    public StudentEntities(int id, String studentId, String firstName, String middleName, String lastName, String program) {
        this.id = id;
        this.studentId = studentId;
        this.fname = firstName;
        this.mname = middleName;
        this.lname = lastName;
        this.program = program;
    }

  
    public int getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return fname;
    }

    public String getMiddleName() {
        return mname;
    }

    public String getLastName() {
        return lname;
    }

    public String getProgram() {
        return program;
    }

  
    public void setId(int id) {
        this.id = id;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.fname = firstName;
    }

    public void setMiddleName(String middleName) {
        this.mname = middleName;
    }

    public void setLastName(String lastName) {
        this.lname = lastName;
    }

    public void setProgram(String program) {
        this.program = program;
    }

  
    public boolean hasBlankFields() {
        return studentId == null || studentId.isBlank()
            || fname == null || fname.isBlank()
            || lname == null || lname.isBlank()
            || program == null || program.isBlank();
    }
}
