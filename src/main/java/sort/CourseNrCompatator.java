package sort;

import data.Student;

public class CourseNrCompatator implements Comparator<Student>{

    @Override
    public int compare(Student var1, Student var2) {
        return var1.getCourse() - var2.getCourse();
    }

    @Override
    public String getName() {
        return "CourseComparator";
    }
}
