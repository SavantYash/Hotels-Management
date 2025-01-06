package Controllers;
import java.util.*;

import Data.Data;
import Models.CustomerModel;
import Models.HotelModel;
public class Manage {
    Scanner sc = new Scanner(System.in);
    Data d = Data.getInstance();
    private ArrayList<HotelModel> hm = d.getHotelList();
    private ArrayList<CustomerModel> cl;
    int ch;
    public void ManageHotels(){
        do{
            System.out.println("\n\t1.Add Hotel\n\t2.Show Hotels\n\t3.Remove Hotel\n\t4.Customer List\n\t5.Go Back");
            System.out.println("Enter ur choice: ");
            ch = sc.nextInt();
            switch(ch)
            {
                //Add Hotels
                case 1 :
                    System.out.println( d.AddHotel() ? "Data Added" : "Error Occured");
                    break;
                case 2:
                //print List of Hotels
                    for(int i=0;i<hm.size();i++){
                        HotelModel hm1 = hm.get(i);
                        System.out.println(hm1.getId() + "\t" + hm1.getName() + "\t" + hm1.getTotalRoom() + "\t" + hm1.getAvalRoom());
                    }
                    System.out.println("\nTotal : " + d.getTotalHotels());
                    break;
                case 3:
                //Remove Hotel
                    d.DelHotel();
                    break;
                //get Check IN List
                case 4:
                    cl = d.getCutomerList();
                    for(int i=0;i<cl.size();i++){
                        CustomerModel hm1 = cl.get(i);
                        System.out.println(hm1.getCutomerName() + "\t" +  hm1.getHotelName());
                    }
                    System.out.println("Total Check In : " + cl.size());

                default:
                System.out.println("wrong choice.\n Enter Again");
            }
        }while(ch!=5);
    }
}
