package Modelos.Repositorios;

import Modelos.ModelosPrincipais.PedidoModel;

import java.util.ArrayList;

public class PedidosRepository {
    private static ArrayList<PedidoModel> pedidosFeitos = new ArrayList<>();

    public static ArrayList<PedidoModel> listarTodosOsPedidos(){
        for (PedidoModel pedido : pedidosFeitos) {
            return pedidosFeitos;
        }
        return null;
    }
}
