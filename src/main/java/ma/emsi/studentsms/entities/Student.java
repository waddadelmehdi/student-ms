package ma.emsi.studentsms.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.studentsms.enums.Gender;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 50, nullable = false)
    private String fullName;
    @Temporal(TemporalType.DATE) @Column(nullable = false)
    private Date birthDate;
    @Column(length = 8,  nullable = false)
    private String NID; //CIN
    @Column(nullable = false) @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(nullable = false)
    private String contactNo;
    @Column(length = 100, nullable = false)
    private String address;
    @Column(nullable = false)
    private Boolean enabled;
    @ManyToOne
    private Classroom classroom;
}

