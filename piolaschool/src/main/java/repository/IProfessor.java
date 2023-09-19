package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.br.piolaschool.entidade.professor.Professor;

@Component
public interface IProfessor extends JpaRepository<Professor, Integer> {
    
    Professor getById(Long matricula);
}
