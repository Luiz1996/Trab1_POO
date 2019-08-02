//by Luiz Flávio Pereira ra91706
package br.uem.din.config.secretaria;

import br.uem.din.config.model.Paciente;
import br.uem.din.config.controller.MenuController;
import java.util.List;
import java.util.Scanner;

public class PacienteCrud {
    Scanner in = new Scanner(System.in);
    MenuController menu = new MenuController();

    public Paciente cadPaciente(List<Paciente> paciente) {
        Paciente pac = new Paciente();
        Paciente pacNull = new Paciente();

        //solicitando preenchimento de novos dados à secretaria
        System.out.println("------------------ * CADASTRAR PACIENTE * ------------------");
        System.out.print("NOME......: ");
        in = new Scanner(System.in);
        pac.setNome(in.nextLine());
        System.out.print("CPF.......: ");
        in = new Scanner(System.in);
        pac.setCpf(in.nextLine());
        System.out.print("RG........: ");
        in = new Scanner(System.in);
        pac.setRg(in.nextLine());
        System.out.print("E-mail....: ");
        in = new Scanner(System.in);
        pac.setEmail(in.nextLine());
        System.out.print("Telefone..: ");
        in = new Scanner(System.in);
        pac.setTelefone(in.nextLine());
        System.out.print("Dt. Nasc..: ");
        in = new Scanner(System.in);
        pac.setDataNascimento(in.nextLine());
        in = new Scanner(System.in);
        System.out.print("Convênio..: ");
        in = new Scanner(System.in);
        pac.setConvenio(in.nextLine());
        System.out.print("Endereço..: ");
        in = new Scanner(System.in);
        pac.setEndereco(in.nextLine());
        pac.setFuma('-');
        pac.setBebe('-');
        pac.setColesterol('-');
        pac.setDiabetes('-');
        pac.setAlergias('-');
        pac.setProbCardiaco('-');
        pac.setCirurgia('-');

        menu.limparTela();
        //se já existir cliente com mesmo CPF/RG então o cadastro é abortado
        for (int i = 0; i < paciente.size(); i++) {
            if (    
                    paciente != null
                    && (pac.getCpf().trim().equals(paciente.get(i).getCpf().trim())
                    || pac.getRg().trim().equals(paciente.get(i).getRg().trim()))
               ) 
            {
                System.out.println("RG ou CPF em duplicidade! Já existe cadastro em nosso sistema!");
                return pacNull;
            }
        }
        //se a execução chegar até esse ponto é porque o cadastro foi efetuado e nenhuma ilegalidade (cpf/rg suplicado) foi encontrado
        System.out.println("Paciente cadastrado com sucesso!");
        return pac;
    }

    public void consPaciente(List<Paciente> pac) {
        System.out.print("Informe o CPF do paciente: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine().trim();
        boolean verExistencia = false;

        menu.limparTela();
        //percorrendo list para encontrar o registro desejado
        for (int i = 0; i < pac.size(); i++) {
            if (pac.get(i).getCpf().trim().equals(cpfPac.trim())) {
                //apresentando dados do paciente
                System.out.println("--------------- * REGISTRO(S) ENCONTRADO(S) * --------------");
                System.out.println("Nome.........: " + pac.get(i).getNome().trim());
                System.out.println("CPF..........: " + pac.get(i).getCpf().trim());
                System.out.println("RG...........: " + pac.get(i).getRg().trim());
                System.out.println("E-mail.......: " + pac.get(i).getEmail().trim());
                System.out.println("Telefone.....: " + pac.get(i).getTelefone().trim());
                System.out.println("Dt. Nasc.....: " + pac.get(i).getDataNascimento().trim());
                System.out.println("Convênio.....: " + pac.get(i).getConvenio().trim());
                System.out.println("Endereço.....: " + pac.get(i).getEndereco().trim());
                System.out.println("Fuma?........: " + pac.get(i).getFuma());
                System.out.println("Bebe?........: " + pac.get(i).getBebe());
                System.out.println("Colesterol?..: " + pac.get(i).getColesterol());
                System.out.println("Diabetes?....: " + pac.get(i).getDiabetes());
                System.out.println("Alergias?....: " + pac.get(i).getAlergias());
                System.out.println("Pr.Cardíaco?.: " + pac.get(i).getProbCardiaco());
                System.out.println("Cirurgias?...: " + pac.get(i).getCirurgia());
                verExistencia = true;
            }
        }
        
        if (!verExistencia) {
            System.out.println("Paciente não encontrado!");
        }
    }

    public void editPaciente(List<Paciente> pac) {
        System.out.print("Informe o CPF do paciente a ser editado: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine();

        //atributo utilizado para obtenção dos novos dados emporariamente
        Paciente p = new Paciente();

        menu.limparTela();
        //percorrendo list para encontrar o registro desejado
        for (int i = 0; i < pac.size(); i++) {
            if (pac.get(i).getCpf().trim().equals(cpfPac.trim())) {
                //apresentando dados antigos à secretaria
                System.out.println("-------------------- * DADOS ANTERIORES * ------------------");
                System.out.println("Nome.....: " + pac.get(i).getNome().trim());
                System.out.println("CPF......: " + pac.get(i).getCpf().trim());
                System.out.println("RG.......: " + pac.get(i).getRg().trim());
                System.out.println("E-mail...: " + pac.get(i).getEmail().trim());
                System.out.println("Telefone.: " + pac.get(i).getTelefone().trim());
                System.out.println("Dt. Nasc.: " + pac.get(i).getDataNascimento().trim());
                System.out.println("Convênio.: " + pac.get(i).getConvenio().trim());
                System.out.println("Endereço.: " + pac.get(i).getEndereco().trim());

                //solicitando digitação de novos dados
                System.out.println("---------------------- * DADOS NOVOS * ---------------------");
                System.out.print("Nome.....: ");
                in = new Scanner(System.in);
                p.setNome(in.nextLine());
                System.out.print("CPF......: ");
                in = new Scanner(System.in);
                p.setCpf(in.nextLine());
                System.out.print("RG.......: ");
                in = new Scanner(System.in);
                p.setRg(in.nextLine());
                System.out.print("E-mail...: ");
                in = new Scanner(System.in);
                p.setEmail(in.nextLine());
                System.out.print("Telefone.: ");
                in = new Scanner(System.in);
                p.setTelefone(in.nextLine());
                System.out.print("Dt. Nasc.: ");
                in = new Scanner(System.in);
                p.setDataNascimento(in.nextLine());
                System.out.print("Convênio.: ");
                in = new Scanner(System.in);
                p.setConvenio(in.nextLine());
                System.out.print("Endereço.: ");
                in = new Scanner(System.in);
                p.setEndereco(in.nextLine());

                menu.limparTela();
                //se já existir cliente com mesmo CPF/RG então o edicao é abortada
                for (int j = 0; j < pac.size(); j++) {
                    if (
                            j != i //quando os indice j == i, lógico que daria conflito, deste modo so valida quando j != i
                            && (p.getCpf().trim().equals(pac.get(j).getCpf().trim()) //se cpf de qualquer posição da lista(exceto i) for igual cpf digitado, então retorna erro de duplicidade
                            || p.getRg().trim().equals(pac.get(j).getRg().trim())) //se rg de qualquer posição da lista(exceto i) for igual rg digitado, então retorna erro de duplicidade
                        ) 
                    {
                        System.out.println("RG ou CPF em duplicidade! Já existe cadastro em nosso sistema!\nEditar paciente falhou...");
                        return;
                    }
                }
                //alterando os dados do paciente
                pac.get(i).setNome(p.getNome());
                pac.get(i).setCpf(p.getCpf());
                pac.get(i).setRg(p.getRg());
                pac.get(i).setEmail(p.getEmail());
                pac.get(i).setDataNascimento(p.getDataNascimento());
                pac.get(i).setConvenio(p.getConvenio());
                pac.get(i).setTelefone(p.getTelefone());
                pac.get(i).setEndereco(p.getEndereco());
                
                System.out.println("Paciente editado com sucesso!");
                return;
            }
        }
        System.out.println("Paciente não encontrado!");
    }

    //método para deleção de um paciente
    public void dellPaciente(List<Paciente> pac) {
        boolean verPac = false;
        
        System.out.print("Informe o CPF do paciente: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine().trim();

        menu.limparTela();
        //percorrendo list para encontrar o registro desejado
        for (int i = 0; i < pac.size(); i++) {
            if (pac.get(i).getCpf().trim().equals(cpfPac.trim())) {
                //removendo registro encontrado
                pac.remove(i);
                System.out.println("Paciente excluído com sucesso!");
                verPac = true;
            }
            
            if(!verPac){
                System.out.println("Paciente não encontrado!");
            }
        }
    }
}
