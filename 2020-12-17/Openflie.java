import java.io.File;

public class Openflie {
    public static void main(String[] args){
        File file=new File("F:/Misc");
        m1(file);
    }
    static void m1(File file){
        File files[]=file.listFiles();
        for(File f:files){
            m1(file);
            System.out.println(f.getName());
        }
    }
}
