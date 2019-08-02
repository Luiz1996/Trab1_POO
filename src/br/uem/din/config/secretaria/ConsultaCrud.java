//by Luiz Flávio Pereira ra91706
package br.uem.din.config.secretaria;

import br.uem.din.config.model.Medico;
import br.uem.din.config.model.Paciente;
import br.uem.din.config.model.Consulta;
import br.uem.din.config.controller.MenuController;
import br.uem.din.config.mensageria.Email;
import br.uem.din.config.mensageria.Sms;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;

public class ConsultaCrud {
    MenuController menu = new MenuController();
    Scanner in = new Scanner(System.in);
    
    public int obterHora(String horaCompleta){
        if(horaCompleta.equals("")){
            return 0;
        }else{
            String[] hora = horaCompleta.split(":");
            String hr = "";
            hr = hora[0];
            int horaFinal = Integer.parseInt(hr);
            return horaFinal;
        }
    }
    
    public int obterMinuto(String horaCompleta){
        if(horaCompleta.equals("")){
            return 0;
        }else{
            String[] minuto = horaCompleta.split(":");
            String min = "";
            min = minuto[1];
            int minutoFinal = Integer.parseInt(min);
            return minutoFinal;
        }
    }
    
    public Consulta cadConsulta(List<Paciente> pac, List<Medico> med){
        in = new Scanner(System.in);  
        boolean verPac = false;
        boolean verMed = false;
        Consulta consulta = new Consulta();
        Consulta consNull = null;
        int i, j;

        System.out.println("------------------ * CADASTRAR CONSULTA * ------------------");
        System.out.print("Forneça o CPF do Paciente..........: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine();
        
        System.out.print("Forneça o CPF do Médico............: ");
        in = new Scanner(System.in);
        String cpfMed = in.nextLine();
        
        //procurando existencia de paciente
        for (i = 0; i < pac.size(); i++) {
            if (pac.get(i).getCpf().trim().equals(cpfPac.trim())) {
                verPac = true;
                break;
            }
        }
        
        //procurando existencia de médico
        for (j = 0; j < med.size(); j++) {
            if (med.get(j).getCpf().trim().equals(cpfMed.trim())) {
                verMed = true;
                break;
            }
        }
        
        //se não encontrar paciente ou médico o cadastro de consulta é abortado
        if(!verPac){
            menu.limparTela();
            System.out.println("Paciente não encontrado!");
            return consNull;
        }
        
        if(!verMed){
            menu.limparTela();
            System.out.println("Médico não encontrado!");
            return consNull;
        }
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        
        //obtendo data
        System.out.print("Forneça a Data[DD/MM/AAAA].........: ");  
        in = new Scanner(System.in);
        String strData = in.nextLine();
        
        //setando data
        try { 
            cal.setTime(dateFormat.parse(strData));
	} catch (ParseException e) {
            menu.limparTela();
            System.out.println("Erro ao converter Data!");
            return consNull;
        }

        //obtendo horario
        System.out.print("Forneça a Hora[HH:MM]..............: "); 
        in = new Scanner(System.in);
        String strHorario = in.nextLine(); 
        
        //setando horario
        cal.set(Calendar.HOUR_OF_DAY, obterHora(strHorario));
        cal.set(Calendar.MINUTE, obterMinuto(strHorario));
        
        //obtendo tipo de consulta
        System.out.print("Tipo Consulta [0: Comum/1: Retorno]: ");
        in = new Scanner(System.in);
        int tipoCons = in.nextInt();
        
        if(tipoCons != 0 && tipoCons != 1){
            System.out.println("Tipo de consulta inválido!\n\nCadastro de consulta falhou!");
            return consNull;
        }
        
        //verificação de cadastro de consulta em horario inválido
        if(obterHora(strHorario) < 8 || obterHora(strHorario) > 18){
            menu.limparTela();
            System.out.println("Horário inválido!");
            return consNull;
        }
        
        //atribuindo dados obtidos
        consulta.setCpfPac(cpfPac);
        consulta.setCpfMed(cpfMed);
        consulta.setTipoConsulta(tipoCons);
        consulta.setDatahora(cal);
        
        menu.limparTela();
        System.out.println("Agendado a consulta do paciente '" + pac.get(i).getNome()+"' com o Dr(a). '" + med.get(j).getNome() + "'.\nData: " + cal.getTime());
        
        return consulta;
    }
    
    public void consConsulta(List<Consulta> cons, List<Medico> med, List<Paciente> pac){
        boolean verCons = false;
        in = new Scanner(System.in);
        
        //apagando consultas carregadas com null na lista de consultas(estava impactando na impressão das consultas)
        for(int i = 0; i < cons.size(); i++){
            if(cons.get(i) == null){
                cons.remove(i);
            }
        }
        
        System.out.print("Forneça o CPF do Paciente.: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine();
        
        System.out.print("Forneça o CPF do Médico...: ");
        in = new Scanner(System.in);
        String cpfMed = in.nextLine();
        
        menu.limparTela();
        System.out.println("------------------ * BUSCAR CONSULTA(S) * ------------------");
        for(int i = 0; i < cons.size(); i++){
            if((cons.get(i).getCpfPac().trim().equals(cpfPac.trim()) && cons.get(i).getCpfMed().trim().equals(cpfMed)) && cons.get(i) != null){
                verCons = true;
                System.out.println("Cód. Consulta...: " + i + "\n");
               
                for(int j = 0; j < pac.size(); j++){
                    if(pac.get(j).getCpf().trim().equals(cpfPac.trim())){
                        System.out.println("Paciente........: " + pac.get(j).getNome().trim() + " CPF: " + pac.get(j).getCpf().trim() + " Dt. Nasc: " + pac.get(j).getDataNascimento().trim());
                        break;
                    }
                }
                
                for(int k = 0; k < med.size(); k++){
                    if(med.get(k).getCpf().trim().equals(cpfMed.trim())){
                        System.out.println("Dr(a)...........: " + med.get(k).getNome().trim() + " CRM: " + med.get(k).getCrm().trim());
                        break;
                    }
                }
                
                System.out.println("\nTipo da consulta: " + (cons.get(i).getTipoConsulta() == 1? "Retorno" : "Comum"));  
                System.out.println("Data da consulta: " + cons.get(i).getDatahora().getTime());
            }
            System.out.println("------------------------------------------------------------");
        }
        if(!verCons){
            menu.limparTela();
            System.out.println("Nenhuma consulta encontrada!");
        }
    }
    
    public void editConsulta(List<Consulta> cons, List<Medico> med, List<Paciente> pac){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
        boolean verCons = false;
        
        //apagando consultas carregadas com null na lista de consultas(estava impactando na impressão das consultas)
        for(int i = 0; i < cons.size(); i++){
            if(cons.get(i) == null){
                cons.remove(i);
            }
        }
        
        //obtendo cpf do paciente para filtrar apenas consultas pertinentes a ele
        System.out.print("Forneça o CPF do Paciente.: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine();
        
        //relacionando todas as consultas do paciente
        menu.limparTela();
        System.out.println("---------------------------------------------------------- RELAÇÃO DE CONSULTA(S) --------------------------------------------------------");
        for(int i = 0; i < cons.size(); i++){
            if(cons.get(i).getCpfPac().trim().equals(cpfPac.trim())){
                verCons = true;
                System.out.print("Cód. Cons.: [" + i + "] - ");
               
                for(int j = 0; j < pac.size(); j++){
                    if(pac.get(j).getCpf().trim().equals(cpfPac.trim())){
                        System.out.print("Paciente: " + pac.get(j).getNome().trim() + " - ");
                        break;
                    }
                }
                
                for(int k = 0; k < med.size(); k++){
                    if(med.get(k).getCpf().trim().equals(cons.get(i).getCpfMed().trim())){
                        System.out.print("Dr(a). " + med.get(k).getNome().trim() + " CRM: " + med.get(k).getCrm().trim() + " - ");
                        break;
                    }
                }
                
                System.out.print("Tipo da consulta: " + (cons.get(i).getTipoConsulta() == 1? "Retorno -" : "Comum -"));  
                System.out.println(" Data da consulta: " + cons.get(i).getDatahora().getTime());
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
        
        //caso não encontre nenhuma consulta para o paciente em questão a execução do método é ecerrada
        if(!verCons){
            menu.limparTela();
            System.out.println("Nenhuma consulta encontrada para o médico e/ou paciente!");
            return;
        }
        
        //selecionando a consulta a ser editada
        System.out.print("Informe o Cód. da Consulta a ser editada: ");
        in = new Scanner(System.in);
        int indexCons = in.nextInt();
        
        if(cons.get(indexCons) == null || !cons.get(indexCons).getCpfPac().trim().equals(cpfPac)){
            System.out.println("Consulta inválida ou para paciente incorreto!");
            return;
        }
        
        //imprimindo dados anteriores da consulta selecionada
        menu.limparTela();
        System.out.println("------------------- * DADOS ANTERIORES * -------------------");
        System.out.println("Data......: " + dateFormat.format(cons.get(indexCons).getDatahora().getTime()));
        System.out.println("Hora......: " + hourFormat.format(cons.get(indexCons).getDatahora().getTime()));
        System.out.println("CPF Médico: " + cons.get(indexCons).getCpfMed());
        System.out.println("Tp. Consul: " + (cons.get(indexCons).getTipoConsulta() == 1? "[1] - Retorno" : "[0] - Comum"));
        
        //recebendo novos dados
        System.out.println("---------------------- * DADOS NOVOS * ---------------------");
        in = new Scanner(System.in);
        System.out.print("Insira a nova data[DD/MM/AAAA]................: ");
        String nvData = in.nextLine();
        
        //convertendo data e hora
        try { 
            cal.setTime(dateFormat.parse(nvData));
        } catch (ParseException e) {
            menu.limparTela();
            System.out.println("Erro ao converter Data!\n\nEdição falhou!");
            return;
        }
        
        in = new Scanner(System.in);
        System.out.print("Insira o novo horário[HH:MM]..................: ");
        String nvHorario = in.nextLine();
        
        //verificando horário fornecido(considera apenas horário comercial)
        if(obterHora(nvHorario) < 8 && obterHora(nvHorario) >= 18){
            System.out.println("Horário fornecido é inválido!");
            return;
        }  
        
        //setando horario no dado do tipo Calendar
        cal.set(Calendar.HOUR_OF_DAY, obterHora(nvHorario));
        cal.set(Calendar.MINUTE, obterMinuto(nvHorario));
        
        in = new Scanner(System.in);
        System.out.print("Insira o CPF do novo médico...................: ");
        in = new Scanner(System.in);
        String nvMed = in.nextLine();
        
        //validando existencia de médico
        boolean verMed = false;
        for(int i = 0; i < med.size(); i++){
            if(nvMed.trim().equals(med.get(i).getCpf())){
                verMed = true;
            }
        }
        
        if(!verMed){
            menu.limparTela();
            System.out.println("Médico inválido!\n\nEdição falhou!");
            return;
        }
        
        System.out.print("Insira o tipo da consulta[0: Comum/1: Retorno]: ");
        in = new Scanner(System.in);
        int nvTipoCons = in.nextInt();  
        
        //verificando tipo de consulta
        if(nvTipoCons != 0 && nvTipoCons != 1){
            System.out.println("Tipo de Consulta inválido!\n\nEdição falhou!");
            return;
        }      
        
        //setando novos dados na list de consultas
        cons.get(indexCons).setCpfMed(nvMed);
        cons.get(indexCons).setDatahora(cal);
        cons.get(indexCons).setTipoConsulta(nvTipoCons);    
        
        menu.limparTela();
        System.out.println("Consulta editada com sucesso!");
    }
    
    public void dellConsulta(List<Consulta> cons, List<Medico> med, List<Paciente> pac){
        boolean verCons = false;
        
        //apagando consultas carregadas com null na lista de consultas(estava impactando na impressão das consultas)
        for(int i = 0; i < cons.size(); i++){
            if(cons.get(i) == null){
                cons.remove(i);
            }
        }
        
        System.out.print("Forneça o CPF do Paciente.: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine();
        
        System.out.print("Forneça o CPF do Médico...: ");
        in = new Scanner(System.in);
        String cpfMed = in.nextLine();
        
        menu.limparTela();
        System.out.println("---------------------------------------------------------- RELAÇÃO DE CONSULTA(S) --------------------------------------------------------");
        for(int i = 0; i < cons.size(); i++){
            if((cons.get(i).getCpfPac().trim().equals(cpfPac.trim()) || cons.get(i).getCpfMed().trim().equals(cpfMed)) && cons.get(i) != null){
                verCons = true;
                System.out.print("Cód. Cons.: [" + i + "] - ");
               
                for(int j = 0; j < pac.size(); j++){
                    if(pac.get(j).getCpf().trim().equals(cpfPac.trim())){
                        System.out.print("Paciente: " + pac.get(j).getNome().trim() + " CPF: " + pac.get(j).getCpf().trim() + " - ");
                        break;
                    }
                }
                
                for(int k = 0; k < med.size(); k++){
                    if(med.get(k).getCpf().trim().equals(cpfMed.trim())){
                        System.out.print("Dr(a). " + med.get(k).getNome().trim() + " CRM: " + med.get(k).getCrm().trim() + " - ");
                        break;
                    }
                }
                
                System.out.print("Tipo da consulta: " + (cons.get(i).getTipoConsulta() == 1? "Retorno -" : "Comum -"));  
                System.out.println(" Data da consulta: " + cons.get(i).getDatahora().getTime());
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
        if(!verCons){
            menu.limparTela();
            System.out.println("Nenhuma consulta encontrada para o médico e/ou paciente!");
            return;
        }
        
        System.out.print("Informe o Cód. da Consulta a ser apagada: ");
        in = new Scanner(System.in);
        int indexCons = in.nextInt();
        
        cons.remove(indexCons);
        menu.limparTela();
        System.out.println("Consulta apagada com sucesso!");
    }
    
    public void consDeAmanha(List<Consulta> cons, List<Paciente> pac){
        //manipulando calendar aux para obter data do dia seguinte
        Calendar calendarAux = Calendar.getInstance();
        int diaAux = calendarAux.get(Calendar.DAY_OF_MONTH);
        calendarAux.set(Calendar.DAY_OF_MONTH, diaAux + 1);
        boolean verConsAmanha = false;
        
        //filtrando
        System.out.print("Filtrar pacientes por e-mail?[S/N]: ");
        in = new Scanner(System.in);
        char opcao = in.next().charAt(0);
        
        menu.limparTela();
        //validando se o caractere fornecido é valido
        if(opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n'){
            System.out.println("Opção inválida!\n\nConsulta falhou!");
            return;
        }
        
        //apagando consultas carregadas com null na lista de consultas(estava impactando na impressão das consultas)
        for(int i = 0; i < cons.size(); i++){
            if(cons.get(i) == null){
                cons.remove(i);
            }
        }
        
        System.out.println("----------------------------------------------------- RELAÇÃO DE CONSULTA(S) DE AMANHÃ ---------------------------------------------------");
        //filtrando apenas pelos que possuem e-mail e enviando email de confirmação em seguida
        if(opcao == 'S' || opcao == 's'){
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy"); 
            for(int i = 0; i < cons.size(); i++){
                //convertendo as datas para string
                String convDataAux = s.format(calendarAux.getTime());
                String convDataCons = s.format(cons.get(i).getDatahora().getTime()); 

                //sefor igual a zero é porque as datas são iguais 
                if((convDataAux.trim().compareTo(convDataCons.trim())) == 0){ 
                    verConsAmanha = true;
                    for(int j = 0; j < pac.size(); j++){
                       if(pac.get(j).getCpf().trim().equals(cons.get(i).getCpfPac()) && !pac.get(j).getEmail().trim().equals("")){
                            Email email = new Email();
                            Sms sms = new Sms();
                            
                            //imprimindo consulta
                            System.out.println("Cód. Cons: [" + i + "] | Paciente: " + pac.get(j).getNome() + " CPF: " + pac.get(j).getCpf() + " Data e Hora: " + cons.get(i).getDatahora().getTime() + " Tipo Consulta: " + (cons.get(i).getTipoConsulta() == 1? "Retorno" : "Comum"));
                           
                            //enviando e-mails/sms
                            System.out.println("------------------------------------------------------------- ENVIO DE E-MAIL ------------------------------------------------------------");    
                            email.enviar(pac.get(j).getNome(), convDataCons, pac.get(j).getEmail());
                            System.out.println("--------------------------------------------------------------- ENVIO DE SMS -------------------------------------------------------------");    
                            sms.enviar(pac.get(j).getNome(), convDataCons, pac.get(j).getTelefone());
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                        }
                    }
                }
            }
        }
        
        //como não está filtrando apenas por quem tem e-mail, será listado todos
        if(opcao == 'N' || opcao == 'n'){
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy"); 
            for(int i = 0; i < cons.size(); i++){
                //convertendo as datas para string
                String convDataAux = s.format(calendarAux.getTime());
                String convDataCons = s.format(cons.get(i).getDatahora().getTime()); 

                //sefor igual a zero é porque as datas são iguais 
                if((convDataAux.trim().compareTo(convDataCons.trim())) == 0){
                    verConsAmanha = true;
                    for(int j = 0; j < pac.size(); j++){
                        if(pac.get(j).getCpf().trim().equals(cons.get(i).getCpfPac())){
                            System.out.println("Cód. Cons: [" + i + "] | Paciente: " + pac.get(j).getNome() + " CPF: " + pac.get(j).getCpf() + " Data e Hora: " + cons.get(i).getDatahora().getTime() + " Tipo Consulta: " + (cons.get(i).getTipoConsulta() == 1? "Retorno" : "Comum"));
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                        }
                    }
                }
            }
        }
        if(!verConsAmanha){
            menu.limparTela();
            System.out.println("Nenhuma consulta encontrada para a data de amanhã.");
        }
    }
}
