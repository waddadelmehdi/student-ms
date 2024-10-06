package ma.emsi.studentsms.web;

import ma.emsi.studentsms.dto.StudentDTORequest;
import ma.emsi.studentsms.dto.StudentDTOResponse;
import ma.emsi.studentsms.entities.Student;
import ma.emsi.studentsms.repos.StudentRepo;

import ma.emsi.studentsms.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class StudentRestController {
    private StudentRepo studentRepo;
    private StudentService studentService;

    public StudentRestController(StudentRepo studentRepo, StudentService studentService) {
        this.studentRepo = studentRepo;
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> studentList(){
        return studentRepo.findAll();
    }

    @GetMapping("/students/{id}")
    public Student student(@PathVariable Long id){
        return studentRepo.findById(id).orElseThrow(() -> new RuntimeException(String.format("Le compte %s n'existe pas!",id)));
    }

    @PostMapping("/students")
    public StudentDTOResponse saveStudent(@RequestBody StudentDTORequest student){
        return studentService.addStudent(student);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student studentById =  studentRepo.findById(id).get();

        if(student.getFullName() != null) studentById.setFullName(student.getFullName());
        if(student.getAddress() != null) studentById.setAddress(student.getAddress());
        if(student.getGender() != null) studentById.setGender(student.getGender());
        if(student.getEnabled() != null) studentById.setEnabled(student.getEnabled());
        if(student.getNID() != null) studentById.setNID(student.getNID());
        if(student.getBirthDate() != null) studentById.setBirthDate(student.getBirthDate());
        if(student.getContactNo() != null) studentById.setContactNo(student.getContactNo());

        return studentRepo.save(studentById);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
         studentRepo.deleteById(id);
    }
}

