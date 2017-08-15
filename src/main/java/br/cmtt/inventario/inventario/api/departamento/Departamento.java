package br.cmtt.inventario.inventario.api.departamento;

import br.cmtt.inventario.inventario.api.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departamento_id_seq")
    @SequenceGenerator(name = "departamento_id_seq", sequenceName = "departamento_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @NotEmpty
    @Size(max = 25)
    @Column(name = "nome")
    private String nome;

    @JsonIgnore
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
