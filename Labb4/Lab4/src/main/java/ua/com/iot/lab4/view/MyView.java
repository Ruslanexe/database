package ua.com.iot.lab4.view;

import org.springframework.stereotype.Component;
import ua.com.iot.lab4.controller.*;
import ua.com.iot.lab4.domain.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;
@Component
public class MyView {
    private final IFeedbackController feedbackController;
    private final IGroupController groupController;
    private final ILecturerController lecturerController;
    private final ILectureController lectureController;
    private final IProgramController programController;
    private final IStudentController studentController;
    private final ISubjectController subjectController;

    private final Map<String, String> menu;
    private final Map<String, IPrintable> methodsMenu;
    private final Scanner input = new Scanner(System.in);
    private final Feedback nullFeedback = new Feedback(null, null, null, null, null);
    private final Group nullGroup = new Group(null, null, null);
    private final Lecturer nullLecturer = new Lecturer(null, null, null);
    private final Program nullProgram = new Program(null, null, null);
    private final Lecture nullLecture = new Lecture(null, null, null, null, null, null);
    private final Student nullStudent = new Student(null, null, null, null);
    private final Subject nullSubject = new Subject(null, null, null, null);


    public MyView(IFeedbackController feedbackController, IGroupController groupController,
                  ILecturerController lecturerController, ILectureController lectureController,
                  IProgramController programController,IStudentController studentController,
                    ISubjectController subjectController ) {

        this.feedbackController = feedbackController;
        this.groupController = groupController;
        this.lecturerController = lecturerController;
        this.lectureController = lectureController;
        this.programController = programController;
        this.studentController = studentController;
        this.subjectController = subjectController;

        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: feedback");
        menu.put("11", "  11 - Create feedback");
        menu.put("12", "  12 - Delete feedback");
        menu.put("13", "  13 - Get all feedbacks");
        menu.put("14", "  14 - Get feedback  by ID");

        menu.put("2", "   2 - Table: group");
        menu.put("21", "  21 - Create group");
        menu.put("22", "  22 - Update group");
        menu.put("23", "  23 - Delete group");
        menu.put("24", "  24 - Get all groups");
        menu.put("25", "  25 - Get group by ID");

        menu.put("3", "   3 - Table: lecture");
        menu.put("31", "  31 - Create lecture");
        menu.put("32", "  32 - Update lecture");
        menu.put("33", "  33 - Delete lecture");
        menu.put("34", "  34 - Get all lectures");
        menu.put("35", "  35 - Get lecture by ID");

        menu.put("4", "   4 - Table: lecturer");
        menu.put("41", "  41 - Create lecturer");
        menu.put("42", "  42 - Delete lecturer");
        menu.put("43", "  43 - Get all lecturers");
        menu.put("44", "  44 - Get lecturer by ID");

        menu.put("5", "   5 - Table: program");
        menu.put("51", "  51 - Create  program");
        menu.put("52", "  52 - Delete  program");
        menu.put("53", "  53 - Get all  programs");
        menu.put("54", "  54 - Get  program by ID");

        menu.put("6", "   6 - Table: student");
        menu.put("61", "  61 - Create  student");
        menu.put("62", "  62 - Delete  student");
        menu.put("63", "  63 - Get all  student");
        menu.put("64", "  64 - Get  student by ID");

        menu.put("7", "   7 - Table: subject");
        menu.put("71", "  71 - Create  subject");
        menu.put("72", "  72 - Delete  subject");
        menu.put("73", "  73 - Get all  subject");
        menu.put("74", "  74 - Get  subject by ID");


        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createFeedback);
        methodsMenu.put("13", this::deleteFeedback);
        methodsMenu.put("14", this::getAllFeedbacks);
        methodsMenu.put("15", this::getFeedbackById);

        methodsMenu.put("21", this::createGroup);
        methodsMenu.put("22", this::updateGroup);
        methodsMenu.put("23", this::deleteGroup);
        methodsMenu.put("24", this::getAllGroups);
        methodsMenu.put("25", this::getGroupById);

        methodsMenu.put("31", this::createLecturer);
        methodsMenu.put("32", this::updateLecturer);
        methodsMenu.put("33", this::deleteLecturer);
        methodsMenu.put("34", this::getAllLecturers);
        methodsMenu.put("35", this::getLecturerById);

        methodsMenu.put("41", this::createLecture);
        methodsMenu.put("42", this::deleteLecture);
        methodsMenu.put("43", this::getAllLectures);
        methodsMenu.put("44", this::getLectureById);

        methodsMenu.put("51", this::createProgram);
        methodsMenu.put("52", this::deleteProgram);
        methodsMenu.put("53", this::getAllPrograms);
        methodsMenu.put("54", this::getProgramById);

        methodsMenu.put("61", this::createStudent);
        methodsMenu.put("62", this::deleteStudent);
        methodsMenu.put("63", this::getAllStudents);
        methodsMenu.put("64", this::getStudentById);

        methodsMenu.put("71", this::createSubject);
        methodsMenu.put("72", this::deleteSubject);
        methodsMenu.put("73", this::getAllSubjects);
        methodsMenu.put("74", this::getSubjectById);

    }

    private void selectAllTable() {
        getAllFeedbacks();
        getAllGroups();
        getAllLecturers();
        getAllLectures();
        getAllPrograms();
        getAllStudents();
        getAllSubjects();
    }

    private void createFeedback() {
        System.out.println("Input response: ");
        String response = input.nextLine();
        System.out.println("Input mark: ");
        Integer mark = Integer.valueOf((input.nextLine()));
        System.out.println("Input student id: ");
        Integer studentId = Integer.valueOf((input.nextLine()));
        System.out.println("Input lecture id: ");
        Integer lectureId = Integer.valueOf((input.nextLine()));
        Feedback feedback = new Feedback(null, response, mark, studentId, lectureId);

        int count = feedbackController.create(feedback);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFeedback() {
        System.out.println("Input ID: ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = feedbackController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void getAllFeedbacks() {
        System.out.println("\nTable: feedback");
        List<Feedback> feedbacks = feedbackController.getAll();
        for (Feedback feedback : feedbacks) {
            System.out.println(feedback);
        }
    }

    private void getFeedbackById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Feedback> feedback = feedbackController.getById(id);
        System.out.println(feedback.orElse(nullFeedback));
    }


    private void createGroup() {
        System.out.println("Input number : ");
        Integer number = Integer.valueOf(input.nextLine());
        System.out.println("Input program id: ");
        Integer lectureId = Integer.valueOf(input.nextLine());

        Group group = new Group(null, number, lectureId);

        int count = groupController.create(group);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateGroup() {
        System.out.println("Input group ID: ");
        Integer groupId = Integer.valueOf(input.nextLine());

        System.out.println("Input new group number: ");
        Integer number = Integer.valueOf(input.nextLine());
        System.out.println("Input new group ID: ");
        Integer lectureId = Integer.valueOf(input.nextLine());

        Group group = new Group(null, number, lectureId);

        int count = groupController.update(groupId, group);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteGroup() {
        System.out.println("Input group ID: ");
        Integer groupId = Integer.valueOf(input.nextLine());

        int count = groupController.delete(groupId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void getAllGroups() {
        System.out.println("\nTable: group");
        List<Group> groups = groupController.getAll();
        for (Group group : groups) {
            System.out.println(group);
        }
    }

    private void getGroupById() {
        System.out.println("Input group ID: ");
        Integer groupId = Integer.valueOf(input.nextLine());

        Optional<Group> group = groupController.getById(groupId);
        System.out.println(group.orElse(nullGroup));
    }

    private void createLecturer() {
        System.out.println("Input first name: ");
        String name = input.nextLine();
        System.out.println("Input  type: ");
        String  type = input.nextLine();

        Lecturer lecturer = new Lecturer(null, name, type);

        int count = lecturerController.create(lecturer);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateLecturer() {
        System.out.println("Input id: ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new name: ");
        String name = input.nextLine();
        System.out.println("Input new type: ");
        String type = input.nextLine();


        Lecturer lecturer = new Lecturer(null, name, type);

        int count = lecturerController.update(id, lecturer);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteLecturer() {
        System.out.println("Input id: ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = lecturerController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void getAllLecturers() {
        System.out.println("\nTable: lecturer");
        List<Lecturer> lecturers = lecturerController.getAll();
        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer);
        }
    }

    private void getLecturerById() {
        System.out.println("Input id: ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Lecturer> lecturer = lecturerController.getById(id);
        System.out.println(lecturer.orElse(nullLecturer));
    }


    private void createLecture() {
        System.out.println("Input date : ");
        String date = input.nextLine();
        System.out.println("Input topic : ");
        String topic = input.nextLine();
        System.out.println("Input groupId : ");
        Integer groupId = Integer.valueOf(input.nextLine());
        System.out.println("Input subjectId : ");
        Integer subjectId = Integer.valueOf(input.nextLine());
        System.out.println("Input lecturerId : ");
        Integer lecturerId = Integer.valueOf(input.nextLine());

        Lecture lecture = new Lecture(null, date,topic,groupId,subjectId,lecturerId);

        int count = lectureController.create(lecture);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteLecture() {
        System.out.println("Input lecture ID: ");
        Integer lectureId = Integer.valueOf(input.nextLine());

        int count =lectureController.delete(lectureId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void getAllLectures() {
        System.out.println("\nTable: lecture");
        List<Lecture> lectures = lectureController.getAll();
        for (Lecture lecture : lectures) {
            System.out.println(lecture);
        }
    }

    private void getLectureById() {
        System.out.println("Input lecture ID: ");
        Integer lectureId = Integer.valueOf(input.nextLine());

        Optional<Lecture> lecture = lectureController.getById(lectureId);
        System.out.println(lecture.orElse(nullLecture));
    }

    private void createProgram() {
        System.out.println("Input event: ");
        String name = input.nextLine();
        System.out.println("Input sum in dollars: ");
        String description = input.nextLine();

        Program program = new Program(null, name, description);

        int count = programController.create(program);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteProgram() {
        System.out.println("Input Program ID: ");
        Integer programId = Integer.valueOf(input.nextLine());

        int count = programController.delete(programId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void getAllPrograms() {
        System.out.println("\nTable: program");
        List<Program> programs = programController.getAll();
        for (Program program : programs) {
            System.out.println(program);
        }
    }

    private void getProgramById() {
        System.out.println("Input program ID: ");
        Integer programId = Integer.valueOf(input.nextLine());

        Optional<Program> program = programController.getById(programId);
        System.out.println(program.orElse(nullProgram));
    }

    private void createStudent() {
        System.out.println("Input name: ");
        String name = input.nextLine();
        System.out.println("Input groupID: ");
        Integer groupID = Integer.valueOf(input.nextLine());
        System.out.println("Input age: ");
        Integer age = Integer.valueOf(input.nextLine());

        Student student = new Student(null, name, groupID,age);

        int count = studentController.create(student);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteStudent() {
        System.out.println("Input student ID: ");
        Integer studentId = Integer.valueOf(input.nextLine());

        int count = studentController.delete(studentId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void getAllStudents() {
        System.out.println("\nTable: student");
        List<Student> students = studentController.getAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void getStudentById() {
        System.out.println("Input student ID: ");
        Integer studentId = Integer.valueOf(input.nextLine());

        Optional<Student> student = studentController.getById(studentId);
        System.out.println(student.orElse(nullStudent));
    }
    ////////////////////////////////////////
    private void createSubject() {
        System.out.println("Input event: ");
        String name = input.nextLine();
        System.out.println("Input duration ");
        Integer duration = Integer.valueOf(input.nextLine());
        System.out.println("Input difficulty ");
        Integer difficulty = Integer.valueOf(input.nextLine());

        Subject subject = new Subject(null, name, duration,difficulty);

        int count = subjectController.create(subject);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteSubject() {
        System.out.println("Input subject ID: ");
        Integer subjectId = Integer.valueOf(input.nextLine());

        int count = subjectController.delete(subjectId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void getAllSubjects() {
        System.out.println("\nTable: subject");
        List<Subject> subjects = subjectController.getAll();
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    private void getSubjectById() {
        System.out.println("Input subject ID: ");
        Integer subjectId = Integer.valueOf(input.nextLine());

        Optional<Subject> subject = subjectController.getById(subjectId);
        System.out.println(subject.orElse(nullSubject));
    }




    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String digit) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(digit)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!keyMenu.equals("Q"));
    }
}
