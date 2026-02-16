package Controladores.Remoções;
import Modelos.ModelosPrincipais.ClienteModel;
import Modelos.Repositorios.ClienteRepository;
import View.ViewDosModelosPrincipais.ClienteView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;
import java.util.Scanner;

public class RemoverClientesController {
    public static void removerClientes (){

        if (ClienteRepository.clientesCadastradosNoSistema.isEmpty()){
            System.out.println(ClienteView.getNaoHaNenhumClienteCadastradoNoSistema());
        } else {
            Scanner entradaDeDadosDoCliente = new Scanner (System.in);

            System.out.println(ClienteView.getCabecalhoRemoverClientesDoSistema());
            System.out.println(ClienteView.getDigiteONomeDoClienteQueVaiSerRemovidoDoSistema());
            String clienteEscolhido = entradaDeDadosDoCliente.nextLine().trim();

            while (clienteEscolhido.isEmpty()){
                System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                clienteEscolhido = entradaDeDadosDoCliente.nextLine().trim();
            }

            ClienteModel clienteEncontrado = null;

            for (ClienteModel cliente : ClienteRepository.clientesCadastradosNoSistema){
                if (clienteEscolhido.equalsIgnoreCase(cliente.getNomeDoCliente())) {
                    clienteEncontrado = cliente;
                    break;
                }
            }

            if (clienteEncontrado == null){
                System.out.println(ClienteView.getNaoEncontramosNenhumClienteComEssaInformacao());
                return;
            }

            System.out.println(ClienteView.informacoesDosClientesCadastradosNoSistema(clienteEncontrado));
            System.out.println(ClienteView.getClienteQueVaiSerRemovidoFoiEncotnrado());
            char confirmarRemocaoDoCliente = entradaDeDadosDoCliente.nextLine().toUpperCase().charAt(0);

            while (confirmarRemocaoDoCliente != 'S' && confirmarRemocaoDoCliente != 'N'){
                System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                confirmarRemocaoDoCliente = entradaDeDadosDoCliente.nextLine().toUpperCase().charAt(0);
            }

            if(confirmarRemocaoDoCliente == 'S'){
                ClienteRepository.clientesCadastradosNoSistema.remove(clienteEncontrado);
                System.out.println(ClienteView.getUsuarioRemovidoComSucesso());
            } else if (confirmarRemocaoDoCliente == 'N'){
                System.out.println(ClienteView.getaRemocaoDoClienteFoiCancelada());
            }
        }
    }
}
