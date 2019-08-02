//by Luiz Flávio Pereira ra91706
package br.uem.din.config.controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class MenuController {
    Scanner in = new Scanner(System.in);
    
    public void limparTela() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
            System.out.println("Erro ao limpar tela!");
        }
    }
    
    public int showMenuPermissao(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("       1) Entrar com perfil de secretária(o).");
        System.out.println("       2) Entrar com perfil de médica(o).");
        System.out.println("       0) Sair.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("Selecione uma opção: ");
        in = new Scanner(System.in);
        int opcao = in.nextInt();
        
        //caso digite uma opcao inválida sistema valida e retorna menu
        if(opcao != 1 && opcao != 2 && opcao != 0){
            limparTela();
            System.out.println("Opção inválida!");
            showMenuPermissao();
        }
        
        return opcao;
    }
    
    public int showMenuSecretaria(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("       01) Cadastrar Paciente.");
        System.out.println("       02) Consultar Paciente.");
        System.out.println("       03) Alterar Paciente.");
        System.out.println("       04) Deletar Paciente.");
        System.out.println("       05) Cadastrar Médico.");
        System.out.println("       06) Consultar Médico.");
        System.out.println("       07) Alterar Médico.");
        System.out.println("       08) Deletar Médico.");
        System.out.println("       09) Cadastrar Consulta.");
        System.out.println("       10) Consultar Consulta.");
        System.out.println("       11) Alterar Consulta.");
        System.out.println("       12) Deletar Consulta.");
        System.out.println("       13) Consultas de amanhã.");
        System.out.println("       99) Voltar ao menu inicial.");
        System.out.println("       00) Sair.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("Selecione uma opção: ");
        in = new Scanner(System.in);
        int opcao = in.nextInt();
        
        return opcao;
    }
    
    public int showMenuMedico(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("       01) Cadastrar dados adicionais.");
        System.out.println("       02) Consultar dados adicionais.");
        System.out.println("       03) Alterar dados adicionais.");
        System.out.println("       04) Deletar dados adicionais.");
        System.out.println("       05) Cadastrar prontuario.");
        System.out.println("       06) Consultar prontuario.");
        System.out.println("       07) Alterar prontuario.");
        System.out.println("       08) Deletar Prontuario.");       
        System.out.println("       09) Gerar Receita.");
        System.out.println("       10) Gerar Atestado.");
        System.out.println("       11) Gerar Atestado Acompanhante.");
        System.out.println("       12) Atendimentos do mês.");
        System.out.println("       99) Voltar ao menu inicial.");
        System.out.println("       00) Sair.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("Selecione uma opção: ");
        in = new Scanner(System.in);
        int opcao = in.nextInt();
        
        return opcao;
    }
}
