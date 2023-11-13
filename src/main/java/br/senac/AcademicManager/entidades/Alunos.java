package br.senac.AcademicManager.entidades;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alunos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = 15)
    private String primeiroNome;
    @Column(nullable = false, length = 20)
    private String sobrenome;
    @Column(nullable = false)
    private int idade;
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    private String curso;
    @Column(length = 15)
    private String semestre;
    @Column(nullable = false, length = 15)
    private String status;
}
