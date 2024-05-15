package lv.venta.seminar_six.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "professors")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String surname;

  @NotNull
  private Degree degree;

  @OneToOne(mappedBy = "professor")
  @ToString.Exclude
  private Course course;

  public Professor(String name, String surname, @NotNull Degree degree) {
    this.name = name;
    this.surname = surname;
    this.degree = degree;
    this.course = course;
  }

}
