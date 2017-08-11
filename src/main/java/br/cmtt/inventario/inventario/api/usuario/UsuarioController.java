package br.cmtt.inventario.inventario.api.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /*******************
    ***LISTAR USUÁRIO***
    *******************/
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Usuario>> getAllUsuarios() {
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return new ResponseEntity<>(usuarioRepository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(params = {"nomeUsuario"}, method = RequestMethod.GET)
    public ResponseEntity<Collection<Usuario>> getUsuarioByNomeUsuario(@RequestParam(value = "nomeUsuario") String nomeUsuario) {
        return new ResponseEntity<>(usuarioRepository.findUsuarioByNomeUsuario(nomeUsuario), HttpStatus.OK);
    }

    /*******************
    ***SALVAR USUÁRIO***
    *******************/
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.OK);
    }

    /*******************
    **ALTERAR USUÁRIO***
    *******************/
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") long id, @RequestBody Usuario usuario) {
        Usuario usuarioAtual = usuarioRepository.findOne(id);
        usuarioAtual.setNome(usuario.getNome());
        usuarioAtual.setCpf(usuario.getCpf());
        usuarioAtual.setNomeUsuario(usuario.getNomeUsuario());
        usuarioAtual.setSenha(usuario.getSenha());

        return new ResponseEntity<>(usuarioRepository.save(usuarioAtual), HttpStatus.OK);
    }

    /*******************
    **EXCLUIR USUÁRIO***
    *******************/
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUsuarioById(@PathVariable Long id){
        usuarioRepository.delete(id);
    }
}
