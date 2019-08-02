//by Luiz Flávio Pereira ra91706
package br.uem.din.config.model;

import java.util.Objects;

public class Pessoa {
    private String nome = "";
    private String cpf = "";
    private String rg = ""; 
    private String dataNascimento = "";
    private String email = "";
    private String endereco = "";
    private String telefone = ""; 

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String rg, String dataNascimento, String email, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.cpf);
        hash = 29 * hash + Objects.hashCode(this.rg);
        hash = 29 * hash + Objects.hashCode(this.dataNascimento);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.endereco);
        hash = 29 * hash + Objects.hashCode(this.telefone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return Objects.equals(this.telefone, other.telefone);
    }  
}
