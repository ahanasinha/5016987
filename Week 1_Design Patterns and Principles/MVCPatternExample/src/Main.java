public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Lokesh Sharma");
        student.setId(1);
        student.setGrade('A');

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("John Doe");
        controller.setStudentId(2);
        controller.setStudentGrade('B');

        controller.updateView();
    }
}