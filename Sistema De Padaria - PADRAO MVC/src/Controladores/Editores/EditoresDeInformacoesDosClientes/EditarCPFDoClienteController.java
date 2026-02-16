package Controladores.Editores.EditoresDeInformacoesDosClientes;

import Modelos.ModelosPrincipais.ClienteModel;
import Modelos.Repositorios.ClienteRepository;
import View.ViewDosModelosPrincipais.ClienteView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;

import java.util.Scanner;

public class EditarCPFDoClienteController {
    public static void  editarCPFDoCliente() {

        if (ClienteRepository.clientesCadastradosNoSistema.isEmpty()) {
            System.out.println(ClienteView.getNaoHaNenhumClienteCadastradoNoSistema());
        } else {
            Scanner entradaDeDados = new Scanner(System.in);

            for (ClienteModel cliente : ClienteRepository.clientesCadastradosNoSistema){
                System.out.println(ClienteView.informacoesDosClientesCadastradosNoSistema(cliente));
                System.out.println(RespostasDoSistemaView.getSeparadorDeItens());
            }

            System.out.println(ClienteView.getOpcaoAlterarCPFDoCliente());
            String idDeClienteEscolhido = entradaDeDados.nextLine().trim();

            ClienteModel clienteEncontrado = null;
            ClienteModel clienteComInformacoesAntigas = null;

            for (ClienteModel cliente :  ClienteRepository.clientesCadastradosNoSistema){
                if (idDeClienteEscolhido.equals(cliente.getIdDoCliente())) {
                    clienteEncontrado = cliente;
                    clienteComInformacoesAntigas = cliente;
                    break;
                }
            }

            if (clienteEncontrado == null){
                System.out.println(ClienteView.getNaoEncontramosNenhumClienteComEssaInformacao());
            } else {
                ClienteModel clienteNovo = new ClienteModel();
                clienteNovo.setEmailDoCliente(clienteEncontrado.getEmailDoCliente());
                clienteNovo.setNomeDoCliente(clienteEncontrado.getNomeDoCliente());
                clienteNovo.setCpfDoCliente(clienteEncontrado.getCpfDoCliente());
                clienteNovo.setTelefoneDoCliente(clienteEncontrado.getTelefoneDoCliente());
                clienteNovo.setIdDoCliente(clienteEncontrado.getIdDoCliente());

                System.out.println(ClienteView.getoClienteFoiEncontradoNoSistema());
                System.out.println(ClienteView.informacoesDosClientesCadastradosNoSistema(clienteEncontrado));
                System.out.println(ClienteView.getDigiteONovoCPFDoCliente());
                String novoCPFDoCliente = entradaDeDados.nextLine().trim().toUpperCase();

                boolean cpfJaExiste;

                do {
                    cpfJaExiste = false;

                    for (ClienteModel cliente : ClienteRepository.clientesCadastradosNoSistema) {
                        if (cliente.getCpfDoCliente().equals(novoCPFDoCliente)) {
                            cpfJaExiste = true;
                            break;
                        }
                    }

                    if (novoCPFDoCliente.isEmpty()|| novoCPFDoCliente.length() != 11) {
                        System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                        novoCPFDoCliente = entradaDeDados.nextLine().trim().replaceAll("\\D", "");
                    } else if (cpfJaExiste) {
                        System.out.println(ClienteView.getClienteComEsseCpfJaFoiCadastradoNoSistema());
                        novoCPFDoCliente =  entradaDeDados.nextLine().trim().replaceAll("\\D", "");
                    }

                } while (novoCPFDoCliente.isEmpty() || novoCPFDoCliente.length() != 11 || cpfJaExiste);

                clienteNovo.setCpfDoCliente(novoCPFDoCliente);
                ClienteModel clienteComInformacoesAlterada = clienteNovo;

                System.out.println(ClienteView.revisandoDadosDoCliente(clienteComInformacoesAntigas, clienteComInformacoesAlterada));
                char confirmacaoDaAlteracao = entradaDeDados.next().toUpperCase().charAt(0);

                while (confirmacaoDaAlteracao != 'S' &&  confirmacaoDaAlteracao != 'N'){
                    System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                    confirmacaoDaAlteracao = entradaDeDados.next().toUpperCase().charAt(0);
                }

                if (confirmacaoDaAlteracao == 'S'){
                    clienteEncontrado.setCpfDoCliente(novoCPFDoCliente);
                    System.out.println(ClienteView.getInformacaoAlteradaComSucesso());
                } else {
                    System.out.println(ClienteView.getAlteracaoDeCadastroCancelada());
                }
            }
        }
    }
}
