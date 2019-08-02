//BY Marcos Vinicius Peres RA: 94594
package br.uem.din.config.model;

import java.util.Objects;

public class Medico extends Pessoa{
    private String dataAdmissao = "";
    private String dataDemissao = "";
    private String crm = ""; 
    
    public Medico() {
    }

    public Medico(String nome, String cpf, String rg, String dataNascimento, String email, String endereco, String telefone, String dataAdmissao, String dataDemissao, String crm) {
        super(nome, cpf, rg, dataNascimento, email, endereco, telefone);
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.crm = crm;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.dataAdmissao);
        hash = 79 * hash + Objects.hashCode(this.dataDemissao);
        hash = 79 * hash + Objects.hashCode(this.crm);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.dataAdmissao, other.dataAdmissao)) {
            return false;
        }
        if (!Objects.equals(this.dataDemissao, other.dataDemissao)) {
            return false;
        }
        return Objects.equals(this.crm, other.crm);
    }
}
