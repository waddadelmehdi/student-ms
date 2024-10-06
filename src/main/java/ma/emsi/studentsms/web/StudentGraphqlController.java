package ma.emsi.studentsms.web;

import ma.emsi.studentsms.dto.StudentDTORequest;
import ma.emsi.studentsms.dto.StudentDTOResponse;
import ma.emsi.studentsms.entities.Classroom;
import ma.emsi.studentsms.entities.Student;
import ma.emsi.studentsms.repos.ClassroomtRepo;
import ma.emsi.studentsms.repos.StudentRepo;
import ma.emsi.studentsms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentGraphqlController {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomtRepo classroomtRepo;
    @QueryMapping
    private List<Student> students(){
        return studentRepo.findAll();
    }

    @QueryMapping(name = "student")
    private Student studentById(@Argument Long id){
        return studentRepo.findById(id)
                    .orElseThrow(()-> new RuntimeException("Student not found!"));
    }

    @MutationMapping
    private StudentDTOResponse addStudent(@Argument StudentDTORequest studentDTORequest){
        return studentService.addStudent(studentDTORequest);
    }

    @MutationMapping
    private StudentDTOResponse updateStudent(@Argument Long id, @Argument StudentDTORequest student){
        return studentService.updateStudent(id,student);
    }

    @MutationMapping
    private void deleteStudent(@Argument Long id){
        studentService.deleteStudent(id);
    }

    @QueryMapping
    private List<Classroom> classrooms(){
        return classroomtRepo.findAll();
    }
}
