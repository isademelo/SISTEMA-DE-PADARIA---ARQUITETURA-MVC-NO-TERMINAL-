package Controladores.Editores.EditoresDeInformacoesDosClientes;
import Modelos.ModelosPrincipais.ClienteModel;
import Modelos.Repositorios.ClienteRepository;
import View.ViewDosModelosPrincipais.ClienteView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;
import java.util.Scanner;

public class EditarEmailDoClienteController {
    public static void  editarEmailDoCliente() {
        if (ClienteRepository.clientesCadastradosNoSistema.isEmpty()) {
            System.out.println(ClienteView.getNaoHaNenhumClienteCadastradoNoSistema());
        } else {
            Scanner entradaDeDados = new Scanner(System.in);

            for (ClienteModel cliente : ClienteRepository.clientesCadastradosNoSistema){
                System.out.println(ClienteView.informacoesDosClientesCadastradosNoSistema(cliente));
                System.out.println(RespostasDoSistemaView.getSeparadorDeItens());
            }

            System.out.println(ClienteView.getOpcaoAlterarEmailDoCliente());
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
                System.out.println(ClienteView.getDigiteONovoEmailDoCliente());
                String novoEmailDoCliente = entradaDeDados.nextLine().trim().toLowerCase();

                boolean emailJaExiste;

                do {
                    emailJaExiste= false;
                    for (ClienteModel cliente : ClienteRepository.clientesCadastradosNoSistema) {
                        if (cliente.getEmailDoCliente().equals(novoEmailDoCliente)) {
                            emailJaExiste = true;
                            break;
                        }
                    }

                    if (novoEmailDoCliente.isEmpty() || !novoEmailDoCliente.contains("@") || novoEmailDoCliente.startsWith("@") || novoEmailDoCliente.endsWith("@")) {
                        System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                        novoEmailDoCliente = entradaDeDados.nextLine().trim().toLowerCase();
                    } else if (emailJaExiste) {
                        System.out.println(ClienteView.getClienteComEsseEmailJaFoiCadastradoNoSistema());
                        novoEmailDoCliente = entradaDeDados.nextLine().trim().toLowerCase();
                    }
                } while (novoEmailDoCliente.isEmpty() || !novoEmailDoCliente.contains("@") || novoEmailDoCliente.startsWith("@") || novoEmailDoCliente.endsWith("@") || emailJaExiste);

                clienteNovo.setEmailDoCliente(novoEmailDoCliente);
                ClienteModel clienteComInformacoesAlterada = clienteNovo;

                System.out.println(ClienteView.revisandoDadosDoCliente(clienteComInformacoesAntigas, clienteComInformacoesAlterada));
                char confirmacaoDaAlteracao = entradaDeDados.next().toUpperCase().charAt(0);

                while (confirmacaoDaAlteracao != 'S' &&  confirmacaoDaAlteracao != 'N'){
                    System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                    confirmacaoDaAlteracao = entradaDeDados.next().toUpperCase().charAt(0);
                }

                if (confirmacaoDaAlteracao == 'S'){
                    clienteEncontrado.setEmailDoCliente(novoEmailDoCliente);
                    System.out.println(ClienteView.getInformacaoAlteradaComSucesso());
                } else {
                    System.out.println(ClienteView.getAlteracaoDeCadastroCancelada());
                }
            }
        }
    }
}
