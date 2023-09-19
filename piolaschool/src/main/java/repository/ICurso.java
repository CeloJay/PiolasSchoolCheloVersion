package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.br.piolaschool.entidade.curso.Curso;

@Component
public interface ICurso extends JpaRepository<Curso, Integer>{
    
}
