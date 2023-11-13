package br.senac.AcademicManager.seguranca.dominio;

import java.util.Arrays;

public enum Papel {
    MASTER,
    ADMIN,
    USUARIO;

    public static String[] getNomesPapeis() {
         return Arrays.stream(Papel.values())
                .map(Papel::name)
                .toArray(String[]::new);
    }
}
