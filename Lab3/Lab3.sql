

CREATE DATABASE if not exists Labor_SQL;
use Labor_SQL;


DROP TABLE IF EXISTS Feedback;
CREATE TABLE Feedback (
    id int NOT NULL AUTO_INCREMENT,
    response varchar(10000) NOT NULL,
    mark int NOT NULL,
    student_id int NOT NULL,
    lecture_id int NOT NULL,
    CONSTRAINT Feedback_pk PRIMARY KEY (id)
);


DROP TABLE IF EXISTS Lecture;
CREATE TABLE Lecture (
    id int NOT NULL AUTO_INCREMENT,
    date date NOT NULL,
    topic varchar(20) NOT NULL,
    group_id int NOT NULL,
    subject_id int NOT NULL,
    lecturer_id int NOT NULL,
    CONSTRAINT Lecture_pk PRIMARY KEY (id)
);
CREATE INDEX topic_index ON Lecture (topic) USING BTREE;

DROP TABLE IF EXISTS Student;
CREATE TABLE Student (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(20) NOT NULL,
    group_id int NOT NULL,
    age int NOT NULL,
    CONSTRAINT Student_pk PRIMARY KEY (id)
);
CREATE INDEX student_index ON Student (name, group_id) USING BTREE;

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group` (
    id int NOT NULL AUTO_INCREMENT,
    number int NOT NULL,
    program_id int NOT NULL,
    CONSTRAINT Group_pk PRIMARY KEY (id)
);


DROP TABLE IF EXISTS Program;
CREATE TABLE Program (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(20) NOT NULL,
    description varchar(20) NOT NULL,
    CONSTRAINT Program_pk PRIMARY KEY (id)
);


DROP TABLE IF EXISTS Lecturer;
CREATE TABLE Lecturer (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(20) NOT NULL,
    type varchar(20) NOT NULL,
    CONSTRAINT Lecturer_pk PRIMARY KEY (id)
);


DROP TABLE IF EXISTS Subject;
CREATE TABLE Subject (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(20) NOT NULL,
    duration int NOT NULL,
    difficulty int NOT NULL,
    CONSTRAINT Subject_pk PRIMARY KEY (id)
);





ALTER TABLE `Group` ADD CONSTRAINT Group_Program FOREIGN KEY Group_Program (program_id)
    REFERENCES Program (id);


ALTER TABLE Lecture ADD CONSTRAINT Lecture_Group FOREIGN KEY Lecture_Group (group_id)
    REFERENCES `Group` (id);


ALTER TABLE Lecture ADD CONSTRAINT Lecture_Lecturer FOREIGN KEY Lecture_Lecturer (lecturer_id)
    REFERENCES Lecturer (id);


ALTER TABLE Lecture ADD CONSTRAINT Lecture_Subject FOREIGN KEY Lecture_Subject (subject_id)
    REFERENCES Subject (id);


ALTER TABLE Feedback ADD CONSTRAINT Response_Lecture FOREIGN KEY Response_Lecture (lecture_id)
    REFERENCES Lecture (id);


ALTER TABLE Feedback ADD CONSTRAINT Response_Student FOREIGN KEY Response_Student (student_id)
    REFERENCES Student (id);


ALTER TABLE Student ADD CONSTRAINT Student_Group FOREIGN KEY Student_Group (group_id)
    REFERENCES `Group` (id);


INSERT INTO Subject (Name,Duration,difficulty) VALUES 
("chemistry",15,3),
("Fiz-ra",25,4),
("Maths",35,6),
("Literature",45,8),
("Biology",55,2),
("English",65,2),
("Geography",75,9),
("Philosophy",85,5),
("Physics",155,3),
("Reading",38,7);

INSERT INTO Lecturer (Name,Type) VALUES 
("Anton","lecturer"),
("Petro","reporter"),
("Anna","lecturer"),
("Illya","lecturer"),
("Shpack","lecturer"),
("Max","reporter"),
("Nastia","lecturer"),
("Marta","reporter"),
("Yulia","lecturer"),
("Ruslan","reporter");


INSERT INTO Program (Name,Description) VALUES 
("IOT","very good"),
("IOM","great"),
("IOR","better than nothing"),
("IOY","ok"),
("IOK","well known"),
("IOL","bad"),
("IOG","very bad"),
("IOB","good but not good"),
("IOC","i have no idea"),
("IOX","may i go?");


INSERT INTO `Group` (Number,Program_id) VALUES 
(12,1),
(13,2),
(14,3),
(15,4),
(16,5),
(17,6),
(18,7),
(19,8),
(20,9),
(21,10);


INSERT INTO Student (Name,Group_id,age) VALUES 
("Vanya",1,12),
("Sasha",2,15),
("Ruslan",3,17),
("Marta",4,19),
("Illya",5,14),
("Vita",6,16),
("Ylia",7,19),
("Svyat",8,15),
("Alina",9,20),
("Max",10,21);


INSERT INTO Lecture (Date,Topic,Group_id,Subject_id,Lecturer_id) VALUES 
("2008-11-11","ML",1,1,1),
("2008-11-11","ML",2,2,2),
("2008-11-11","ML",3,3,3),
("2008-11-11","ML",4,4,4),
("2008-11-11","ML",5,5,5),
("2008-11-11","Algos",6,6,6),
("2008-11-11","web",7,7,7),
("2008-11-11","algo",8,8,8),
("2008-11-11","c++",9,9,9),
("2008-11-11","python",10,10,10);


INSERT INTO Feedback (Response,Mark,Student_id,Lecture_id) VALUES 
("not so good",3,1,1),
("so good",2,2,2),
("good",3,3,3),
("could be better",4,4,4),
("nice",1,5,5),
("the best",5,6,6),
("i like it",5,7,7),
("i am impressed",5,8,8),
("the worth lection ever",1,9,9),
("good",4,10,10);














