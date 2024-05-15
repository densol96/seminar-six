package lv.venta.seminar_six.service;

import java.util.ArrayList;
import java.util.List;

import lv.venta.seminar_six.model.Grade;

public interface IGradeFilterService {
  List<Grade> selectGradesByStudentId(int id)
      throws Exception;

  List<Grade> selectFailedGradesByStudentId(int id)
      throws Exception;

  float calculateAVGGradeInCourseById(int id)
      throws Exception;
}
