package lv.venta.seminar_six.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lv.venta.seminar_six.model.Grade;
import lv.venta.seminar_six.repos.*;
import lv.venta.seminar_six.service.IGradeFilterService;

@Service
public class GradeFilterService implements IGradeFilterService {

  private final StudentRepo studentRepo;
  private final GradeRepo gradeRepo;
  private final CourseRepo courseRepo;

  public GradeFilterService(StudentRepo studentRepo, GradeRepo gradeRepo, CourseRepo courseRepo) {
    this.studentRepo = studentRepo;
    this.gradeRepo = gradeRepo;
    this.courseRepo = courseRepo;
  }

  @Override
  public List<Grade> selectGradesByStudentId(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Id should be positive");

    if (!studentRepo.existsById(id))
      throw new Exception("Student with id (" + id + ") doesn't exist");

    List<Grade> result = gradeRepo.findByStudentId(id);

    if (result.isEmpty())
      throw new Exception("There is no linkage between this student and grades");

    return result;
  }

  @Override
  public List<Grade> selectFailedGradesByStudentId(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Id should be positive");

    if (!studentRepo.existsById(id))
      throw new Exception("Student with id (" + id + ") doesn't exist");

    List<Grade> result = gradeRepo.findByStudentIdAndGradeValueLessThan(id, 4);

    if (result.isEmpty())
      throw new Exception("There is no failed grade for this student");

    return result;
  }

  @Override
  public float calculateAVGGradeInCourseById(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Id should be positive");

    if (!courseRepo.existsById(id))
      throw new Exception("Course with id (" + id + ") doesn't exist");

    float result = gradeRepo.calculateAVGByCourseId(id);

    if (result == 0)
      throw new Exception("There is no linkage between this course and grades");

    return result;
  }
}
