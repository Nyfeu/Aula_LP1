package authentication.model.entities;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private Integer faltas;
    private ArrayList<Float> notas;
    private Timestamp lastModified;

    public Usuario() {}

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.notas = new ArrayList<>();
        this.lastModified = new Timestamp(System.currentTimeMillis());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Float> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Float> notas) {
        this.notas = notas;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public void setLastModified() {
        this.lastModified = new Timestamp(System.currentTimeMillis());
    }

    public void readLastModified(Timestamp timestamp) {
        this.lastModified = timestamp;
    }

    public Timestamp getLastModified() {
        if (lastModified == null) {
            lastModified = new Timestamp(System.currentTimeMillis());
        }
        return lastModified;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", lastModified='" + lastModified + '\'' +
                '}';
    }
}
