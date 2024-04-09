package Main;
import java.util.Scanner;

class Student {
    String name;
    int id;
    String[] courses = new String[10];
    int numCourses;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.numCourses = 0;
    }

    void addCourse(String course) {
        if (numCourses < 10) {
            courses[numCourses] = course;
            numCourses++;
        } else {
            System.out.println("This student cannot enroll in more courses.");
        }
    }

    void dropCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                for (int j = i; j < numCourses - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                numCourses--;
                return;
            }
        }
        System.out.println("This student is not enrolled in this course.");
    }

    void printCourses() {
        System.out.println("Courses enrolled by " + name + " (" + id + "):");
        for (int i = 0; i < numCourses; i++) {
            System.out.println(courses[i]);
        }
    }
}

class Faculty {
    Student[] students = new Student[100];
    int numStudents;

    void addStudent(Student student) {
        if (numStudents < 100) {
            students[numStudents] = student;
            numStudents++;
        } else {
            System.out.println("The faculty cannot have more students.");
        }
    }

    void printStudents() {
        System.out.println("Students in the faculty:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(students[i].name + " (" + students[i].id + ")");
        }
    }
}





public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Faculty faculty = new Faculty();

        while (true) {
            System.out.println("\n1. Add student\n2. Enroll student in course\n3. Drop student from course\n4. Print all students\n5. Print courses of a student\n6. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    faculty.addStudent(new Student(name, id));
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter course name: ");
                    scanner.nextLine();
                    String courseName = scanner.nextLine();
                    for (int i = 0; i < faculty.numStudents; i++) {
                        if (faculty.students[i].id == studentId) {
                            faculty.students[i].addCourse(courseName);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int studentIdDrop = scanner.nextInt();
                    System.out.print("Enter course name: ");
                    String courseNameDrop = scanner.next();
                    for (int i = 0; i < faculty.numStudents; i++) {
                        if (faculty.students[i].id == studentIdDrop) {
                            faculty.students[i].dropCourse(courseNameDrop);
                            break;
                        }
                    }
                    break;
                case 4:
                    faculty.printStudents();
                    break;
                case 5:
                    System.out.print("Enter student ID: ");
                    int studentIdPrint = scanner.nextInt();
                    for (int i = 0; i < faculty.numStudents; i++) {
                        if (faculty.students[i].id == studentIdPrint) {
                            faculty.students[i].printCourses();
                            break;
                        }
                    }
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}