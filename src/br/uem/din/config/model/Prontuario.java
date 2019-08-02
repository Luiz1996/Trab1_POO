//BY Marcos Vinicius Peres RA: 94594
package br.uem.din.config.model;

import java.util.Objects;

public class Prontuario {
    private String diagnostico = "";
    private String medicamentos = "";
    private String data = "";
    private String horaInicio = "";
    private String horaFinal = "";
    private String cpfPac = "";
    private String cpfMed = "";
    
    public Prontuario() {
    }

    public Prontuario(String diagnostico, String medicamentos){
        this.diagnostico = diagnostico;
        this.medicamentos = medicamentos;
    }
    
    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }  

    public String getCpfPac() {
        return cpfPac;
    }

    public void setCpfPac(String cpfPac) {
        this.cpfPac = cpfPac;
    }

    public String getCpfMed() {
        return cpfMed;
    }

    public void setCpfMed(String cpfMed) {
        this.cpfMed = cpfMed;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.diagnostico);
        hash = 61 * hash + Objects.hashCode(this.medicamentos);
        hash = 61 * hash + Objects.hashCode(this.data);
        hash = 61 * hash + Objects.hashCode(this.horaInicio);
        hash = 61 * hash + Objects.hashCode(this.horaFinal);
        hash = 61 * hash + Objects.hashCode(this.cpfPac);
        hash = 61 * hash + Objects.hashCode(this.cpfMed);
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
        final Prontuario other = (Prontuario) obj;
        if (!Objects.equals(this.diagnostico, other.diagnostico)) {
            return false;
        }
        if (!Objects.equals(this.medicamentos, other.medicamentos)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.horaInicio, other.horaInicio)) {
            return false;
        }
        if (!Objects.equals(this.horaFinal, other.horaFinal)) {
            return false;
        }
        if (!Objects.equals(this.cpfPac, other.cpfPac)) {
            return false;
        }
        return Objects.equals(this.cpfMed, other.cpfMed);
    }

    @Override
    public String toString() {
        return "Prontuario{" + "diagnostico=" + diagnostico + ", medicamentos=" + medicamentos + ", data=" + data + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + ", cpfPac=" + cpfPac + ", cpfMed=" + cpfMed + '}';
    }  
}
