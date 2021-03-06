package br.cmtt.inventario.inventario.api.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public List<Usuario> findAll();

    public List<Usuario> findUsuarioByNomeUsuario(String nomeUsuario);
}
