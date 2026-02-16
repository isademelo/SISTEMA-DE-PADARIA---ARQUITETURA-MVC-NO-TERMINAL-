package Controladores.Editores.EditoresDeInformacoesDosClientes;
import Modelos.ModelosPrincipais.ClienteModel;
import Modelos.Repositorios.ClienteRepository;
import View.ViewDosModelosPrincipais.ClienteView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;
import java.util.Scanner;

public class EditarTelefoneDoClienteController {
    public static void  editarTelefoneDoCliente() {
        if (ClienteRepository.clientesCadastradosNoSistema.isEmpty()) {
            System.out.println(ClienteView.getNaoHaNenhumClienteCadastradoNoSistema());
        } else {
            Scanner entradaDeDados = new Scanner(System.in);

            for (ClienteModel cliente : ClienteRepository.clientesCadastradosNoSistema){
                System.out.println(ClienteView.informacoesDosClientesCadastradosNoSistema(cliente));
                System.out.println(RespostasDoSistemaView.getSeparadorDeItens());
            }

            System.out.println(ClienteView.getOpcaoAlterarTelefoneDoCliente());
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
                System.out.println(ClienteView.getDigiteONovoTelefoneDoCliente());
                String novoTelefoneDoCliente = entradaDeDados.nextLine().trim().toLowerCase();

                boolean telefoneJaExiste;

                do {
                    telefoneJaExiste = false;
                    for (ClienteModel cliente : ClienteRepository.clientesCadastradosNoSistema) {
                        if (cliente.getTelefoneDoCliente().equals(novoTelefoneDoCliente)) {
                            telefoneJaExiste = true;
                            break;
                        }
                    }

                    if (novoTelefoneDoCliente.isEmpty() || novoTelefoneDoCliente.length() != 11) {
                        System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                        novoTelefoneDoCliente = entradaDeDados.nextLine().trim().replaceAll("\\D", "");
                    } else if (telefoneJaExiste) {
                        System.out.println(ClienteView.getClienteComEsseTelefoneJaFoiCadastradoNoSistema());
                        novoTelefoneDoCliente = entradaDeDados.nextLine().trim().replaceAll("\\D", "");
                    }
                } while (novoTelefoneDoCliente.isEmpty() || telefoneJaExiste || novoTelefoneDoCliente.length() != 11);

                clienteNovo.setTelefoneDoCliente(novoTelefoneDoCliente);
                ClienteModel clienteComInformacoesAlterada = clienteNovo;
                System.out.println(ClienteView.revisandoDadosDoCliente(clienteComInformacoesAntigas, clienteComInformacoesAlterada));
                char confirmacaoDaAlteracao = entradaDeDados.next().toUpperCase().charAt(0);

                while (confirmacaoDaAlteracao != 'S' &&  confirmacaoDaAlteracao != 'N'){
                    System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                    confirmacaoDaAlteracao = entradaDeDados.next().toUpperCase().charAt(0);
                }

                if (confirmacaoDaAlteracao == 'S'){
                    clienteEncontrado.setTelefoneDoCliente(novoTelefoneDoCliente);
                    System.out.println(ClienteView.getInformacaoAlteradaComSucesso());
                } else {
                    System.out.println(ClienteView.getAlteracaoDeCadastroCancelada());
                }
            }
        }
    }
}
