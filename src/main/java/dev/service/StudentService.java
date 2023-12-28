package dev.service;

import dev.domain.Student;
import dev.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student) throws SQLException {
        student.setName(student.getName().toUpperCase());
        studentRepository.create(student);
    }

    public List<Student> getAllStudents() throws SQLException {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) throws SQLException {
        return studentRepository.findById(id);
    }

    public void updateStudentById(Student updatedStudent) throws SQLException {
        studentRepository.updateStudentById(updatedStudent);
    }

    public void deleteStudentById(int id) throws SQLException {
        studentRepository.deleteById(id);
    }

    public long getStudentCount() {
        return studentRepository.getStudentCount();
    }
}
