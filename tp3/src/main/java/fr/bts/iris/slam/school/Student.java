package fr.bts.iris.slam.school;

import java.util.ArrayList;

public class Student {

    String id;
    String last_name;
    String first_name;
    int age;
    String email;
    ArrayList<Double> notes;

    // === CONSTRUCTOR ===
    public Student(String id, String last_name, String first_name, int age, String email) {
        // ID
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty");
        }
        if (id.length() != 6) {
            throw new IllegalArgumentException("Student ID must match pattern STU### (e.g., STU001)");
        }
        for (int i = 0; i < 2; i++) {
            if (id.startsWith("STU")) {
                if (!Character.isDigit(id.charAt(3)) && !Character.isDigit(id.charAt(4)) && !Character.isDigit(id.charAt(5))) {
                    throw new IllegalArgumentException("Student ID must match pattern STU### (e.g., STU001)");
                }
            } else {
                throw new IllegalArgumentException("Student ID must match pattern STU### (e.g., STU001)");
            }
        }
        // LAST NAME
        if (last_name == null || last_name.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (last_name.length() < 2) {
            throw new IllegalArgumentException("Last name must be at least 2 characters long");
        }
        // FIRST NAME
        if (first_name == null || first_name.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (first_name.length() < 2) {
            throw new IllegalArgumentException("Last name must be at least 2 characters long");
        }
        // AGE
        if (age < 16) {
            throw new IllegalArgumentException("Age must be between 16 and 65");
        }
        if (age > 65) {
            throw new IllegalArgumentException("Age must be between 16 and 65");
        }
        if (email.isEmpty() || email == null) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        // EMAIL
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email need to contain \"@\"");
        } else {
            char[] analyse = email.toCharArray();
            int address_sign_localisation = 0;
            for (int i = 0; i < analyse.length; i++) {
                if (Character.toString(analyse[i]).equals("@")) {
                    address_sign_localisation = i;
                }
            }
            if (address_sign_localisation == 0) {
                throw new IllegalStateException("The address sign is quantum");
            }
            boolean find_dot = false;
            for (int i = address_sign_localisation; i < analyse.length; i++) {
                if (Character.toString(analyse[i]).equals(".")) {
                    find_dot = true;
                }
            }
            if (!find_dot) {
                throw new IllegalArgumentException("Email need to contain at least one \".\" after \"@\"");
            }
        }
        // END OF CONSTRUCTOR
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.age = age;
        this.email = email;
        this.notes = new ArrayList<>();
    }

    // === GETTERS ==

    public String getId() {
        return this.id;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    public ArrayList<Double> getNotes() {
        return this.notes;
    }

    // === METHODES ===

    public void addStudent(Student student) {
        System.out.println("R");
    }

    public void addNote(double note) {
        this.notes.add(note);
    }
}
