package fr.bts.iris.slam.school;

import java.util.ArrayList;

public class Student {

    // === ATTRIBUTES ===

    protected String id;
    protected String last_name;
    protected String first_name;
    protected int age;
    protected String email;
    protected ArrayList<Double> grades;

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
        if (age < 16 || age > 65) {
            throw new IllegalArgumentException("Age must be between 16 and 65");
        }
        // EMAIL
        if (email.isEmpty() || email == null) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
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
        this.grades = new ArrayList<>();
    }

    // === ATTRIBUTES GETTERS ==

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

    public ArrayList<Double> getGrades() {
        return new ArrayList<>(this.grades);
        // return List.copyOf(this.grades);
        // return this.grades.stream().toList();
    }

    // === METHODS ===

    public void addStudent(Student student) {
        System.out.println("R");
    }

    public void addGrade(double grade) {
        if (grade < 0 || grade > 20) {
            throw new IllegalArgumentException("Grade must be between 0 and 20");
        }
        this.grades.add(grade);
    }

    public double getAverage() {
        if (this.grades.isEmpty()) {
            throw new IllegalStateException("Cannot calculate average: no grades available");
        }
        double average = 0;
        for (int i = 0; i < this.grades.size(); i++) {
            average = average + this.grades.get(i);
        }
        return average / this.grades.size();
    }

    public boolean hasPassingGrade() {
        if (!this.grades.isEmpty() && this.getAverage() >= 10) {
            return true;
        } else {
            return false;
        }
    }

    // === METHODS GETTERS ==

    public String getFullName() {
        return (this.last_name + " " + this.first_name);
    }

    public int getGradeCount() {
        return (this.grades.size());
    }

    public double getBestGrade() {
        if (this.grades.isEmpty()) {
            return 0.0;
        } else {
            double best_grade = 0;
            for (int i = 0; i < this.grades.size(); i++) {
                if (this.grades.get(i) > best_grade) {
                    best_grade = this.grades.get(i);
                }
            }
            return best_grade;
        }
    }

    public double getWorstGrade() {
        if (this.grades.isEmpty()) {
            return 0.0;
        } else {
            double worst_grade = 20;
            for (int i = 0; i < this.grades.size(); i++) {
                if (this.grades.get(i) < worst_grade) {
                    worst_grade = this.grades.get(i);
                }
            }
            return worst_grade;
        }
    }

}
