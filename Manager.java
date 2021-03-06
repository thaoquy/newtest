import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Manager {
    // Hàm hiển thị menu lựa chọn
    static void menu() {
        System.out.println("Menu:\n1.Nhập thông tin Students.\n2.Nhập exam marks cho các Student đó."
                + "\n3.Sắp xếp Students theo tên và hiển thị.\n4.Tìm thông tin exam marks bằng Id của Student và hiển thị."
                + "\n5.Hiển thị Student có điểm trung bình cao nhất.\n6.Xóa Student có điểm trung bình thấp nhất.\n7.Thoát");
    }

    // Hàm nhập thông tin sinh viên
    static ArrayList<Student> nhap(ArrayList<Student> listStudents) {
        System.out.print("Nhập số sinh viên cần nhập thông tin: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> listStudentId = new ArrayList<String>();
        for (Student s : listStudents) {
            listStudentId.add(s.getStuId());
        }
        for (int i = 1; i <= n; i++) {
            Student s = new Student();
            s.input();
            if (listStudentId.contains(s.getStuId())) {
                i--;
                System.out.println("Sinh viên danh đã tồn tại trong danh sách sinh viên, mời nhập lại");
            } else {
                listStudents.add(s);
                listStudentId.add(s.getStuId());
            }
        }
        return listStudents;
    }

    // Hàm nhập thông tin điểm thi
    static ArrayList<StudentMarkTotal> nhapDiem(ArrayList<Student> listStudents,
            ArrayList<StudentMarkTotal> listStudentMarkTotals) {
        ArrayList<String> listStudentId = new ArrayList<String>();
        for (Student s : listStudents) {
            listStudentId.add(s.getStuId());
        }
        System.out.print("Nhập số bản ghi cần nhập thông tin: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            StudentMarkTotal sm = new StudentMarkTotal();
            sm.input();
            if (!listStudentId.contains(sm.getStuId())) {
                i--;
                System.out.println("Sinh viên không có trong danh sách sinh viên, mời nhập lại");
            } else {
                listStudentMarkTotals.add(sm);
            }
        }
        return listStudentMarkTotals;
    }

    // Hàm sắp xếp sinh viên
    static void sapxep(ArrayList<Student> listStudents) {
        Collections.sort(listStudents, (o1, o2) -> o1.getStuName().compareTo(o2.getStuName()));
        System.out.println("Danh sách sinh viên theo thứ tự tên sinh viên là: "); 
        for(Student i:listStudents) {
            i.display();
        }
    }
    //Hàm hiển thị thông tin điểm sinh viên theo ID
    static void inforMarkbyId(ArrayList<StudentMarkTotal> listStudentMarkTotals) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập ID sinh viên muốn lấy thông tin:");
        String id = input.nextLine();
        for (StudentMarkTotal sm: listStudentMarkTotals) {
            if (sm.getStuId().equals(id)) {
                sm.display();
            }
        }
    }
    //Hiển thị sinh viên có điểm trung bình cao nhất
    static void maxStudent(ArrayList<Student> listStudents,ArrayList<StudentMarkTotal> listStudentMarkTotals) {
        ArrayList<String> listStudentIdMax = new ArrayList<String>();
        float maxMark = listStudentMarkTotals.get(0).calculateEverageMark(listStudentMarkTotals);
        for (StudentMarkTotal st: listStudentMarkTotals) {
            if(st.calculateEverageMark(listStudentMarkTotals) > maxMark) {
                maxMark = st.calculateEverageMark(listStudentMarkTotals);
            }
        }
        for (StudentMarkTotal st: listStudentMarkTotals) {
            if (st.calculateEverageMark(listStudentMarkTotals) == maxMark) {
                listStudentIdMax.add(st.getStuId());
            }
        }
        System.out.println("Sinh viên có điểm trung bình cao nhất là: ");
        for (Student i: listStudents) {
            if (listStudentIdMax.contains(i.getStuId())) {
                i.display();
            }
            
        }
    }
    //Hàm hiển thị danh sách sinh viên sau khi xóa sinh viên có điểm trung bình thấp nhất
    static ArrayList<Student> listStuAfterDel(ArrayList<Student> listStudents,ArrayList<StudentMarkTotal> listStudentMarkTotals) {
        ArrayList<String> listStudentIdMin = new ArrayList<String>();
        float minMark = listStudentMarkTotals.get(0).calculateEverageMark(listStudentMarkTotals);
        for (StudentMarkTotal st: listStudentMarkTotals) {
            if (st.calculateEverageMark(listStudentMarkTotals) < minMark) {
                minMark = st.calculateEverageMark(listStudentMarkTotals);
            }
        }
        for (StudentMarkTotal st: listStudentMarkTotals) {
            if (st.calculateEverageMark(listStudentMarkTotals) == minMark) {
                listStudentIdMin.add(st.getStuId());
            }
        }
        System.out.println("Danh sách sinh viên sau khi xóa sinh viên có điểm trung bình thấp nhất là: ");
        for (int i = 0; i < listStudents.size(); i++) {
            if (listStudentIdMin.contains(listStudents.get(i).getStuId())) {
                listStudents.remove(i);
                i--;                
            }
            else {
                listStudents.get(i).display();
            }
        }
        for (int i = 0; i < listStudentMarkTotals.size(); i++) {
            if (listStudentIdMin.contains(listStudentMarkTotals.get(i).getStuId())) {
                listStudentMarkTotals.remove(i);
                i--;                
            }
        }
        return listStudents;
    }
    public static void main(String[] args) {
        ArrayList<Student> listStudents= new ArrayList<Student>();
        ArrayList<StudentMarkTotal> listStudentMarkTotals = new ArrayList<StudentMarkTotal>();
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;

        do {
            menu();
            int chon = input.nextInt();
            switch (chon) {
            case 1:
                nhap(listStudents);
                break;
            case 2:
                nhapDiem(listStudents, listStudentMarkTotals);
                break;
            case 3:
                sapxep(listStudents);
                scanner.nextLine();
                break;
            case 4:
                inforMarkbyId(listStudentMarkTotals);
                scanner.nextLine();
                break;
            case 5:
                maxStudent(listStudents, listStudentMarkTotals);
                scanner.nextLine();
                break;
            case 6:
                listStudents = listStuAfterDel(listStudents, listStudentMarkTotals);
                scanner.nextLine();
                break;
            case 7:
                cont = false;
                break;
            default:
                System.out.println("Không có lựa chọn nào như vậy mời bạn chọn lại.");
                break;
            }
        } while (cont);
    }
}