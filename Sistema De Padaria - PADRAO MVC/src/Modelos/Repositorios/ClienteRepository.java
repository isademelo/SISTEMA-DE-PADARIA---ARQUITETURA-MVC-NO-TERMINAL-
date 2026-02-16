package Modelos.Repositorios;
import Modelos.ModelosPrincipais.ClienteModel;
import View.ViewDosModelosPrincipais.ClienteView;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    public static ArrayList<ClienteModel> clientesCadastradosNoSistema = new ArrayList<ClienteModel>();

    public static List<ClienteModel> listarTodos() {
        return clientesCadastradosNoSistema;
    }

    public static boolean estaVazio() {
        return clientesCadastradosNoSistema.isEmpty();
    }

    public static String buscarPorCpf(String cpf) {
        for (ClienteModel cliente : clientesCadastradosNoSistema) {
            if (cliente.getCpfDoCliente().equals(cpf)) {
                return ClienteView.informacoesDosClientesCadastradosNoSistema(cliente);
            }
        }
        return null;
    }

    public static void adicionarClientes(ClienteModel cliente){
        clientesCadastradosNoSistema.add(cliente);
    }

    public static void removerClientes (ClienteModel cliente){
        clientesCadastradosNoSistema.remove(cliente);
    }
}
