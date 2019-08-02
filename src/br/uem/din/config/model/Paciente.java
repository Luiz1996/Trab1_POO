//by Luiz Flávio Pereira ra91706
package br.uem.din.config.model;

import java.util.Objects;

public class Paciente extends Pessoa{
    private String convenio = "";
    private char fuma = ' '; 
    private char bebe = ' ';
    private char colesterol = ' ';
    private char diabetes = ' ';
    private char alergias = ' ';
    private char probCardiaco = ' ';
    private char cirurgia = ' '; 
    
    public Paciente() {
    }

    public Paciente(String nome, String cpf, String rg, String dataNascimento, String email, String endereco, String telefone, String convenio, char fuma, char bebe, char colesterol, char diabetes, char alergias, char probCardiaco, char cirurgia) {
        super(nome, cpf, rg, dataNascimento, email, endereco, telefone);
        this.convenio = convenio;
        this.fuma = fuma;
        this.bebe = bebe;
        this.colesterol = colesterol;
        this.diabetes = diabetes;
        this.alergias = alergias; 
        this.probCardiaco = probCardiaco;
        this.cirurgia = cirurgia;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public char getFuma() {
        return fuma;
    }

    public void setFuma(char fuma) {
        this.fuma = fuma;
    }

    public char getBebe() {
        return bebe;
    }

    public void setBebe(char bebe) {
        this.bebe = bebe;
    }

    public char getColesterol() {
        return colesterol;
    }

    public void setColesterol(char colesterol) {
        this.colesterol = colesterol;
    }

    public char getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(char diabetes) {
        this.diabetes = diabetes;
    }

    public char getAlergias() {
        return alergias;
    }

    public void setAlergias(char alergias) {
        this.alergias = alergias;
    }

    public char getProbCardiaco() {
        return probCardiaco;
    }

    public void setProbCardiaco(char probCardiaco) {
        this.probCardiaco = probCardiaco;
    }

    public char getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(char cirurgia) {
        this.cirurgia = cirurgia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.convenio);
        hash = 59 * hash + this.fuma;
        hash = 59 * hash + this.bebe;
        hash = 59 * hash + this.colesterol;
        hash = 59 * hash + this.diabetes;
        hash = 59 * hash + this.alergias;
        hash = 59 * hash + this.probCardiaco;
        hash = 59 * hash + this.cirurgia;
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
        final Paciente other = (Paciente) obj;
        if (this.fuma != other.fuma) {
            return false;
        }
        if (this.bebe != other.bebe) {
            return false;
        }
        if (this.colesterol != other.colesterol) {
            return false;
        }
        if (this.diabetes != other.diabetes) {
            return false;
        }
        if (this.alergias != other.alergias) {
            return false;
        }
        if (this.probCardiaco != other.probCardiaco) {
            return false;
        }
        if (this.cirurgia != other.cirurgia) {
            return false;
        }
        return Objects.equals(this.convenio, other.convenio);
    }
}
