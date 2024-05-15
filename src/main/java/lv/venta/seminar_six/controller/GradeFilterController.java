package lv.venta.seminar_six.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.seminar_six.service.IGradeFilterService;

@Controller
@RequestMapping("/grade/filter")
public class GradeFilterController {

  private final IGradeFilterService gradeService;

  public GradeFilterController(IGradeFilterService gradeService) {
    this.gradeService = gradeService;
  }

  @GetMapping("/failed/student/{id}") // localhost:8080/grade/filter/student/2
  public String getFailedGradesByStudent(@PathVariable("id") int id,
      Model model) {

    try {
      model.addAttribute("mydata", gradeService.selectFailedGradesByStudentId(id));
      return "grade-all-show-page";
    } catch (Exception e) {
      model.addAttribute("errormsg", e.getMessage());
      return "error-page";// tiks parādīta error-page.html lapa
    }
  }

  @GetMapping("/student/{id}") // localhost:8080/grade/filter/student/2
  public String getGradeFilterStudentById(@PathVariable("id") int id,
      Model model) {

    try {
      model.addAttribute("mydata", gradeService.selectGradesByStudentId(id));
      return "grade-all-show-page";
    } catch (Exception e) {
      model.addAttribute("errormsg", e.getMessage());
      return "error-page";// tiks parādīta error-page.html lapa
    }
  }

  @GetMapping("/avg/student/{id}") // localhost:8080/grade/filter/avg/student/2
  public String showAvgGrade(@PathVariable int id, Model model) {
    try {
      model.addAttribute("grade", gradeService.calculateAVGGradeInCourseById(id));
      return "avg-grade";
    } catch (Exception e) {
      return "error-page";
    }
  }

}
