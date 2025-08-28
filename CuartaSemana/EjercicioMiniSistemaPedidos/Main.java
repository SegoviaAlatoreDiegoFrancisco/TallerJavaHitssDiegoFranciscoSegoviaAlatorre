
import Enums.*;
import model.Order;

public class Main {
    public static void main(String[] args) {
        Order pedido1 = new Order( "Ana", OrderStatus.NEW, OrderPriority.HIGH, PaymentMethod.CARD);
        Order pedido2 = new Order( "Luis", OrderStatus.SHIPPED, OrderPriority.MEDIUM, PaymentMethod.CASH);
        Order pedido3 = new Order( "Marta", OrderStatus.DELIVERED, OrderPriority.LOW, PaymentMethod.TRANSFER);

        pedido1.showDetails();
        pedido2.showDetails();
        pedido3.showDetails();
    }
}
