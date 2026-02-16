package Controladores.Editores.EditoresDeInformacoesDosClientes;
import Modelos.ModelosPrincipais.ClienteModel;
import Modelos.Repositorios.ClienteRepository;
import View.ViewDosModelosPrincipais.ClienteView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;
import java.util.Scanner;

public class EditarNomeDoClienteController {
    public static void editarNomeDoCliente() {

        if (ClienteRepository.clientesCadastradosNoSistema.isEmpty()) {
            System.out.println(ClienteView.getNaoHaNenhumClienteCadastradoNoSistema());
        } else {
            Scanner entradaDeDadoos = new Scanner(System.in);

            for (ClienteModel cliente : ClienteRepository.clientesCadastradosNoSistema){
                System.out.println(ClienteView.informacoesDosClientesCadastradosNoSistema(cliente));
                System.out.println(RespostasDoSistemaView.getSeparadorDeItens());
            }

            System.out.println(ClienteView.getOpcaoAlterarNomeDoCliente());
            String idDeClienteEscolhido = entradaDeDadoos.nextLine().trim();

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
                System.out.println(ClienteView.getDigiteONovoNomeDoCliente());
                String novoNomeDoCliente = entradaDeDadoos.nextLine().trim().toUpperCase();

                while (novoNomeDoCliente.isEmpty()){
                    System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                    novoNomeDoCliente = entradaDeDadoos.nextLine().trim().toUpperCase();
                }

                clienteNovo.setNomeDoCliente(novoNomeDoCliente);
                ClienteModel clienteComInformacoesAlterada = clienteNovo;
                System.out.println(ClienteView.revisandoDadosDoCliente(clienteComInformacoesAntigas, clienteComInformacoesAlterada));
                char confirmacaoDaAlteracao = entradaDeDadoos.next().toUpperCase().charAt(0);

                while (confirmacaoDaAlteracao != 'S' &&  confirmacaoDaAlteracao != 'N'){
                    System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                    confirmacaoDaAlteracao = entradaDeDadoos.next().toUpperCase().charAt(0);
                }

                if (confirmacaoDaAlteracao == 'S'){
                    clienteEncontrado.setNomeDoCliente(novoNomeDoCliente);
                    System.out.println(ClienteView.getInformacaoAlteradaComSucesso());
                } else {
                    System.out.println(ClienteView.getAlteracaoDeCadastroCancelada());
                }
            }
        }
    }
}
