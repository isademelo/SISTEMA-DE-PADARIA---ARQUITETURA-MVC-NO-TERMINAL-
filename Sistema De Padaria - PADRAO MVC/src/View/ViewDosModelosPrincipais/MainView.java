package View.ViewDosModelosPrincipais;

public class MainView {
    static private String menuPrincipal = """
            =======================================================
                                 MENU PRINCIPAL
            =======================================================
            
            1 - CADASTRAR PRODUTOS
            2 - VISUALIZAR CARDÁPIO
            3 - CRIAR PEDIDO
            4 - CADASTRAR CLIENTE
            5 - LISTAR TODOS OS CLIENTES
            6 - REMOVER CLIENTE
            7 - REMOVER PRODUTO
            8 - EDITAR INFORMAÇÕES DOS CLIENTES
            9 - EDITAR INFORMAÇÕES DOS PRODUTOS
            10 - SAIR
            
            Escolha uma opção:""";

    public static String getMenuPrincipal() {
        return menuPrincipal;
    }

}
