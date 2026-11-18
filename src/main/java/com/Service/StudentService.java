package com.Service;

import com.Dao.StudentDao;
import com.Model.Student;

public class StudentService {

    public int saveStudentRecord(Student st) {

        StudentDao dao = new StudentDao();

        return dao.saveStudentRecord(st);
    }
}