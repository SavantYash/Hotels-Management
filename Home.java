import java.util.*;

import Controllers.Customer;
import Controllers.Manage;
class Home{
    public static void main(String[] args) {
        try{
        int ch;
        Scanner sc = new Scanner(System.in);
        Customer c = new Customer();
        Manage m = new Manage();

            do{
            System.out.println("\n\t1.Manage\n\t2.Check In/Out\n\t3.Exit\n");
            System.out.println("Enter ur choice: ");
            ch = sc.nextInt();
            sc.nextLine();
            
            switch(ch)
            {
                case 1 :
                    m.ManageHotels();
                    break;
                case 2:
                    c.ManageCustomer();;
                    break;
                
                    default:
                    System.out.println("wrong choice.\nEnter Again");
                    
            }
        }while(ch!=3);
        sc.close();}
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}