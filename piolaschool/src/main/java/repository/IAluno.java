package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.br.piolaschool.entidade.aluno.Aluno;

@Component
public interface IAluno extends JpaRepository<Aluno, Integer>{

    Aluno getById(Long matricula);
    
}
