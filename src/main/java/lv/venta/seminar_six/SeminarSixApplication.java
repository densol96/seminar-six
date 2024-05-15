package lv.venta.seminar_six;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.seminar_six.model.*;
import lv.venta.seminar_six.repos.*;

@SpringBootApplication
public class SeminarSixApplication {

  public static void main(String[] args) {
    SpringApplication.run(SeminarSixApplication.class, args);
  }

  @Bean
  public CommandLineRunner testDatabaseLayer(ProfessorRepo profRepo, StudentRepo stuRepo,
      CourseRepo courseRepo, GradeRepo grRepo) {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        Student st1 = new Student("Janis", "Berzins");
        Student st2 = new Student("Baiba", "Jauka");
        stuRepo.save(st1);
        stuRepo.save(st2);

        Professor p1 = new Professor("Karina", "Skirmante", Degree.mg);
        Professor p2 = new Professor("Vairis", "Caune", Degree.phd);
        profRepo.save(p1);
        profRepo.save(p2);

        Course c1 = new Course("JAVA", 4, p1);
        Course c2 = new Course("Algoritmu teorija", 2, p2);
        courseRepo.save(c1);
        courseRepo.save(c2);

        Grade gr1 = new Grade(st1, c1, 6);
        Grade gr2 = new Grade(st1, c2, 9);
        Grade gr3 = new Grade(st2, c1, 10);
        grRepo.save(gr1);
        grRepo.save(gr2);
        grRepo.save(gr3);
      }
    };
  }
}