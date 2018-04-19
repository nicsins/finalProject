import java.util.ArrayList;

public class ItecCourse {
    private String name;
    private int code;
    private ArrayList<String > students=new ArrayList<String>();
    private int maxstudents;

    void setName(String newName){
        name=newName;
    }
    String getName(String newName){
        return name;
    }

    ItecCourse(String name,int code,int maxstudents) {
        this.name=name;
        this.code=code;
        this.maxstudents=maxstudents;
    }
    void addStudent(String studentName) {
        if (students == null) {
            students = new ArrayList<String>();

        }
        else if(students.size()<maxstudents){
            students.add(studentName);}
        else  {
            System.out.println("class is full");
        }

    }


    void writeCourse(){
        System.out.println("Course name:"+name);
        System.out.println("Course code:"+code);
        System.out.println("Students enrolled:");
        for(String student: students) {
            System.out.print(student+',');
            System.out.println();

        }
        System.out.println(students.toString());
        System.out.println("There are "+getNumberOfStudents()+"students");
        System.out.println("the maximum number of students for this course are"+maxstudents);

        }

        int getNumberOfStudents(){
        return this.students.size();
        }
       void RemoveStudent(String studentName){
        students.remove(studentName);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMaxstudents() {
        return maxstudents;
    }

    public void setMaxstudents(int maxstudents) {
        this.maxstudents = maxstudents;
    }
}

