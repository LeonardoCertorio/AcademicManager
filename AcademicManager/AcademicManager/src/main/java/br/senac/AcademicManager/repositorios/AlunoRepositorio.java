package br.senac.AcademicManager.repositorios;

import br.senac.AcademicManager.entidades.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "Alunos")
public interface AlunoRepositorio extends JpaRepository<Alunos, Long> {

    List<Alunos> searchByNome(String primeiro_nome);
    List<Alunos> searchBySobrenome(String sobrenome);
    @Query("select c from Alunos c where lower(c.primeiro_nome) like lower(concat(:termo, '%')) or lower(c.sobrenome) like lower(concat(:termo, '%'))")
    List<Alunos> searchByNomeSobrenome(@Param("termo") String termoBusca);
    @Query("select c from Alunos c where lower(c.curso) like lower(concat(:termo, '%'))")
    List<Alunos> searchByCurso(@Param("termo") String termoBusca);
    @Query("select c from Alunos c where lower(c.primeiro_nome) like lower(concat(:termo, '%')) or lower(c.curso) like lower(concat(:termo, '%'))")
    List<Alunos> searchByNomeECurso(@Param("termo") String termoBusca);
    @Query("select c from Alunos c where lower(c.status) like lower(concat(:status, '%'))")
    List<Alunos> searchByStatus(@Param("termo") String termoBusca);
}
