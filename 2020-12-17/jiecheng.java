public class jiecheng {
    public static void main(String[] args){
        int i,a=8;
        System.out.println(cheng(a));
    }
    public static int cheng(int s){
        int sum=1;
        for (int i=2;i<=s;i++)
            sum=sum*i;
        return sum;
    }
}


