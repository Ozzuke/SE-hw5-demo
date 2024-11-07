package ee.ut.tvt.hibernateDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "STUDENTS_TO_COURSES",
            joinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
    )
    private Set<Course> courses;

    @ManyToOne
    @JoinColumn(name = "SPECIALITY_ID", nullable = false)
    private Speciality speciality;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" -- ").append(firstName).append(" ").append(lastName).append("\n");
        sb.append("      Participates in the following courses: \n");
        if (courses != null) {
            for (Course c : courses) {
                sb.append("       * ").append(c.getEstonianName()).append("\n");
            }
        } else {
            sb.append("       ?");
        }

        return sb.toString();
    }

    public String getFullName() {
        return (lastName == null ? firstName : firstName + " " + lastName);
    }

}
