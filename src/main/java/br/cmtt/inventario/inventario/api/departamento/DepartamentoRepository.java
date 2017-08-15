package br.cmtt.inventario.inventario.api.departamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    public List<Departamento> findAll();

    public List<Departamento> findDepartamentoByNome(String nomeDepartamento);
}
