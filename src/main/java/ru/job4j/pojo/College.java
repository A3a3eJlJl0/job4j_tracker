package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("John Newman");
        student.setGroup("preparatory");
        student.setAdmissionDate("02.03.19");

        System.out.println(
            "Student " + student.getFullName() +
            " of the " + student.getGroup() +" group" +
            " enrolled on " + student.getAdmissionDate()
        );
    }
}
