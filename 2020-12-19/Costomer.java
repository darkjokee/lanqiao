import java.util.List;

public class Costomer {
    int cno;
    String name;
    String username;
    String password;
    Order order;
}

class Order{
    int orderId;
    int orderSp;
    List<Costomer>pathorder;
}
