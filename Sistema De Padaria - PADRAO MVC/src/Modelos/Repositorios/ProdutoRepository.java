package Modelos.Repositorios;
import Modelos.ModelosPrincipais.ProdutoModel;
import View.ViewDosModelosPrincipais.CardapioView;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    public static ArrayList<ProdutoModel> listaDeProdutos = new ArrayList<ProdutoModel>();
    private static int contadorId = 1;

    public static List<ProdutoModel> listarTodos() {
        return listaDeProdutos;
    }

    public static boolean estaVazio() {
        return listaDeProdutos.isEmpty();
    }

    public static void adicionarProdutos(ProdutoModel produto){
        produto.setIdDoProduto(contadorId++);
        listaDeProdutos.add(produto);
    }



}
