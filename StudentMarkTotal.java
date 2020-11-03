import java.util.ArrayList;

class StudentMarkTotal extends StudentMark{
    private int totalExamSubject;
    private float everageMark;

    public int getTotalExamSubject(ArrayList<StudentMarkTotal> list) {
        this.totalExamSubject = 0;
        for (StudentMark i: list ) {
            if (i.getStuId().equals(this.getStuId())) {
                this.totalExamSubject +=1;
            }

        }
        return this.totalExamSubject;
    }
    //Tính điểm trung bình các môn thi
    public float calculateEverageMark(ArrayList<StudentMarkTotal> list) {
        int MarkTotal = 0;
        for (StudentMarkTotal i: list ) {
            if (i.getStuId().equals(this.getStuId())) {
                MarkTotal += i.getmark();
            }
            
        }
        if ((float)this.getTotalExamSubject(list)!=0) {
            this.everageMark = (float)MarkTotal/(float)this.getTotalExamSubject(list);
        }
        else {
            this.everageMark = 0;
        }
        return this.everageMark;
    } 
}