import java.util.ArrayList;

public class Pedido {
    Cliente cliente;
    ArrayList<ItemPedido> items;
    double taxaServico = 10;

    public Pedido(String NomeCliente){
        cliente = new Cliente(NomeCliente);
        items = new ArrayList<>();
    }
}
