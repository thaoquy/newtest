import java.util.Scanner;
import java.io.PrintStream;

interface IMark {
    public void input();
    public void display();
}
class Student implements IMark {
    private static final PrintStream OUT = System.out;
    private String StuId;
    private String StuName;
    private String gender;
    private String birthday;

    public void setStuId(String stuID) {
        this.StuId = stuID;
    }
    public void setStuName(String stuName) {
        this.StuName = stuName;
    }
    public void setgender(String gender) {
        this.gender = gender;
    }
    public void setbirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getStuId() {
        return this.StuId;
    }
    public String getStuName() {
        return this.StuName;
    }
    public String getgender() {
        return this.gender;
    }
    public String getbirthday() {
        return this.birthday;
    }
    public void input() {
        Scanner scanner = new Scanner(System.in);
        OUT.println("Mời nhập id, tên, giới tính, ngày sinh của sinh viên: ");
        OUT.println("Nhập ID: ");
        this.StuId = scanner.nextLine();
        OUT.println("Nhập Tên: ");
        this.StuName = scanner.nextLine();
        OUT.println("Nhập giới tính: ");
        this.gender = scanner.nextLine();
        OUT.println("Nhập ngày sinh: ");
        this.birthday = scanner.nextLine();
        scanner.close();

    }
    public void display() {
        OUT.println("Id: " + this.StuId);
        OUT.println("Tên: " + this.StuName);
        OUT.println("Giới tính: " + this.gender);
        OUT.println("Ngày sinh: " + this.birthday);


    }

}