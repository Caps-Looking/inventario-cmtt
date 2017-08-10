package br.cmtt.inventario.inventario.api.usuario;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
    @SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @NotEmpty
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;

    @NotEmpty
    @Size(max = 11)
    @Column(name = "cpf")
    private String cpf;

    @NotEmpty
    @Size(min = 8, max = 20)
    @Column(name = "senha")
    private String senha;

    @NotEmpty
    @Size(min = 6, max = 12)
    @Column(name = "nome_usuario")
    private String nomeUsuario;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
