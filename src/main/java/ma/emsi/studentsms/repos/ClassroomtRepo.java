package ma.emsi.studentsms.repos;

import ma.emsi.studentsms.entities.Classroom;
import ma.emsi.studentsms.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface ClassroomtRepo extends JpaRepository<Classroom, Long> {
}

