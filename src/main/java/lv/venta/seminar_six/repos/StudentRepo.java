package lv.venta.seminar_six.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import lv.venta.seminar_six.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
