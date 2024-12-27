import models.Student;
import models.School;
import models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();

        File sfile = new File("/Users/dianasabulla/IdeaProjects/assignment1Project/src/students.txt");
        Scanner sc = new Scanner(sfile);

        while (sc.hasNext()) {

            String name = sc.next();
            String surname = sc.next();
            int age = sc.nextInt();
            boolean gender = sc.next().equals("Male");

            List<Integer> gradesList = new ArrayList<>();
            while (sc.hasNextInt()) {
                int grade = sc.nextInt();
                gradesList.add(grade);
            }

            Student student = new Student(name, surname, age, gender, gradesList);

            school.addMember(student);

            double gpa = student.calculateGPA();

            System.out.println(student);
            System.out.println("GPA: " + gpa);
        }
        sc.close();

        File tfile = new File("/Users/dianasabulla/IdeaProjects/assignment1Project/src/teachers.txt");
        Scanner tsc = new Scanner(tfile);

        while (tsc.hasNext()) {

            String name = tsc.next();
            String surname = tsc.next();
            int age = tsc.nextInt();
            boolean gender = tsc.next().equals("Male");
            String subject = tsc.next();
            int yearsOfExperience = tsc.nextInt();
            int salary = tsc.nextInt();

            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);

            school.addMember(teacher);

            System.out.println(teacher);

            if (yearsOfExperience > 10) {
                double raise = teacher.giveRaise(10);
                System.out.println("Raise: " + raise);
            }
        }
    }
}