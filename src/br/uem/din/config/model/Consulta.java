//by Luiz Flávio Pereira ra91706
package br.uem.din.config.model;

import java.util.Calendar;
import java.util.Objects;

public class Consulta {
    private Calendar dataHora = null;
    private String cpfPac = "";
    private String cpfMed = "";
    private int tipoConsulta = 0;

    public Consulta() {
    }

    public Consulta(Calendar datahora, String cpfPac, String cpfMed, int tipoConsulta) {
        this.dataHora = datahora;
        this.cpfPac = cpfPac;
        this.cpfMed = cpfMed;
        this.tipoConsulta = tipoConsulta;
    }
    
    public Calendar getDatahora() {
        return dataHora;
    }

    public void setDatahora(Calendar datahora) {
        this.dataHora = datahora;
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

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.dataHora);
        hash = 11 * hash + Objects.hashCode(this.cpfPac);
        hash = 11 * hash + Objects.hashCode(this.cpfMed);
        hash = 11 * hash + this.tipoConsulta;
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
        final Consulta other = (Consulta) obj;
        if (this.tipoConsulta != other.tipoConsulta) {
            return false;
        }
        if (!Objects.equals(this.cpfPac, other.cpfPac)) {
            return false;
        }
        if (!Objects.equals(this.cpfMed, other.cpfMed)) {
            return false;
        }
        return Objects.equals(this.dataHora, other.dataHora);
    }
}
