//BY Marcos Vinicius Peres RA: 94594
package br.uem.din.config.secretaria;

import br.uem.din.config.model.Medico;
import br.uem.din.config.controller.MenuController;
import java.util.List;
import java.util.Scanner;

public class MedicoCrud {

    Scanner in = new Scanner(System.in);
    MenuController menu = new MenuController();

    //METODO RESPONSAVEL PELO CADASTRO DO MEDICO. 
    public Medico cadMedico(List<Medico> medico) {
        Medico med = new Medico();
        Medico medNull = new Medico();

        System.out.println("------------------ * CADASTRAR MEDICO * ------------------");
        System.out.print("Nome............: ");
        in = new Scanner(System.in);
        med.setNome(in.nextLine());
        System.out.print("CPF.............: ");
        in = new Scanner(System.in);
        med.setCpf(in.nextLine());
        System.out.print("RG..............: ");
        in = new Scanner(System.in);
        med.setRg(in.nextLine());
        System.out.print("E-mail..........: ");
        in = new Scanner(System.in);
        med.setEmail(in.nextLine());
        System.out.print("Telefone........: ");
        in = new Scanner(System.in);
        med.setTelefone(in.nextLine());
        System.out.print("Dt. Nasc........: ");
        in = new Scanner(System.in);
        med.setDataNascimento(in.nextLine());
        System.out.print("Endereço........: ");
        in = new Scanner(System.in);
        med.setEndereco(in.nextLine());
        System.out.print("Dt. Admissao....: ");
        in = new Scanner(System.in);
        med.setDataAdmissao(in.nextLine());
        System.out.print("Dt. Demissao....: ");
        in = new Scanner(System.in);
        med.setDataDemissao(in.nextLine());
        System.out.print("CRM.............: ");
        in = new Scanner(System.in);
        med.setCrm(in.nextLine());

        menu.limparTela();
        //VERIFICA SE O MEDICO É DIFERENTE DE NULL E SE SEU CPF OU RG ESTÁ IGUAL, CASO NAO ESTEJA JÁ EXISTE UM CADASTRADO.
        for (int i = 0; i < medico.size(); i++) {
            if (
                    medico != null
                    && (med.getCpf().trim().equals(medico.get(i).getCpf().trim())
                    || med.getRg().trim().equals(medico.get(i).getRg().trim()))
               ) 
            {
                System.out.println("RG ou CPF em duplicidade! Já existe cadastro em nosso sistema!");
                return medNull;
            }
        }

        System.out.println("Medico cadastrado com sucesso!");
        return med;
    }
    
    //METODO QUE IRÁ CONSUTAR UM MEDICO. 
    public void consMedico(List<Medico> med) {
        System.out.print("Informe o CPF do medico: ");
        in = new Scanner(System.in);
        String cpfMed = in.nextLine().trim();
        boolean verExistencia = false;

        menu.limparTela();
        // PERCORRE A LISTA DO MED E VERIFICA SE O CPF DIGITADO É IGUAL O CADASTRADO
        for (int i = 0; i < med.size(); i++) {
            if (med.get(i).getCpf().trim().equals(cpfMed.trim())) {
                System.out.println("----------------- * REGISTROS ENCONTRADOS * ----------------");
                System.out.println("Nome.........: " + med.get(i).getNome().trim());
                System.out.println("CPF..........: " + med.get(i).getCpf().trim());
                System.out.println("RG...........: " + med.get(i).getRg().trim());
                System.out.println("E-mail.......: " + med.get(i).getEmail().trim());
                System.out.println("Telefone.....: " + med.get(i).getTelefone().trim());
                System.out.println("Dt. Nasc.....: " + med.get(i).getDataNascimento().trim());
                System.out.println("Endereco.....: " + med.get(i).getEndereco().trim());
                System.out.println("Dt. Admissao.: " + med.get(i).getDataAdmissao().trim());
                System.out.println("Dt. Demissao.: " + med.get(i).getDataDemissao().trim());
                System.out.println("CRM..........: " + med.get(i).getCrm().trim());
                verExistencia = true;
            }
        }
        
        if (!verExistencia) {
            System.out.println("Medico não cadastrado");
        }
    }
    //METODO QUE EDITA O MEDICO CADASTRADO
    public void editMedico(List<Medico> med) {
        System.out.print("Informe o CPF do medico a ser editado: ");
        String cpfMed = in.nextLine();

        Medico m = new Medico();

        menu.limparTela();
    //VERIFICA SE O CPF DIGITADO É IGUAL O CADASTRADO, SE FOR PRINTA OS DADOS ANTIGOS e SETA EM UM OBJETO NOVO CHAMADO M OS DADOS NOVOS.
        for (int i = 0; i < med.size(); i++) {
            if (med.get(i).getCpf().trim().equals(cpfMed.trim())) {
                System.out.println("--------------- * REGISTRO(S) ENCONTRADO(S) * --------------");
                System.out.println("Nome.........: " + med.get(i).getNome().trim());
                System.out.println("CPF..........: " + med.get(i).getCpf().trim());
                System.out.println("RG...........: " + med.get(i).getRg().trim());
                System.out.println("E-mail.......: " + med.get(i).getEmail().trim());
                System.out.println("Telefone.....: " + med.get(i).getTelefone().trim());
                System.out.println("Dt. Nasc.....: " + med.get(i).getDataNascimento().trim());
                System.out.println("Endereco.....: " + med.get(i).getEndereco().trim());
                System.out.println("Dt. Admissao.: " + med.get(i).getDataAdmissao().trim());
                System.out.println("Dt. Demissao.: " + med.get(i).getDataDemissao().trim());
                System.out.println("CRM..........: " + med.get(i).getCrm().trim());

                System.out.println("---------------------- * DADOS NOVOS * ---------------------");
                System.out.print("Nome.........: ");
                in = new Scanner(System.in);
                m.setNome(in.nextLine());
                System.out.print("CPF..........: ");
                in = new Scanner(System.in);
                m.setCpf(in.nextLine());
                System.out.print("RG...........: ");
                in = new Scanner(System.in);
                m.setRg(in.nextLine());
                System.out.print("E-mail.......: ");
                in = new Scanner(System.in);
                m.setEmail(in.nextLine());
                System.out.print("Telefone.....: ");
                in = new Scanner(System.in);
                m.setTelefone(in.nextLine());
                System.out.print("Dt. Nasc.....: ");
                in = new Scanner(System.in);
                m.setDataNascimento(in.nextLine());
                System.out.print("Endereco.....: ");
                in = new Scanner(System.in);
                m.setEndereco(in.nextLine());
                System.out.print("Dt. Admissao.: ");
                in = new Scanner(System.in);
                m.setDataAdmissao(in.nextLine());
                System.out.print("Dt. Demissao.: ");
                in = new Scanner(System.in);
                m.setDataDemissao(in.nextLine());
                System.out.print("CRM..........: ");
                in = new Scanner(System.in);
                m.setCrm(in.nextLine());

                menu.limparTela();
                //
                for (int j = 0; j < med.size(); j++) {
                    if (j != i //quando os indice j == i, lógico que daria conflito, deste modo so valida quando j != i
                            && (m.getCpf().trim().equals(med.get(j).getCpf().trim()) //se cpf de qualquer posição da lista(exceto i) for igual cpf digitado, então retorna erro de duplicidade
                            || m.getRg().trim().equals(med.get(j).getRg().trim())) //se rg de qualquer posição da lista(exceto i) for igual rg digitado, então retorna erro de duplicidade
                       ) 
                    {
                        System.out.println("RG ou CPF em duplicidade! Já existe cadastro em nosso sistema!\nEditar medico falhou...");
                        return;
                    } 
                }
                //SETA OS DADOS NOVOS 
                med.get(i).setNome(m.getNome());
                med.get(i).setCpf(m.getCpf());
                med.get(i).setRg(m.getRg());
                med.get(i).setEmail(m.getEmail());
                med.get(i).setTelefone(m.getTelefone());
                med.get(i).setDataNascimento(m.getDataNascimento());
                med.get(i).setEndereco(m.getEndereco());
                med.get(i).setDataAdmissao(m.getDataAdmissao());
                med.get(i).setDataDemissao(m.getDataDemissao());
                med.get(i).setCrm(m.getCrm());

                System.out.println("Medico editado com sucesso!");
                return;
            }
        }
        System.out.println("Medico não encontrado!");
    }

    //METODO QUE DELETA O CADASTRO DO MEDICO 
    public void dellMedico(List<Medico> med) {
        System.out.print("Informe o CPF do medico: ");
        in = new Scanner(System.in);
        String cpfMed = in.nextLine().trim();

        menu.limparTela();
        //METODO QUE IRÁ COMPARAR O CPF DIGITADO COM O CADASTRADO E IRÁ REMOVER DA LISTA.
        for (int i = 0; i < med.size(); i++) {
            if (med.get(i).getCpf().trim().equals(cpfMed.trim())) {
                med.remove(i);
                System.out.println("Medico excluído com sucesso!");
            } else {
                System.out.println("Medico não cadastrado");
            }
        }
    }
}
