import java.io.*;
import java.util.ArrayList;

/**
 * 期末考试最后一题参考答案
 * 时间：2022年11月28日16点
 * 作者：周
 */
class Student implements Comparable<Student> {
    //    id,name,profession,class,grade
    private int id;
    private String name;
    private String profession;
    private String _class;
    private int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student && ((Student) obj).id == this.id) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + profession + "," + _class + "," + grade;
    }

    //    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", profession='" + profession + '\'' +
//                ", _class='" + _class + '\'' +
//                ", grade='" + grade + '\'' +
//                '}';
//    }

    @Override
    public int compareTo(Student student2) {
        return student2.grade - this.grade;
    }
}

class MArrayList extends ArrayList<Student> {

    /**
     * 集合打印
     */
    public void print() {
        for (Student student : this) {
            System.out.println(student);
        }
    }

    /**
     * 希尔排序
     */
    public void shellSort() {
        int length = this.size();
        Student temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = this.get(i);
                int j = i - step;
                while (j >= 0 && this.get(j).getGrade() </*<表示从大到小排序*/ temp.getGrade()) {
                    this.set(j + step, this.get(j));
//                    students.get(j + step) =  students.get(j);
                    j -= step;
                }
//                students.get(j + step) = temp;
                this.set(j + step, temp);
            }
        }

    }
}

public class StudentsInfo {
/*

    */
/**
     * 打印数组
     *
     * @param students
     *//*

    public static void printArray(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    */
/**
     * 希尔排序
     *//*

    public static void shellSort(ArrayList<Student> students) {
        int length = students.size();
        Student temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = students.get(i);
                int j = i - step;
                while (j >= 0 && students.get(j).getGrade() <*/
/*<表示从大到小排序*//*
 temp.getGrade()) {
                    students.set(j + step, students.get(j));
//                    students.get(j + step) =  students.get(j);
                    j -= step;
                }
//                students.get(j + step) = temp;
                students.set(j + step, temp);
            }
        }

    }
*/

    public static void main(String[] args) throws IOException {

        MArrayList students = new MArrayList();

        System.out.println(System.getProperty("user.dir"));
        ;
        File file = new File("src/data.csv");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] strings = line.split(",");
            int id = Integer.parseInt(strings[0]);
            String name = strings[1];
            String profession = strings[2];
            String _class = strings[3];
            int grade = Integer.parseInt(strings[4]);
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setProfession(profession);
            student.set_class(_class);
            student.setGrade(grade);

            if (grade >= 90)
                students.add(student);
//            System.out.println(student);
        }
//        Collections.sort(students); // Java自带的集合排序，使用比较器自动排序
        // 面向过程
//        shellSort(students); // 希尔排序
//        printArray(students);

        // TODO oop
        students.shellSort();
        students.print();
    }
}
