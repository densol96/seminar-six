package lv.venta.seminar_six.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import lv.venta.seminar_six.model.Professor;

public interface ProfessorRepo extends JpaRepository<Professor, Integer> {

}