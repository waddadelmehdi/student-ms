package ma.emsi.studentsms.service;

import ma.emsi.studentsms.dto.StudentDTORequest;
import ma.emsi.studentsms.dto.StudentDTOResponse;
import ma.emsi.studentsms.entities.Student;
import ma.emsi.studentsms.mappers.StudentMapper;
import ma.emsi.studentsms.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    StudentMapper studentMapper;
    @Override
    public StudentDTOResponse addStudent(StudentDTORequest studentDTORequest) {
        Student student = new Student();

        student.setFullName(studentDTORequest.getFullName());
        student.setGender(studentDTORequest.getGender());
        student.setAddress(studentDTORequest.getAddress());
        student.setNID(studentDTORequest.getNID());
        student.setContactNo(studentDTORequest.getContactNo());
        student.setBirthDate(new Date());
        student.setEnabled(Boolean.TRUE);
        Student savedStudent = studentRepo.save(student);

        StudentDTOResponse studentDTOResponse = studentMapper.fromStudent(savedStudent);
        return studentDTOResponse;
    }

    @Override
    public StudentDTOResponse updateStudent(Long id, StudentDTORequest student) {
        Student studentById =  studentRepo.findById(id).get();
        if(studentById != null){
            studentById.setFullName(student.getFullName());
            studentById.setAddress(student.getAddress());
            studentById.setGender(student.getGender());
            studentById.setNID(student.getNID());
            studentById.setBirthDate(student.getBirthDate());
            studentById.setContactNo(student.getContactNo());
            return studentMapper.fromStudent(studentById);
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }


}
