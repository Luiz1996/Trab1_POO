//BY Marcos Vinicius Peres RA: 94594
package br.uem.din.config.medico;

import br.uem.din.config.model.Prontuario;
import br.uem.din.config.model.Medico;
import br.uem.din.config.model.Consulta;
import br.uem.din.config.model.Paciente;
import br.uem.din.config.controller.MenuController;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class RelatoriosMedico {
    Scanner in = new Scanner(System.in);
    MenuController menu = new MenuController();

    public RelatoriosMedico() {
    }
    //METODO QUE IRÁ IMPRIMIR O ATESTADO
    public void atestado(List<Prontuario> pro, List<Paciente> pac, List<Medico> med) {
        boolean verPac = false;
        boolean verMed = false;
        boolean verPro = false;

        System.out.print("Forneça o CPF do Paciente: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine();

        System.out.print("Forneça o CPF do Médico..: ");
        in = new Scanner(System.in);
        String cpfMed = in.nextLine();

        for (int i = 0; i < pro.size(); i++) {
            if (pro.get(i).getCpfPac().trim().equals(cpfPac.trim()) && pro.get(i).getCpfMed().trim().equals(cpfMed.trim())) {
                verPac = true;
                verMed = true;
                break;
            }
        }
        menu.limparTela();
        if (!verPac) {
            System.out.println("Paciente não encontrado!");

        }

        if (!verMed) {
            System.out.println("Médico não encontrado!");

        }

        menu.limparTela();
        System.out.println("----------------------------------------------------RELAÇÃO DE PRONTUARIO(S)----------------------------------------------------------");
        //METODO QUE IRÁ PRINTAR TODOS OS PRONTUARIOS PARA VER ENCIMA DE QUAL PRONTUARIO QUER SE FAZER OS ATESTADOS
        for (int i = 0; i < pro.size(); i++) {
            if (pro.get(i).getCpfPac().equals(cpfPac) || pro.get(i).getCpfMed().equals(cpfMed)) {
                verPro = true;
                System.out.print("Cod. Prontuario: [" + i + "] - ");
            }
            for (int j = 0; j < pac.size(); j++) {
                if (pac.get(j).getCpf().trim().equals(cpfPac.trim())) {
                    System.out.print("Paciente: " + pac.get(j).getNome().trim() + " CPF: " + pac.get(j).getCpf().trim() + "-");

                }
            }
            for (int k = 0; k < med.size(); k++) {
                if (med.get(k).getCpf().trim().trim().equals(cpfMed.trim())) {
                    System.out.print("Dr(a). " + med.get(k).getNome().trim() + " CRM: " + med.get(k).getCrm().trim() + "-");
                }
            }
            System.out.print("Hora inicial: " + pro.get(i).getHoraInicio() + " Hora final: " + pro.get(i).getHoraFinal() + "-");
            System.out.println(" Data: " + pro.get(i).getData());
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        }

        if (!verPro) {
            menu.limparTela();
            System.out.println("Nenhum prontuario encontrado para o medico e/ou paciente");
        }
        //ESCOLHENDO QUAL PRONTUARIO QUE IRÁ SE FAZER O ATESTADO ABAIXO 
        System.out.print("Informe o Cód. do atestado: ");
        in = new Scanner(System.in);
        int indexPro = in.nextInt();

        menu.limparTela();
        //ATRAVES DO INDEXPRO DIGITADO, IRÁ IMPRIMIR O ATESTADO
        if ((pro.get(indexPro).getCpfPac().trim().equals(cpfPac) && pro.get(indexPro).getCpfMed().trim().equals(cpfMed)) && pro.get(indexPro) != null) {
            for (int i = 0; i < pro.size(); i++) {
                if (pro.get(i).getCpfPac().equals(cpfPac) && pro.get(i).getCpfMed().equals(cpfMed)) {
                    System.out.println("--------------ATESTADO DO PACIENTE------------------");

                    for (int j = 0; j < pac.size(); j++) {
                        if (pac.get(j).getCpf().equals(cpfPac)) {
                            System.out.print("\nSr(a)...............: " + pac.get(j).getNome());
                            System.out.print("\nPortador do ........: " + pac.get(j).getRg());
                            System.out.print("\nE portador do CPF...: " + pac.get(j).getCpf());
                            System.out.print("\nMora em.............: " + pac.get(j).getEndereco());
                        }
                    }
                    
                    System.out.print("\nEsteve sob meus cuidados das: " + pro.get(i).getHoraInicio() + " as " + pro.get(i).getHoraFinal() + " horas");
                    System.out.print("\nDo dia..............: " + pro.get(i).getData());

                    for (int k = 0; k < med.size(); k++) {
                        if (med.get(k).getCpf().equals(cpfMed)) {

                            System.out.println("\n\n________________");
                            System.out.println(med.get(k).getNome());
                            System.out.println("CRM: " + med.get(k).getCrm());
                            return;
                        }
                    }
                }
            }
        }
    }
    
    //METODO QUE IRÁ IMPRIMIR O ATESTADO
    public void receita(List<Paciente> pac, List<Medico> med, List<Prontuario> pro) {
        boolean verPac = false;
        boolean verMed = false;
        boolean verPro = false;

        System.out.print("Forneça o CPF do Paciente: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine();

        System.out.print("Forneça o CPF do Médico..: ");
        in = new Scanner(System.in);
        String cpfMed = in.nextLine();

        for (int i = 0; i < pro.size(); i++) {
            if (pro.get(i).getCpfPac().trim().equals(cpfPac.trim()) && pro.get(i).getCpfMed().trim().equals(cpfMed.trim())) {
                verPac = true;
                verMed = true;
                break;
            }
        }
        menu.limparTela();
        if (!verPac) {
            System.out.println("Paciente não encontrado!");

        }

        if (!verMed) {
            System.out.println("Médico não encontrado!");

        }

        menu.limparTela();
        System.out.println("----------------------------------------------------RELAÇÃO DE PRONTUARIO(S)----------------------------------------------------------");
        //IRÁ PRINTAR TODOS OS PRONTUARIOS PARA VER ENCIMA DE QUAL PRONTUARIO QUER SE FAZER AS RECEITAS
        for (int i = 0; i < pro.size(); i++) {
            if (pro.get(i).getCpfPac().equals(cpfPac) || pro.get(i).getCpfMed().equals(cpfMed)) {
                verPro = true;
                System.out.print("Cod. Prontuario: [" + i + "] - ");
            }
            for (int j = 0; j < pac.size(); j++) {
                if (pac.get(j).getCpf().trim().equals(cpfPac.trim())) {
                    System.out.print("Paciente: " + pac.get(j).getNome().trim() + " CPF: " + pac.get(j).getCpf().trim() + "-");

                }
            }
            for (int k = 0; k < med.size(); k++) {
                if (med.get(k).getCpf().trim().trim().equals(cpfMed.trim())) {
                    System.out.print("Dr(a). " + med.get(k).getNome().trim() + " CRM: " + med.get(k).getCrm().trim() + "-");
                }
            }
            System.out.print("Hora inicial: " + pro.get(i).getHoraInicio() + " Hora final: " + pro.get(i).getHoraFinal() + "-");
            System.out.println(" Data: " + pro.get(i).getData());
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        }

        if (!verPro) {
            menu.limparTela();
            System.out.println("Nenhum prontuario encontrado para o medico e/ou paciente");
        }
        //ESCOLHENDO QUAL PRONTUARIO QUE IRÁ SE FAZER A RECEITA ABAIXO
        System.out.print("Informe o Cód. da receita: ");
        in = new Scanner(System.in);
        int indexPro = in.nextInt();

        menu.limparTela();
        //ATRAVES DO INDEXPRO DIGITADO, IRÁ IMPRIMIR A RECEITA
        if ((pro.get(indexPro).getCpfPac().trim().equals(cpfPac) && pro.get(indexPro).getCpfMed().trim().equals(cpfMed)) && pro.get(indexPro) != null) {
            for (int i = 0; i < pro.size(); i++) {
                if (pro.get(i).getCpfPac().equals(cpfPac) && pro.get(i).getCpfMed().equals(cpfMed)) {
                    System.out.println("--------------RECEITA DO PACIENTE------------------");
                    System.out.print("\nData: " + pro.get(i).getData());
                    for (int j = 0; j < pac.size(); j++) {
                        if (pac.get(j).getCpf().equals(cpfPac)) {
                            System.out.print("\nPaciente: " + pac.get(j).getNome());
                        }

                    }
                    System.out.println("\nMedicamentos: " + pro.get(i).getMedicamentos());

                    for (int k = 0; k < med.size(); k++) {
                        if (med.get(k).getCpf().equals(cpfMed)) {

                            System.out.println("\n\n________________");
                            System.out.println(med.get(k).getNome());
                            System.out.println("CRM: " + med.get(k).getCrm());
                            return;
                        }
                    }
                }
            }
        }
    }
    
    //METODO QUE PRINTA O ATESTADO DE ACOMPANHANTE
    public void atestadoAcompanhante(List<Paciente> pac, List<Medico> med, List<Prontuario> pro) {
        boolean verPac = false;
        boolean verMed = false;
        boolean verPro = false;

        System.out.print("Forneça o CPF do Paciente: ");
        String cpfPac = in.nextLine();

        System.out.print("Forneça o CPF do Médico..: ");
        String cpfMed = in.nextLine();

        for (int i = 0; i < pro.size(); i++) {
            if (pro.get(i).getCpfPac().trim().equals(cpfPac.trim()) && pro.get(i).getCpfMed().trim().equals(cpfMed.trim())) {
                verPac = true;
                verMed = true;
                break;
            }
        }
        menu.limparTela();
        if (!verPac) {
            System.out.println("Paciente não encontrado!");

        }

        if (!verMed) {
            System.out.println("Médico não encontrado!");

        }

        menu.limparTela();
        System.out.println("----------------------------------------------------RELAÇÃO DE PRONTUARIO(S)----------------------------------------------------------");
        //METODO QUE IRÁ PRINTAR TODOS OS PRONTUARIOS PARA VER ENCIMA DE QUAL PRONTUARIO QUER SE FAZER O ATESTADO DO ACOMPANHANTE
        for (int i = 0; i < pro.size(); i++) {
            if (pro.get(i).getCpfPac().equals(cpfPac) || pro.get(i).getCpfMed().equals(cpfMed)) {
                verPro = true;
                System.out.print("Cod. Prontuario: [" + i + "] - ");
            }
            for (int j = 0; j < pac.size(); j++) {
                if (pac.get(j).getCpf().trim().equals(cpfPac.trim())) {
                    System.out.print("Paciente: " + pac.get(j).getNome().trim() + " CPF: " + pac.get(j).getCpf().trim() + "-");
                }
            }
            for (int k = 0; k < med.size(); k++) {
                if (med.get(k).getCpf().trim().trim().equals(cpfMed.trim())) {
                    System.out.print("Dr(a). " + med.get(k).getNome().trim() + " CRM: " + med.get(k).getCrm().trim() + "-");
                }
            }
            System.out.print("Hora inicial: " + pro.get(i).getHoraInicio() + " Hora final: " + pro.get(i).getHoraFinal() + "-");
            System.out.println(" Data: " + pro.get(i).getData());
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        }

        if (!verPro) {
            menu.limparTela();
            System.out.println("Nenhum prontuario encontrado para o medico e/ou paciente");
        }
        
        //ESCOLHENDO QUAL PRONTUARIO QUE IRÁ SE FAZER O ATESTADO DE ACOMPANHAMENTO A BAIXO
        System.out.print("Informe o Cód. do Atestado do que sera vinculado ao acompanhante: ");
        in = new Scanner(System.in);
        int indexPro = in.nextInt();

        System.out.print("Forneça o nome do Acompanhante: ");
        in = new Scanner(System.in);
        String nomeAcompanhante = in.nextLine();

        System.out.print("Forneça o cpf do Acompanhante: ");
        in = new Scanner(System.in);
        String cpfAcompanhante = in.nextLine();

        System.out.print("Forneça o grau de Parentesco do Acompanhante: ");
        in = new Scanner(System.in);
        String grauParentesco = in.nextLine();

        menu.limparTela();
        //ATRAVES DO INDEXPRO DIGITADO, IRÁ IMPRIMIR O ATESTADO DO ACOMPANHANTE
        if ((pro.get(indexPro).getCpfPac().trim().equals(cpfPac) && pro.get(indexPro).getCpfMed().trim().equals(cpfMed)) && pro.get(indexPro) != null) {
            for (int i = 0; i < pro.size(); i++) {
                if (pro.get(i).getCpfPac().equals(cpfPac) && pro.get(i).getCpfMed().equals(cpfMed)) {

                    for (int j = 0; j < pac.size(); j++) {
                        if (pac.get(j).getCpf().equals(cpfPac)) {
                            System.out.println("-------------------ATESTADO ACOMPANHANTE----------------------------");
                            System.out.println("Declaro para os devidos fins, que o Sr(a): " + nomeAcompanhante);
                            System.out.println("Portador do CPF: " + cpfAcompanhante);
                            System.out.println("Esteve nessa unidade hospitalar para acompanhar o (a) paciente: " + pac.get(j).getNome());
                            System.out.println("E que tem grau de parentesco: " + grauParentesco);
                        }
                    }
                    System.out.print("\nNa Data: " + pro.get(i).getData());

                    for (int k = 0; k < med.size(); k++) {
                        if (med.get(k).getCpf().equals(cpfMed)) {

                            System.out.println("\n\n________________");
                            System.out.println(med.get(k).getNome());
                            System.out.println("CRM: " + med.get(k).getCrm());
                            return;
                        }
                    }
                }
            }
        }
    }

    public void atendidoMes(List<Medico> med, List<Consulta> cons) {
        //by Luiz Flávio Pereira ra91706
        boolean verMed = false;
        boolean verCons = false;
        
        System.out.print("Forneça seu CPF: ");
         in = new Scanner(System.in);
        String cpfMed = in.nextLine();
        
        //verificando existência de médico
        for(int i = 0; i < med.size(); i++){
            if(med.get(i).getCpf().trim().equals(cpfMed.trim())){
                verMed = true;
            }
        }
        
        if(!verMed){
            menu.limparTela();
            System.out.println("Médico não encontrado!\n\nConsulta falhou!");
            return;
        }
        
        //trabalhando com Calendar Auxiliar(ideia é obter o mes atual e usar para impressão das consultas do medico deste mes)
        Calendar calendarAux = Calendar.getInstance();
        
        SimpleDateFormat mes = new SimpleDateFormat("MM");
        SimpleDateFormat ano = new SimpleDateFormat("yyyy");
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        
        String mesAux = mes.format(calendarAux.getTime()).trim();
        String anoAux = ano.format(calendarAux.getTime()).trim();
        
        //verificando existencia de consultas para o medico no mes atual(se houver consultas, automaticamente será listada; caso contrário, verCons permanece false e apresenta resposta ao final)
        menu.limparTela();
        System.out.println("--------------------------------------------------------- RELAÇÃO DE CONSULTA(S) ---------------------------------------------------------");
        for(int i = 0; i < cons.size(); i++){
            //convertendo dados necessários
            String mesCons = mes.format(cons.get(i).getDatahora().getTime()).trim();
            String anoCons = ano.format(cons.get(i).getDatahora().getTime()).trim();
            
            if(mesCons.trim().equals(mesAux.trim()) && anoCons.trim().equals(anoAux.trim()) && cons.get(i).getCpfMed().trim().equals(cpfMed.trim())){
                String convDataCons = data.format(cons.get(i).getDatahora().getTime());
                verCons = true;
                System.out.println("Cód. Cons: [" + i + "] | CPF_MED: " + cons.get(i).getCpfMed() + " | CPF_PAC: " + cons.get(i).getCpfPac() + " | Data: " + convDataCons + " | Tipo Consulta: " + (cons.get(i).getTipoConsulta() == 1? "Retorno(30Min)" : "Comum(1Hr)"));
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
        
        if(!verCons){
            menu.limparTela();
            System.out.println("Para o médico com CPF: " + cpfMed + " não foram encontradas consultas este mês!");
        }
    }
}