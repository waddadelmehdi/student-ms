package ma.emsi.studentsms.mappers;

import ma.emsi.studentsms.dto.StudentDTORequest;
import ma.emsi.studentsms.dto.StudentDTOResponse;
import ma.emsi.studentsms.entities.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDTOResponse fromStudent(Student student){
        StudentDTOResponse studentDTOResponse = new StudentDTOResponse();
        BeanUtils.copyProperties(student,studentDTOResponse);
        return studentDTOResponse;
    }
}
