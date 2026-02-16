package Controladores.Listagens;
import Modelos.ModelosPrincipais.ClienteModel;
import Modelos.Repositorios.ClienteRepository;
import View.ViewDosModelosPrincipais.ClienteView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;

import java.util.List;

public class ListarClientesCadastradosController {
    public static void listarClientesCadastradosNoSistema(){
        List<ClienteModel> clientes = ClienteRepository.listarTodos();
        System.out.println(ClienteView.getCabecalhoListarTodosOsClientesCadastradosNoSistema());

        if(clientes.isEmpty()){
            System.out.println(ClienteView.getNaoHaNenhumClienteCadastradoNoSistema());
        } else {
            for (ClienteModel cliente : clientes) {
                System.out.println(ClienteView.informacoesDosClientesCadastradosNoSistema(cliente));
                System.out.println(RespostasDoSistemaView.getSeparadorDeItens());
            }
        }
    }
}