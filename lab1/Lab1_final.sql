-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-08 20:58:53.888

-- tables
-- Table: Group

use LAB1;
CREATE TABLE `Group` (
    id int NOT NULL AUTO_INCREMENT,
    Number int NOT NULL,
    Program_id int NOT NULL,
    CONSTRAINT Group_pk PRIMARY KEY (id)
);
-- Table: Lecture
CREATE TABLE Lecture (
    id int NOT NULL AUTO_INCREMENT,
    Date date NOT NULL,
    Topic varchar(20) NOT NULL,
    Group_id int NOT NULL,
    Subject_id int NOT NULL,
    Lecturer_id int NOT NULL,
    CONSTRAINT Lecture_pk PRIMARY KEY (id)
);

-- Table: Lecturer
CREATE TABLE Lecturer (
    id int NOT NULL AUTO_INCREMENT,
    Name varchar(20) NOT NULL,
    Type varchar(20) NOT NULL,
    CONSTRAINT Lecturer_pk PRIMARY KEY (id)
);

-- Table: Program
CREATE TABLE Program (
    id int NOT NULL AUTO_INCREMENT,
    Name varchar(20) NOT NULL,
    Description varchar(20) NOT NULL,
    CONSTRAINT Program_pk PRIMARY KEY (id)
);

-- Table: Response
CREATE TABLE Response (
    id int NOT NULL AUTO_INCREMENT,
    Response varchar(10000) NOT NULL,
    Mark int NOT NULL,
    Student_id int NOT NULL,
    Lecture_id int NOT NULL,
    CONSTRAINT Response_pk PRIMARY KEY (id)
);

-- Table: Student
CREATE TABLE Student (
    id int NOT NULL AUTO_INCREMENT,
    Name varchar(20) NOT NULL,
    Group_id int NOT NULL,
    CONSTRAINT Student_pk PRIMARY KEY (id)
);

-- Table: Subject
CREATE TABLE Subject (
    id int NOT NULL AUTO_INCREMENT,
    Name varchar(20) NOT NULL,
    Duration int NOT NULL,
    CONSTRAINT Subject_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Group_Program (table: Group)
ALTER TABLE `Group` ADD CONSTRAINT Group_Program FOREIGN KEY Group_Program (Program_id)
    REFERENCES Program (id);

-- Reference: Lecture_Group (table: Lecture)
ALTER TABLE Lecture ADD CONSTRAINT Lecture_Group FOREIGN KEY Lecture_Group (Group_id)
    REFERENCES `Group` (id);

-- Reference: Lecture_Lecturer (table: Lecture)
ALTER TABLE Lecture ADD CONSTRAINT Lecture_Lecturer FOREIGN KEY Lecture_Lecturer (Lecturer_id)
    REFERENCES Lecturer (id);

-- Reference: Lecture_Subject (table: Lecture)
ALTER TABLE Lecture ADD CONSTRAINT Lecture_Subject FOREIGN KEY Lecture_Subject (Subject_id)
    REFERENCES Subject (id);

-- Reference: Response_Lecture (table: Response)
ALTER TABLE Response ADD CONSTRAINT Response_Lecture FOREIGN KEY Response_Lecture (Lecture_id)
    REFERENCES Lecture (id);

-- Reference: Response_Student (table: Response)
ALTER TABLE Response ADD CONSTRAINT Response_Student FOREIGN KEY Response_Student (Student_id)
    REFERENCES Student (id);

-- Reference: Student_Group (table: Student)
ALTER TABLE Student ADD CONSTRAINT Student_Group FOREIGN KEY Student_Group (Group_id)
    REFERENCES `Group` (id);

-- End of file.

INSERT INTO `Group` (Number,Program_id)
VALUES (12,1);
INSERT INTO `Group` (Number,Program_id)
VALUES (13,2);
INSERT INTO `Group` (Number,Program_id)
VALUES (14,3);
INSERT INTO `Group` (Number,Program_id)
VALUES (15,4);
INSERT INTO `Group` (Number,Program_id)
VALUES (16,5);
INSERT INTO `Group` (Number,Program_id)
VALUES (17,6);
INSERT INTO `Group` (Number,Program_id)
VALUES (18,7);
INSERT INTO `Group` (Number,Program_id)
VALUES (19,8);
INSERT INTO `Group` (Number,Program_id)
VALUES (20,9);
INSERT INTO `Group` (Number,Program_id)
VALUES (21,10);

select * from `Group`;

INSERT INTO Response (Response,Mark,Student_id,Lecture_id)
VALUES ("not so good",3,1,1);
INSERT INTO Response (Response,Mark,Student_id,Lecture_id)
VALUES ("so good",2,2,2);
INSERT INTO Response (Response,Mark,Student_id,Lecture_id)
VALUES ("good",3,3,3);
INSERT INTO Response (Response,Mark,Student_id,Lecture_id)
VALUES ("could be better",4,4,4);
INSERT INTO Response (Response,Mark,Student_id,Lecture_id)
VALUES ("nice",1,5,5);
INSERT INTO Response (Response,Mark,Student_id,Lecture_id)
VALUES ("the best",5,6,6);
INSERT INTO Response (Response,Mark,Student_id,Lecture_id)
VALUES ("i like it",5,7,7);
INSERT INTO Response (Response,Mark,Student_id,Lecture_id)
VALUES ("i am impressed",5,8,8);
INSERT INTO Response (Response,Mark,Student_id,Lecture_id)
VALUES ("the worth lection ever",1,9,9);
INSERT INTO Response (Response,Mark,Student_id,Lecture_id)
VALUES ("good",4,10,10);

INSERT INTO Student (Name,Group_id)
VALUES ("Vanya",1);
INSERT INTO Student (Name,Group_id)
VALUES ("Sasha",2);
INSERT INTO Student (Name,Group_id)
VALUES ("Ruslan",3);
INSERT INTO Student (Name,Group_id)
VALUES ("Marta",4);
INSERT INTO Student (Name,Group_id)
VALUES ("Illya",5);
INSERT INTO Student (Name,Group_id)
VALUES ("Vita",6);
INSERT INTO Student (Name,Group_id)
VALUES ("Ylia",7);
INSERT INTO Student (Name,Group_id)
VALUES ("Svyat",8);
INSERT INTO Student (Name,Group_id)
VALUES ("Alina",9);
INSERT INTO Student (Name,Group_id)
VALUES ("Max",10);

select * from Student;

INSERT INTO Subject (Name,Duration)
VALUES ("chemistry",15);
INSERT INTO Subject (Name,Duration)
VALUES ("Fiz-ra",25);
INSERT INTO Subject (Name,Duration)
VALUES ("Maths",35);
INSERT INTO Subject (Name,Duration)
VALUES ("Literature",45);
INSERT INTO Subject (Name,Duration)
VALUES ("Biology",55);
INSERT INTO Subject (Name,Duration)
VALUES ("English",65);
INSERT INTO Subject (Name,Duration)
VALUES ("Geography",75);
INSERT INTO Subject (Name,Duration)
VALUES ("Philosophy",85);
INSERT INTO Subject (Name,Duration)
VALUES ("Physics",155);
INSERT INTO Subject (Name,Duration)
VALUES ("Reading",38);

select * from Subject;

INSERT INTO Lecture (Date,Topic,Group_id,Subject_id,Lecturer_id)
VALUES ("2008-11-11","ML",1,1,1);
INSERT INTO Lecture (Date,Topic,Group_id,Subject_id,Lecturer_id)
VALUES ("2008-11-11","ML",2,2,2);
INSERT INTO Lecture (Date,Topic,Group_id,Subject_id,Lecturer_id)
VALUES ("2008-11-11","ML",3,3,3);
INSERT INTO Lecture (Date,Topic,Group_id,Subject_id,Lecturer_id)
VALUES ("2008-11-11","ML",4,4,4);
INSERT INTO Lecture (Date,Topic,Group_id,Subject_id,Lecturer_id)
VALUES ("2008-11-11","ML",5,5,5);
INSERT INTO Lecture (Date,Topic,Group_id,Subject_id,Lecturer_id)
VALUES ("2008-11-11","Algos",6,6,6);
INSERT INTO Lecture (Date,Topic,Group_id,Subject_id,Lecturer_id)
VALUES ("2008-11-11","web",7,7,7);
INSERT INTO Lecture (Date,Topic,Group_id,Subject_id,Lecturer_id)
VALUES ("2008-11-11","algo",8,8,8);
INSERT INTO Lecture (Date,Topic,Group_id,Subject_id,Lecturer_id)
VALUES ("2008-11-11","c++",9,9,9);
INSERT INTO Lecture (Date,Topic,Group_id,Subject_id,Lecturer_id)
VALUES ("2008-11-11","python",10,10,10);

select * from Lecture;

INSERT INTO Lecturer (Name,Type)
VALUES ("Anton","lecturer");
INSERT INTO Lecturer (Name,Type)
VALUES ("Petro","reporter");
INSERT INTO Lecturer (Name,Type)
VALUES ("Anna","lecturer");
INSERT INTO Lecturer (Name,Type)
VALUES ("Illya","lecturer");
INSERT INTO Lecturer (Name,Type)
VALUES ("Shpack","lecturer");
INSERT INTO Lecturer (Name,Type)
VALUES ("Max","reporter");
INSERT INTO Lecturer (Name,Type)
VALUES ("Nastia","lecturer");
INSERT INTO Lecturer (Name,Type)
VALUES ("Marta","reporter");
INSERT INTO Lecturer (Name,Type)
VALUES ("Yulia","lecturer");
INSERT INTO Lecturer (Name,Type)
VALUES ("Ruslan","reporter");

select * from Lecturer;

INSERT INTO Program (Name,Description)
VALUES ("IOT","very good");
INSERT INTO Program (Name,Description)
VALUES ("IOM","great");
INSERT INTO Program (Name,Description)
VALUES ("IOR","better than nothing");
INSERT INTO Program (Name,Description)
VALUES ("IOY","ok");
INSERT INTO Program (Name,Description)
VALUES ("IOK","well known");
INSERT INTO Program (Name,Description)
VALUES ("IOL","bad");
INSERT INTO Program (Name,Description)
VALUES ("IOG","very bad");
INSERT INTO Program (Name,Description)
VALUES ("IOB","good but not good");
INSERT INTO Program (Name,Description)
VALUES ("IOC","i have no idea");
INSERT INTO Program (Name,Description)
VALUES ("IOX","may i go?");

select * from Program;

