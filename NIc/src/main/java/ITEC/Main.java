package ITEC;

import ITEC.ItecCourse;

public class Main {
    public static void main(String[] args) {
        ItecCourse cisco= new ItecCourse("cisco admin",2654,4);

        cisco.addStudent("joe");
        cisco.addStudent("mike");
        cisco.addStudent("sean");
        cisco.addStudent("ella");
        cisco.RemoveStudent("ella");

        System.out.println(cisco.getName("joe"));
        System.out.println(cisco.getNumberOfStudents());
        System.out.println(cisco.getCode());
        System.out.println(cisco.getNumberOfStudents());

        ItecCourse maintenance = new ItecCourse("micocomputer system maintenence",1310,2);

        maintenance.addStudent("anna");
        maintenance.addStudent("joe");
        maintenance.addStudent("tom");

        System.out.println(maintenance.getCode());
        System.out.println(maintenance.getMaxstudents());
        System.out.println(maintenance.getName("jose"));
        System.out.println(maintenance.getNumberOfStudents());

        maintenance.writeCourse();
        cisco.writeCourse();





    }
}
