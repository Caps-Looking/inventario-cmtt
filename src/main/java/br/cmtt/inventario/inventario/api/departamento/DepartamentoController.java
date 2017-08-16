package br.cmtt.inventario.inventario.api.departamento;

import br.cmtt.inventario.inventario.api.usuario.Usuario;
import br.cmtt.inventario.inventario.api.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    /********************
    *LISTAR DEPARTAMENTO*
    ********************/
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Departamento>> getAllDepartamentos() {
        return new ResponseEntity<>(departamentoRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Departamento> getDepartamentoById(@PathVariable Long id) {
        return new ResponseEntity<>(departamentoRepository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(params = {"nomeDepartamento"}, method = RequestMethod.GET)
    public ResponseEntity<Collection<Departamento>> getDepartamentoByNome(@RequestParam(value = "nomeDepartamento") String nomeDepartamento) {
        return new ResponseEntity<>(departamentoRepository.findDepartamentoByNome(nomeDepartamento), HttpStatus.OK);
    }

    /********************
    *SALVAR DEPARTAMENTO*
    ********************/
    @RequestMapping(params = {"usuarioId"}, method = RequestMethod.POST)
    public ResponseEntity<?> addDepartamento(@RequestBody Departamento departamento, @RequestParam(value = "usuarioId") Usuario usuarioId) {
        departamento.setUsuario(usuarioId);
        return new ResponseEntity<>(departamentoRepository.save(departamento), HttpStatus.CREATED);
    }
}
