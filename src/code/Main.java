package code;
import java.util.Scanner;
import code.Package;
import code.*;
import com.sun.security.jgss.GSSUtil;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Package Weight:");
        int weight = scanner.nextInt();
        Package pkg = new Package(weight);
        boolean isEnd = false;
        int choice;
        while(! isEnd){
            System.out.println("Choose between these two shipping choices and enter the NUMBER only:\n" +
                    "1: standard shipping\n 2: express shipping ");
            choice = scanner.nextInt();
            if(choice==1){
                pkg.setShipping(new StandardShipping());
            }
            else{
                pkg.setShipping(new ExpressShipping());
            }
            System.out.println("Choose if package should be delivered:\n1:Delivered\n2: stay in transit");
            choice = scanner.nextInt();
            if (choice==1){
                isEnd = true;
                pkg.send();
            }
            pkg.getState().printState();
        }

    }
}
