package br.senac.AcademicManager.seguranca.dominio;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InicializarComAdmin implements ApplicationListener<ApplicationReadyEvent> {

    private UsuarioRepositorio usuarioRepositorio;
    private PasswordEncoder codificadorDeSenhas;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (usuarioRepositorio.searchByPapel(Papel.MASTER).isEmpty()) {
            var usuarioSalvo = usuarioRepositorio.save(Usuario
                    .builder()
                    .usuario("MASTER")
                    .senha(codificadorDeSenhas.encode("12345"))
                    .papel(Papel.ADMIN)
                    .build());
        }
    }
}
