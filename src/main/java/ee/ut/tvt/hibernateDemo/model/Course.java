package ee.ut.tvt.hibernateDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Set;

@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estonian_name")
    private String estonianName;

    @Transient
    private String englishName;

    @Transient
    private Lecturer lecturer;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @Transient
    private Set<Speciality> specialities;

    public Lecturer getLecturer() {
        return lecturer;
    }

    public String getEstonianName() {
        return estonianName;
    }

    private String getEnglishName() {
        return englishName == null ? "?" : englishName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" -- ").append(estonianName).append(" [").append(getEnglishName()).append("]\n");
        sb.append("      Belongs to following specialities: \n");
        if (specialities != null) {
            for (Speciality s : specialities) {
                sb.append("       * ").append(s.getName()).append("\n");
            }
        } else {
            sb.append("       ?");
        }
        return sb.toString();
    }

}
