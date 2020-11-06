import java.util.Scanner;

class StudentMark implements IMark {
    private String StuId;
    private String className;
    private String subjectName;
    private int semester;
    private float mark;

    public void setStuId(String stuID) {
        this.StuId = stuID;
    }
    public void setclassName(String className) {
        this.className = className;
    }
    public void setsubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public void setsemester(int semester) {
        this.semester = semester;
    }
    public void setmark(Float mark) {
        this.mark = mark;
    }
    public String getStuId() {
        return this.StuId;
    }
    public String getclassName() {
        return this.className;
    }
    public String getsubjectName() {
        return this.subjectName;
    }
    public int getsemester() {
        return this.semester;
    }
    public float getmark() {
        return this.mark;
    }
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời nhập id, tên lớp, tên môn học, kỳ học, điểm của sinh viên: ");
        System.out.println("Nhập ID sinh viên: ");
        this.StuId = scanner.nextLine();
        System.out.println("Nhập tên lớp : ");
        this.className = scanner.nextLine();
        System.out.println("Nhập tên môn học: ");
        this.subjectName = scanner.nextLine();
        System.out.println("Nhập kì học: ");
        this.semester = scanner.nextInt();
        System.out.println("Nhập điểm: ");
        this.mark = scanner.nextFloat();
        scanner.close();

    }
    public void display() {
        System.out.println("Id: " + this.StuId);
        System.out.println("Lớp: " + this.className);
        System.out.println("Môn học: " + this.subjectName);
        System.out.println("Kì học: " + this.semester);
        System.out.println("Điểm: " + this.mark);

    }
    

}