package Enums;

public enum OrderStatus{
    NEW("Pedido creado"),
    PROCESSING("Pedido en proceso"),
    SHIPPED("Pedido enviado"),
    DELIVERED("Pedido entregado"),
    CANCELLED("Pedido candelado");
    
    private final String message;

    OrderStatus(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}