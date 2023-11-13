package br.senac.AcademicManager.repositorios;

import br.senac.AcademicManager.entidades.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepositorio extends JpaRepository<Alunos, Long> {

    @Query("select c from Alunos c where lower(c.primeiroNome) like lower(concat(:termo, '%'))")
    List<Alunos> searchByprimeiroNome(@Param("termo") String termoBusca);
    @Query("select c from Alunos c where lower(c.sobrenome) like lower(concat(:termo, '%'))")
    List<Alunos> searchBySobrenome(@Param("termo") String termoBusca);
    @Query("select c from Alunos c where lower(c.primeiroNome) like lower(concat(:termo, '%')) or lower(c.sobrenome) like lower(concat(:termo, '%'))")
    List<Alunos> searchByNomeSobrenome(@Param("termo") String termoBusca);
    @Query("select c from Alunos c where lower(c.curso) like lower(concat(:termo, '%'))")
    List<Alunos> searchByCurso(@Param("termo") String termoBusca);
    @Query("select c from Alunos c where lower(c.primeiroNome) like lower(concat(:termo, '%')) or lower(c.curso) like lower(concat(:termo, '%'))")
    List<Alunos> searchByNomeECurso(@Param("termo") String termoBusca);
    @Query("select c from Alunos c where lower(c.status) like lower(concat(:termo, '%'))")
    List<Alunos> searchByStatus(@Param("termo") String termoBusca);
}
