package ma.emsi.studentsms;

import ma.emsi.studentsms.entities.Classroom;
import ma.emsi.studentsms.entities.Student;
import ma.emsi.studentsms.enums.Gender;
import ma.emsi.studentsms.repos.ClassroomtRepo;
import ma.emsi.studentsms.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class StudentsMsApplication implements CommandLineRunner {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ClassroomtRepo classroomtRepo;

    public static void main(String[] args) {
        SpringApplication.run(StudentsMsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for(long i=1; i<7; i++){
            Classroom classroom = Classroom.builder()
                    .id(i)
                    .name("Classe_"+i)
                    .build();
            classroomtRepo.save(classroom);
        }

        classroomtRepo.findAll().forEach(classroom -> {
            for(int i=1; i<=10; i++){
                Student student = Student.builder()
                        .id(i)
                        .fullName("Etud "+i)
                        .birthDate(new Date())
                        .NID("CIN_ "+i)
                        .gender((i%2 == 0) ? Gender.FEMALE : Gender.MALE)
                        .contactNo("066100000"+i)
                        .address("Adresse Etudiant "+i)
                        .enabled((i%2 == 0) ? Boolean.FALSE : Boolean.TRUE)
                        .classroom(classroom)
                        .build();
                        studentRepo.save(student);
        }});
    }

            //Ou bien en utilisant le @Builder
            /*
            Student student = Student.builder()
                    .id(i)
                    .fullName("Etud "+i)
                    .birthDate(new Date())
                    .NID("CIN"+i)
                    .gender((i%2 == 0) ? Gender.FEMALE : Gender.MALE)
                    .contactNo("066100000"+i)
                    .address("Adresse Etudiant "+i)
                    .enabled((i%2 == 0) ? Boolean.FALSE : Boolean.TRUE)
                    .build();
             */


    }


