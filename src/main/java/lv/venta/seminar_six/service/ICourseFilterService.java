package lv.venta.seminar_six.service;

import java.util.List;

import lv.venta.seminar_six.model.Course;

public interface ICourseFilterService {
  List<Course> selectCoursesByCP(int cp)
      throws Exception;

  List<Course> selectCoursesByProfessorId(int id)
      throws Exception;

  List<Course> selectCoursesByStudentId(int id)
      throws Exception;
}
