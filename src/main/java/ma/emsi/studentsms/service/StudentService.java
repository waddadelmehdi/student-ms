package ma.emsi.studentsms.service;

import ma.emsi.studentsms.dto.StudentDTORequest;
import ma.emsi.studentsms.dto.StudentDTOResponse;

public interface StudentService {
    StudentDTOResponse addStudent(StudentDTORequest studentDTORequest);
    StudentDTOResponse updateStudent(Long id, StudentDTORequest student);
    void deleteStudent(Long id);
}
