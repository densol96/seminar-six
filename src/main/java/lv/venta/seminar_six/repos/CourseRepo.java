package lv.venta.seminar_six.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lv.venta.seminar_six.model.*;

public interface CourseRepo extends JpaRepository<Course, Integer> {

  List<Course> findByCreditPoints(int cp);

  List<Course> findByProfessorId(Integer id);

  List<Course> findByGradesStudentId(Integer id);
}