import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Tô Việt Anh", "Thái Bình"));
        students.add(new Student(2,"Nguyễn Thị Ánh", "Thái Bình"));
        students.add(new Student(3,"Nguyễn Văn Thành", "Bắc Giang"));
        students.add(new Student(4,"Trần Thái Dương", "Hà Nội"));
        students.add(new Student(5,"Vũ Kiều Anh", "Hà Nam"));
        writeToFile("student.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("student.txt");
        for (Student student: studentDataFromFile) {
            System.out.println(student);
        }
    }

    public static void writeToFile(String path, List<Student> students){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>)  ois.readObject();
            ois.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

}
