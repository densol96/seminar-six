package lv.venta.seminar_six.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.seminar_six.service.ICourseFilterService;

@Controller
@RequestMapping("/course/filter")
public class CourseFilterController {

  private final ICourseFilterService courseService;
  private final ICourseFilterService gradeService;

  public CourseFilterController(ICourseFilterService courseService, ICourseFilterService gradeService) {
    this.courseService = courseService;
    this.gradeService = gradeService;
  }

  @GetMapping("/cp/{param}") // localhost:8080/course/filter/cp/4
  public String getCourseFilterByCp(@PathVariable("param") int cp,
      Model model) {
    try {
      model.addAttribute("mydata", courseService.selectCoursesByCP(cp));
      model.addAttribute("msg", "Courses filtered by creditpoints");
      return "course-all-show-page";// parādām course-all-show-page.html lapu
    } catch (Exception e) {
      model.addAttribute("errormsg", e.getMessage());
      return "error-page";// tiks parādīta error-page.html lapa
    }

  }

  @GetMapping("/professor/{id}") // localhost:8080/course/filter/professor/2
  public String getCourseFilterByProfessorID(@PathVariable("id") int id,
      Model model) {
    try {
      model.addAttribute("mydata", courseService.selectCoursesByProfessorId(id));
      model.addAttribute("msg", "Courses filtered by Professor id");
      return "course-all-show-page";// parādām course-all-show-page.html lapu
    } catch (Exception e) {
      model.addAttribute("errormsg", e.getMessage());
      return "error-page";// tiks parādīta error-page.html lapa
    }

  }

  @GetMapping("/student/{id}") // localhost:8080/course/filter/student/2
  public String getCourseFilterByStudentID(@PathVariable("id") int id,
      Model model) {
    try {
      model.addAttribute("mydata", courseService.selectCoursesByStudentId(id));
      model.addAttribute("msg", "Courses filtered by Student id");
      return "course-all-show-page";// parādām course-all-show-page.html lapu
    } catch (Exception e) {
      model.addAttribute("errormsg", e.getMessage());
      return "error-page";// tiks parādīta error-page.html lapa
    }

  }
}
