//by Luiz Flávio Pereira ra91706
package br.uem.din.config.controller;

import br.uem.din.config.model.Consulta;
import br.uem.din.config.model.Medico;
import br.uem.din.config.model.Paciente;
import br.uem.din.config.model.Prontuario;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws ParseException {
        ExecucaoController menu = new ExecucaoController();
        
        List<Medico> medico =  new ArrayList<>();
        List<Paciente> paciente =  new ArrayList<>();
        List<Prontuario> prontuario = new ArrayList<>();
        List<Consulta> consulta = new ArrayList<>();
        
        //chama execucao dos menus que ficarão sempre em loop podendo mudar de secretária para médico e vice versa.
        menu.menusExecucao(medico, paciente, prontuario, consulta);
    }   
}
