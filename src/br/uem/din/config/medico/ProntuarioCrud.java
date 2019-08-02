//BY Marcos Vinicius Peres RA: 94594
package br.uem.din.config.medico;

import br.uem.din.config.model.Prontuario;
import br.uem.din.config.model.Medico;
import br.uem.din.config.model.Paciente;
import br.uem.din.config.controller.MenuController;
import java.util.List;
import java.util.Scanner;

public class ProntuarioCrud {
    Scanner in = new Scanner(System.in);
    MenuController menu = new MenuController();

    //METODO QUE CADASTRA UM PRONTUARIO
    public Prontuario cadProntuario(List<Paciente> pac, List<Medico> med) {
        Prontuario prontuario = new Prontuario();
        boolean verPac = false;
        boolean verMed = false;

        System.out.print("Forneça o CPF do Paciente: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine();

        System.out.print("Forneça o CPF do Médico..: ");
        in = new Scanner(System.in);
        String cpfMed = in.nextLine();
        
        //VERIFICA SE O CPF DIGITADO É IGUAL O CADASTRADO E SETA TRUE NO VER PAC
        for (int i = 0; i < pac.size(); i++) {
            if (pac.get(i).getCpf().trim().equals(cpfPac.trim())) {
                verPac = true;
                break;
            }
        }
        //VERIFICA SE O CPF DIGITADO É IGUAL O CADASTRADO E SETA TRUE NO VERMED
        for (int i = 0; i < med.size(); i++) {
            if (med.get(i).getCpf().trim().equals(cpfMed.trim())) {
                verMed = true;
                break;
            }
        }

        menu.limparTela();
        if (!verPac) {
            System.out.println("Paciente não encontrado!");
            return prontuario;
        }

        if (!verMed) {
            System.out.println("Médico não encontrado!");
            return prontuario;
        }

        menu.limparTela();
        // SE O VERMED E VERPAC FOR VERDADEIRO SETA O CADASTRO DO PRONTUARIO
        if (verMed && verPac) {
            
            System.out.println("--------------------- * CADASTRAR PRONTUARIO * -------------------");
            System.out.print("Diagnostico...: ");
            in = new Scanner(System.in);
            prontuario.setDiagnostico(in.nextLine());
            System.out.print("Medicamentos..: ");
            in = new Scanner(System.in);
            prontuario.setMedicamentos(in.nextLine());
            System.out.print("Data..........: ");
            in = new Scanner(System.in);
            prontuario.setData(in.nextLine());
            System.out.print("Hora inicio...: ");
            in = new Scanner(System.in);
            prontuario.setHoraInicio(in.nextLine());
            System.out.print("Hora final....: ");
            in = new Scanner(System.in);
            prontuario.setHoraFinal(in.nextLine());
            prontuario.setCpfMed(cpfMed);
            prontuario.setCpfPac(cpfPac);

            menu.limparTela();
            System.out.println("Prontuario preenchidos com sucesso!");

        }
        
        if (!verMed && !verPac) {
            System.out.println("Prontuario não encontrado!");
        }
        return prontuario;
    }

    //METODO DE CONSULTAR O PRONTUARIO
    public void consProntuario(List<Prontuario> pro) {
        boolean verPac = false;
        boolean verMed = false;

        System.out.print("Forneça o CPF do Paciente: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine();

        System.out.print("Forneça o CPF do Médico..: ");
        in = new Scanner(System.in);
        String cpfMed = in.nextLine();

        //VERIFICA SE AMBOS DIGITADOS SÃO IGUAIS OS CPF'S CADASTRADOS
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
        
        //PERCORRE A LISTA DO PRONTUARIO E VERIFICA SE OS DOIS CPF ESTÃO CERTO, SE FOR PRINTA O PRONTUARIO
        for (int i = 0; i < pro.size(); i++) {
            if (pro.get(i).getCpfPac().equals(cpfPac) && pro.get(i).getCpfMed().equals(cpfMed)) {

                System.out.println("--------DADOS DO PRONTUARIO-------------");
                System.out.println("Cod. Prontuario: " + i);
                System.out.println("Diagnostico....: " + pro.get(i).getDiagnostico());
                System.out.println("Medicamentos...: " + pro.get(i).getMedicamentos());
                System.out.println("Data...........: " + pro.get(i).getData());
                System.out.println("Hora Inicio....: " + pro.get(i).getHoraInicio());
                System.out.println("Hora Final.....: " + pro.get(i).getHoraFinal());

            }
        }
        if (!verMed && !verPac) {
            System.out.println("Prontuario não encontrado!");
        }

    }

    //METODO QUE EDITA O PRONTUARIO
    public void editProntuario(List<Prontuario> pro) {
        Prontuario p = new Prontuario();
        boolean verPac = false;
        boolean verMed = false;
        boolean verPro = false;
        int aux = 0;

        System.out.print("Forneça o CPF do Paciente: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine();

        System.out.print("Forneça o CPF do Médico..: ");
        in = new Scanner(System.in);
        String cpfMed = in.nextLine();

        //VERIFICA SE AMBOS DIGITADOS SÃO IGUAIS OS CPF'S CADASTRADOS
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

        //FAZ A VERIFICAÇÃO USANDO OU, CASO UM DOS DOIS ESTIVEREM CERTO SETA VERPRO = TRUE E MOSTRA OS DADOS ANTIGOS
        for (int i = 0; i < pro.size(); i++) {
            if (pro.get(i).getCpfPac().equals(cpfPac) || pro.get(i).getCpfMed().equals(cpfMed)) {
                verPro = true;
                System.out.println("----------------------------------------------------DADOS ANTIGOS(S)----------------------------------------------------------");
                System.out.println("Cod. Prontuario: [" + i + "] - ");
                System.out.println("Diagnostico...: " + pro.get(i).getDiagnostico());
                System.out.println("Medicamentos..: " + pro.get(i).getMedicamentos());
                System.out.println("Data..........: " + pro.get(i).getData());
                System.out.println("Hora Inicio...: " + pro.get(i).getHoraInicio());
                System.out.println("Hora Final....: " + pro.get(i).getHoraFinal());
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");

            }
            if (!verPro) {
                menu.limparTela();
                System.out.println("Nenhum prontuario encontrado para o medico e/ou paciente");
            }
        }

        System.out.print("Informe o Cód. do Prontuario a ser alterado: ");
        int indexPro = in.nextInt();
        menu.limparTela();
        //GUARDA UM INDEX PRO, QUE SERA O COD. DO PRONTUARIO E IRA VER SE NAQUELE INDEX PRO O CPFPAC E CPFMED É IGUAL O QUE FOI DIGITADO A CIMA, TAMBÉM O INDEX TEM QUE SER DIFERENTE DE NULO
        if ((pro.get(indexPro).getCpfPac().trim().equals(cpfPac) && pro.get(indexPro).getCpfMed().trim().equals(cpfMed)) && pro.get(indexPro) != null) {
            //PERCORRE A LISTA PRO E SETA OS DADOS NOVOS NO OBJETO p
            for (int i = 0; i < pro.size(); i++) {
                if (pro.get(i).getCpfPac().equals(cpfPac) && pro.get(i).getCpfMed().equals(cpfMed)) {
                    System.out.println("--------------------- * DADOS NOVOS * ---------------------");
                    in = new Scanner(System.in);
                    System.out.print("Diagnostico...: ");
                    in = new Scanner(System.in);
                    p.setDiagnostico(in.nextLine());
                    System.out.print("Medicamentos..: ");
                    in = new Scanner(System.in);
                    p.setMedicamentos(in.nextLine());
                    System.out.print("Data..........: ");
                    in = new Scanner(System.in);
                    p.setData(in.nextLine());
                    System.out.print("Hora inicio...: ");
                    in = new Scanner(System.in);
                    p.setHoraInicio(in.nextLine());
                    System.out.print("Hora final....: ");
                    in = new Scanner(System.in);
                    p.setHoraFinal(in.nextLine());

                    menu.limparTela();
                    for (int j = 0; j < pro.size(); j++) {
                        if (
                                pro != null //se pac for null então nem valida(não há registros na List<Paciente>)
                                && j != i //quando os indice j == i, lógico que daria conflito, deste modo so valida quando j != i
                                && (p.getCpfPac().trim().equals(pro.get(j).getCpfPac().trim()) //se cpf de qualquer posição da lista(exceto i) for igual cpf digitado, então retorna erro de duplicidade
                                || p.getCpfMed().trim().equals(pro.get(j).getCpfMed().trim())) //se rg de qualquer posição da lista(exceto i) for igual rg digitado, então retorna erro de duplicidade
                            ) 
                        {
                            System.out.println("cpfPac ou cpfMed em duplicidade! Já existe cadastro em nosso sistema!\nEditar prontuario falhou...");
                            return;
                        } else {
                            //se não encontrar nenhum cpf/rg em duplicidade então é realizado as trocas de valores
                            pro.get(i).setDiagnostico(p.getDiagnostico());
                            pro.get(i).setMedicamentos(p.getMedicamentos());
                            pro.get(i).setData(p.getData());
                            pro.get(i).setHoraInicio(p.getHoraInicio());
                            pro.get(i).setHoraFinal(p.getHoraFinal());

                        }
                    }
                    System.out.println("Prontuario editado com sucesso!");
                    return;
                }
            }
            System.out.println("Prontuario não encontrado!");
        }
    }

    public void dellProntuario(List<Paciente> pac, List<Medico> med, List<Prontuario> pro) {
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
        //VALIDA O CPF E PRINTA NA TELA AS OPCOES DE PRONTUARIO QUE DESEJA DELETAR
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
        //GUARDA NO INDEXPRO O COD PRONTUARIO QUE SERA DELETADO E REMOVE ELE DA LISTA 
        System.out.print("Informe o Cód. do Prontuario a ser apagado: ");
        in = new Scanner(System.in);
        int indexPro = in.nextInt();
        
        
        pro.remove(indexPro);
        menu.limparTela();
        System.out.println("Prontuario apagado com sucesso");
    }
}
