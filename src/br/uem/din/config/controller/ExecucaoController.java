//by Luiz Flávio Pereira ra91706
package br.uem.din.config.controller;

import br.uem.din.config.medico.DadosAdcCrud;
import br.uem.din.config.model.Consulta;
import br.uem.din.config.secretaria.ConsultaCrud;
import br.uem.din.config.model.Medico;
import br.uem.din.config.secretaria.MedicoCrud;
import br.uem.din.config.model.Paciente;
import br.uem.din.config.secretaria.PacienteCrud;
import br.uem.din.config.model.Prontuario;
import br.uem.din.config.medico.ProntuarioCrud;
import br.uem.din.config.medico.RelatoriosMedico;
import java.util.List;

public class ExecucaoController {
    MenuController menu = new MenuController();
    
    public void menusExecucao(List<Medico> medico, List<Paciente> paciente, List<Prontuario> prontuario, List<Consulta> consulta) {
        int permissao = menu.showMenuPermissao();
        
        //trecho que trata a execucao com permissao de secretária(o)
        if (permissao == 1) {
            menu.limparTela();
            PacienteCrud crudPac = new PacienteCrud();
            MedicoCrud crudMed = new MedicoCrud();
            ConsultaCrud crudCons = new ConsultaCrud();
            
            int opcao = menu.showMenuSecretaria();
            while (opcao != 0) {
                menu.limparTela();
                switch (opcao) {
                    case 1:
                        paciente.add(crudPac.cadPaciente(paciente));
                        break;
                    case 2:
                        crudPac.consPaciente(paciente);
                        break;
                    case 3:
                        crudPac.editPaciente(paciente);
                        break;
                    case 4:
                        crudPac.dellPaciente(paciente);
                        break;
                    case 5:
                        medico.add(crudMed.cadMedico(medico));        
                        break;
                    case 6:
                        crudMed.consMedico(medico);
                        break;
                    case 7:
                        crudMed.editMedico(medico);
                        break;
                    case 8:
                        crudMed.dellMedico(medico);
                        break;
                    case 9:
                        consulta.add(crudCons.cadConsulta(paciente, medico));
                        break;
                    case 10:
                        crudCons.consConsulta(consulta, medico, paciente);
                        break;
                    case 11:
                        crudCons.editConsulta(consulta, medico, paciente);
                        break;
                    case 12:
                        crudCons.dellConsulta(consulta, medico, paciente);
                        break;
                    case 13:
                        crudCons.consDeAmanha(consulta, paciente);
                        break;   
                    case 99:
                        menusExecucao(medico, paciente, prontuario, consulta);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                opcao = menu.showMenuSecretaria();
            }
        } else {
            //trecho que trata a execucao com permissao de médico(o)    
            if (permissao == 2) {
                menu.limparTela();
                PacienteCrud crudPac = new PacienteCrud();
                ProntuarioCrud crudPront = new ProntuarioCrud();
                RelatoriosMedico relMed = new RelatoriosMedico();
                DadosAdcCrud crudDadosAdc = new DadosAdcCrud();
                
                int opcao = menu.showMenuMedico();
                while (opcao != 0) {
                    menu.limparTela();
                    switch (opcao) {
                        case 1:
                            crudDadosAdc.cadPacienteDadosAdc(paciente);
                            break;
                        case 2:
                            crudPac.consPaciente(paciente);
                            break;
                        case 3:
                            crudDadosAdc.editPacienteDadosAdc(paciente);
                            break;
                        case 4:
                            crudDadosAdc.dellPacienteDadosAdc(paciente);
                            break;
                        case 5:
                            prontuario.add(crudPront.cadProntuario(paciente, medico));
                            break;
                            case 6: 
                             crudPront.consProntuario(prontuario);
                            break;
                        case 7: 
                            crudPront.editProntuario(prontuario);
                            break;
                        case 8:
                            crudPront.dellProntuario(paciente, medico, prontuario);
                            break;
                        case 9:
                            relMed.receita(paciente, medico, prontuario);
                            break;
                        case 10:
                            relMed.atestado(prontuario, paciente, medico);
                            break;
                        case 11:
                            relMed.atestadoAcompanhante(paciente, medico, prontuario);
                            break;
                            case 12:
                            relMed.atendidoMes(medico, consulta);
                            break;
                        case 99:
                            menusExecucao(medico, paciente, prontuario, consulta);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                    opcao = menu.showMenuMedico();
                }
            }
        }
    }
}
