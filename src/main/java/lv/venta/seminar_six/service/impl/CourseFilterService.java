package lv.venta.seminar_six.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lv.venta.seminar_six.model.Course;
import lv.venta.seminar_six.repos.*;
import lv.venta.seminar_six.service.*;

@Service
public class CourseFilterService implements ICourseFilterService {

  private final CourseRepo courseRepo;
  private final ProfessorRepo professorRepo;
  private final StudentRepo studRepo;

  public CourseFilterService(CourseRepo courseRepo, ProfessorRepo professorRepo, StudentRepo studRepo) {
    this.courseRepo = courseRepo;
    this.professorRepo = professorRepo;
    this.studRepo = studRepo;
  }

  @Override
  public List<Course> selectCoursesByCP(int cp) throws Exception {
    if (cp < 0 || cp > 20)
      throw new Exception("Cp should be between 0 and 20");

    List<Course> result = courseRepo.findByCreditPoints(cp);

    if (result.isEmpty())
      throw new Exception("There is no course with " + cp + " creditpoints");

    return result;
  }

  @Override
  public List<Course> selectCoursesByProfessorId(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Id should be positive");

    if (!professorRepo.existsById(id))
      throw new Exception("Professor with id (" + id + ") doesn't exist");

    List<Course> result = courseRepo.findByProfessorId(id);

    if (result.isEmpty())
      throw new Exception("There is no linkage between this professor and course");

    return result;
  }

  @Override
  public List<Course> selectCoursesByStudentId(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Id should be positive");

    if (!studRepo.existsById(id))
      throw new Exception("Student with id (" + id + ") doesn't exist");

    List<Course> result = courseRepo.findByGradesStudentId(id);

    if (result.isEmpty())
      throw new Exception("There is no linkage between this student and course");

    return result;
  }

}
