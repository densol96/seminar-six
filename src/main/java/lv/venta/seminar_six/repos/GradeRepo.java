package lv.venta.seminar_six.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lv.venta.seminar_six.model.*;

public interface GradeRepo extends JpaRepository<Grade, Integer> {

  List<Grade> findByStudentId(Integer studentId);

  List<Grade> findByStudentIdAndGradeValueLessThan(Integer studentId, int gradeValue);

  @Query(nativeQuery = true, value = "SELECT AVG(grade_value) FROM grades WHERE course_id =?1")
  float calculateAVGByCourseId(int id);
}