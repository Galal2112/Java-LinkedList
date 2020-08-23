package sort;

import data.Student;

public class MatrNrComparator implements Comparator<Student>{


    @Override
    public int compare(Student var1, Student var2) {
         return var1.getMatriculationNumber() - var2.getMatriculationNumber();
    }

    @Override
    public String getName() {
        return "MatriculationNumberComparator";
    }
}
