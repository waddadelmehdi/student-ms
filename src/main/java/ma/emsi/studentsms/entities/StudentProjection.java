package ma.emsi.studentsms.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Student.class,name = "proj1")
public interface StudentProjection {
    public Long getId();
    public String getFullName();
}
