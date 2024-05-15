package lv.venta.seminar_six.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  @Size(min = 4, max = 50)
  private String title;

  @Min(0)
  @Max(20)
  private int creditPoints;

  @OneToOne
  @JoinColumn(name = "professor_id")
  private Professor professor;

  @OneToMany(mappedBy = "course")
  @ToString.Exclude
  private List<Grade> grades;

  public Course(String title, int creditPoints, Professor professor) {
    this.title = title;
    this.creditPoints = creditPoints;
    this.professor = professor;
  }

}
