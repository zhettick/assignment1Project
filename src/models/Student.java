package models;

import java.util.List;

public class Student extends Person {
    private int id;
    private List<Integer> gradesList;
    private static int id_gen = 1;

    private void generateID() {
        id = id_gen++;
    }


    public Student(String name, String surname, int age, boolean gender, List<Integer> gradesList) {
        super(name, surname, age, gender);
        generateID();
        this.id = id;
        this.gradesList = gradesList;
    }

    public void addGrade(int grade) {
        gradesList.add(grade);
    }

    public double calculateGPA() {
        double gpa = 0;

        for (int i = 0; i < gradesList.size(); i++) {
            int grade = gradesList.get(i);
            gpa += grade;
        }
        return gpa / gradesList.size();
    }

    @Override
    public String toString() {
        return super.toString() + "I am a student with ID " + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getGrades() {
        return gradesList;
    }

    public void setGrades(List<Integer> grades) {
        this.gradesList = grades;
    }
}
