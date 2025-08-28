package model;
import Enums.*;


public class Order {
    private static int nextId = 1;

    private int id;
    private String customer;
    private OrderStatus status;
    private OrderPriority priority;
    private PaymentMethod paymentMethod;

    public Order( String customer, OrderStatus status, OrderPriority priority, PaymentMethod paymentMethod) {
        this.id = nextId++;
        this.customer = customer;
        this.status = status;
        this.priority = priority;
        this.paymentMethod = paymentMethod;
    }

    public void showDetails() {
        System.out.println("Pedido #" + id);
        System.out.println("Cliente: " + customer);
        System.out.println("Estado: " + status.name() + " -> " + status.getMessage());
        System.out.println("Prioridad: " + priority.name() + " (Nivel " + priority.getLevel() + ")");
        System.out.println("Método de pago: " + paymentMethod.name() + " → " + paymentMethod.getDescripcion());
        System.out.println();
    }
}
