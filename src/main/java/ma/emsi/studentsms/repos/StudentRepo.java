package ma.emsi.studentsms.repos;

import ma.emsi.studentsms.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByFullNameContains(String fullname);
}

