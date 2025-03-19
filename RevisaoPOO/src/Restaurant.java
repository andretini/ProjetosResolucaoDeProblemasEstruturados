import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    Scanner scanner;
    Cardapio cardapio;

    int menuIdx;
    boolean sair = false;

    public Restaurant() {
        scanner = new Scanner(System.in);
        cardapio = preencherCardapio();
    }

    public Cardapio preencherCardapio(){
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Lasanha",           67.99));
        items.add(new Item("Macarronada",       45.99));
        items.add(new Item("Bife a Parmegiana", 78.99));

        Cardapio card = new Cardapio(items);
        return card;
    }

    public void init(){
        while (!sair){
            System.out.println("Restaurante Legal");
            System.out.println("\n");

            System.out.println("1 -> Fazer Pedido");
            System.out.println("2 -> Sair");
            menuIdx = scanner.nextInt();

            switch (menuIdx){
                case 1:
                    fazerPedido();
                    break;
                case 2:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção não disponível, Escolha Novamente ");
                    break;
            }

            System.out.println("\n");
        }
    }

    private void fazerPedido(){
        System.out.println("\n");
        System.out.println("Restaurante Legal");
          System.out.println("Fazer Pedido");
        System.out.println("\n");

        System.out.println("Digite o seu Nome");
        Pedido pedido = new Pedido(scanner.next());
        System.out.print("\n");

        System.out.printf("Olá %s\n",  pedido.cliente.nome);
        System.out.println("De uma olhada no nosso cardápio");

        int ans;

        do {

            int index = 0;
            for (Item item : cardapio.items) {
                System.out.printf("%d -> %s  |  %.2f\n", index++, item.nome, item.preco);
            }

            System.out.println("Deseja adicionar algo?");

            System.out.println("1- Adicionar?");
            System.out.println("0- Finalizar Pedido");

            ans = scanner.nextInt();

            if (ans == 1){
                System.out.println("Digite o número do Item");
                int itemIdx = scanner.nextInt();
                System.out.println("Digite a Quantidade");
                int quantidade = scanner.nextInt();

                pedido.items.add(new ItemPedido(cardapio.items.get(itemIdx), quantidade));
            }
            else if(ans != 0){
                System.out.println("Opção Inválida");
            }
        } while (ans != 0);

        double soma = 0;

        System.out.println("\n");
        System.out.println("Nota Fiscal");
        System.out.println("Itens");

        for (ItemPedido item : pedido.items) {
            System.out.printf(" -> %s | %d | %.2f | %.2f\n", item.item.nome, item.Quantidade, item.item.preco, item.item.preco * item.Quantidade);
            soma += item.item.preco * item.Quantidade;
        }
        System.out.printf("Subtotal: %.2f \n", soma);

        double total = soma + (soma * (pedido.taxaServico / 100));
        System.out.printf("Total + Taxa de Serviço: %.2f \n", total);

        double dinheiroRecebido = 0;
        do {
            System.out.println("Digite o dinheiro dado pelo Cliente");
            dinheiroRecebido = scanner.nextDouble();

            if (dinheiroRecebido < total){
                System.out.println("Dinheiro Insuficiente");
            }
        }
        while (dinheiroRecebido < total);

        System.out.printf("Troco do Cliente; %.2f", dinheiroRecebido - total);

    }
}
