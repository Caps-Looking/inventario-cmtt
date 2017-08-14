package br.cmtt.inventario.inventario.api.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {

    @Autowired
    DepartamentoRepository departamentoRepository;

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
}
