//BY Marcos Vinicius Peres RA: 94594
package br.uem.din.config.medico;

import br.uem.din.config.controller.MenuController;
import br.uem.din.config.model.Paciente;
import java.util.List;
import java.util.Scanner;

public class DadosAdcCrud {
    MenuController menu = new MenuController();
    Scanner in = new Scanner(System.in);
    
    //método para cadastramento de dados adicionais(apenas médico possui acesso)
    public void cadPacienteDadosAdc(List<Paciente> pac) {
        System.out.print("Informe o CPF do paciente: ");
        String cpfPac = in.nextLine().trim();
        boolean verExistencia = false;

        menu.limparTela();
        //percorrendo list para encontrar o registro desejado
        for (int i = 0; i < pac.size(); i++) {
            if (pac.get(i).getCpf().trim().equals(cpfPac.trim())) {
                //apresentando dados do paciente

                System.out.println("--------------------- * RESPONDA [S/N] * -------------------");
                System.out.print("Fuma?.............: ");
                in = new Scanner(System.in);
                pac.get(i).setFuma(in.next().charAt(0));
                System.out.print("Bebe?.............: ");
                in = new Scanner(System.in);
                pac.get(i).setBebe(in.next().charAt(0));
                System.out.print("Colesterol?.......: ");
                in = new Scanner(System.in);
                pac.get(i).setColesterol(in.next().charAt(0));
                System.out.print("Diabetes?.........: ");
                in = new Scanner(System.in);
                pac.get(i).setDiabetes(in.next().charAt(0));
                System.out.print("Alergias?.........: ");
                in = new Scanner(System.in);
                pac.get(i).setAlergias(in.next().charAt(0));
                System.out.print("Problema Cardiaco?: ");
                in = new Scanner(System.in);
                pac.get(i).setProbCardiaco(in.next().charAt(0));
                System.out.print("Cirurgias?........: ");
                in = new Scanner(System.in);
                pac.get(i).setCirurgia(in.next().charAt(0));

                menu.limparTela();
                System.out.println("Dados adicionais preenchidos com sucesso!");
                verExistencia = true;
            }
        }
        
        if (!verExistencia) {
            System.out.println("Paciente não encontrado!");
        }

    }

    public void editPacienteDadosAdc(List<Paciente> pac) {
        System.out.print("Informe o CPF do paciente a ser editado: ");
        String cpfPac = in.nextLine();

        //atributo utilizado para obtenção dos novos dados emporariamente
        Paciente p = new Paciente();

        menu.limparTela();
        //percorrendo list para encontrar o registro desejado
        for (int i = 0; i < pac.size(); i++) {
            if (pac.get(i).getCpf().trim().equals(cpfPac.trim())) {
                //apresentando dados antigos à secretaria
                System.out.println("-------------------- * DADOS ANTERIORES * ------------------");
                System.out.println("Fuma?........: " + pac.get(i).getFuma());
                System.out.println("Bebe?........: " + pac.get(i).getBebe());
                System.out.println("Colesterol?..: " + pac.get(i).getColesterol());
                System.out.println("Diabetes?....: " + pac.get(i).getDiabetes());
                System.out.println("Alergias?....: " + pac.get(i).getAlergias());
                System.out.println("Pr.Cardíaco?.: " + pac.get(i).getProbCardiaco());
                System.out.println("Cirurgias?...: " + pac.get(i).getCirurgia());

                //solicitando digitação de novos dados
                System.out.println("---------------------- * DADOS NOVOS * ---------------------");
                System.out.println("--------------------- * RESPONDA [S/N] * -------------------");
                System.out.print("Fuma?........: ");
                in = new Scanner(System.in);
                p.setFuma(in.next().charAt(0));
                System.out.print("Bebe?........: ");
                in = new Scanner(System.in);
                p.setBebe(in.next().charAt(0));
                System.out.print("Colesterol?..: ");
                in = new Scanner(System.in);
                p.setColesterol(in.next().charAt(0));
                System.out.print("Diabetes?....: ");
                in = new Scanner(System.in);
                p.setDiabetes(in.next().charAt(0));
                System.out.print("Alergias?....: ");
                in = new Scanner(System.in);
                p.setAlergias(in.next().charAt(0));
                System.out.print("Pr.Cardíaco?.: ");
                in = new Scanner(System.in);
                p.setProbCardiaco(in.next().charAt(0));
                System.out.print("Cirurgias?...: ");
                in = new Scanner(System.in);
                p.setCirurgia(in.next().charAt(0));

                menu.limparTela();
                for (int j = 0; j < pac.size(); j++) {
                    if (
                            pac != null //se pac for null então nem valida(não há registros na List<Paciente>)
                            && j != i //quando os indice j == i, lógico que daria conflito, deste modo so valida quando j != i
                            && (p.getCpf().trim().equals(pac.get(j).getCpf().trim()) //se cpf de qualquer posição da lista(exceto i) for igual cpf digitado, então retorna erro de duplicidade
                            || p.getRg().trim().equals(pac.get(j).getRg().trim())) //se rg de qualquer posição da lista(exceto i) for igual rg digitado, então retorna erro de duplicidade
                        ) 
                    {
                        System.out.println("RG ou CPF em duplicidade! Já existe cadastro em nosso sistema!\nEditar paciente adcionais falhou...");
                        return;
                    }
                }
                
                //alterando dados adicionais
                pac.get(i).setFuma(p.getFuma());
                pac.get(i).setBebe(p.getBebe());
                pac.get(i).setColesterol(p.getColesterol());
                pac.get(i).setDiabetes(p.getDiabetes());
                pac.get(i).setAlergias(p.getAlergias());
                pac.get(i).setProbCardiaco(p.getProbCardiaco());
                pac.get(i).setCirurgia(p.getCirurgia());
                
                System.out.println("Paciente editado com sucesso!");
                return;
            }
        }
        System.out.println("Paciente não encontrado!");
    }

    public void dellPacienteDadosAdc(List<Paciente> pac) {
        System.out.print("Informe o CPF do paciente a ser editado: ");
        in = new Scanner(System.in);
        String cpfPac = in.nextLine();

        menu.limparTela();
        //percorrendo list para encontrar o registro desejado
        for (int i = 0; i < pac.size(); i++) {
            if (pac.get(i).getCpf().trim().equals(cpfPac.trim())) {
                pac.get(i).setFuma('-');
                pac.get(i).setBebe('-');
                pac.get(i).setColesterol('-');
                pac.get(i).setDiabetes('-');
                pac.get(i).setAlergias('-');
                pac.get(i).setProbCardiaco('-');
                pac.get(i).setCirurgia('-');
                System.out.println("Dados adicionais apagados com sucesso!");
                return;
            }
        }
        System.out.println("Paciente não encontrado!");
    }  
}
