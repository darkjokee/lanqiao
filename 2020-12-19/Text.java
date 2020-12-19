import  java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        Costomer customer=new Costomer();

        customer.cno=1;
        customer.name="张三";
        customer.password="123456";
        customer.username="zhangsan";

        Order order=new Order();
        order.orderId=1;
        order.orderSp=122;

        customer.order=order;

        Scanner in=new Scanner(System.in);
        String str1=in.next();
        String str2=in.next();

        if(str1=="zhangsan"){
            if(str2=="123456") {
                System.out.println("订单金额：" + customer.order.orderSp);
                System.out.println("订单编号：" + customer.order.orderId);
            }
            else
                System.out.println("密码错误！");
        }
        else System.out.println("用户名不存在！");
    }
}
