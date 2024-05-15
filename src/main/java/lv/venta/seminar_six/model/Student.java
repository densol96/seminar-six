package lv.venta.seminar_six.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String surname;

  @OneToMany(mappedBy = "student")
  @ToString.Exclude
  private List<Grade> grades;

  public Student(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

}
