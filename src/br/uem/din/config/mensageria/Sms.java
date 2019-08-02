//BY Marcos Vinicius Peres RA: 94594
package br.uem.din.config.mensageria;

public class Sms extends Mensagem{ 
    //METODO ABSTRATO CHAMADA LÁ DA CLASSE EXTENDIDA MENSAGEM.
    @Override
    public void enviar(String nome, String data, String endereco) {
        System.out.println("                       Destinatário: " + endereco);
        System.out.println("                        --------------------------------------Consulta Amanhã-------------------------------------------------");
        System.out.println("                       |   Venho por meio deste SMS, avisa-lo sobre a consulta do Sr.(a): " + nome);
        System.out.println("                       |   Que está marcada para o dia: " + data);
        System.out.println("                       |   Tente não atrasar !!!                                                                              ");
        System.out.println("                       |   A clinica SaudeECia agradece a sua compreensão...                                                  ");
        System.out.println("                        ------------------------------------------------------------------------------------------------------");
    }  
}
