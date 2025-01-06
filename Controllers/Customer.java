package Controllers;
import java.util.*;

import Data.Data;
import Models.HotelModel;

public class Customer {
    Scanner sc = new Scanner(System.in);
    Data d = Data.getInstance();
    ArrayList<HotelModel> hm = d.getHotelList();
    int ch,ch1,flag=0,i,id,flag1;
    HotelModel dummyHotelModel;

    public void ManageCustomer() {
        do{
            System.out.println("\n\t1.Check In\n\t2.Check Out\n\t3.Go Back");
            System.out.println("Enter ur choice: ");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1 :
                    id = this.getId();
                    this.CheckIn(id);
                    break;
                case 2:
                    this.CheckOut(this.getDetails(),this.getId());
                    break;
                case 4:
                    for(int i=0;i<hm.size();i++){
                        System.out.println(hm.get(i).getCname());
                    }
            }
        }while(ch!=3);
    }
    
    void CheckIn(int id){
        for(i=0;i<hm.size();i++){
            dummyHotelModel = hm.get(i);
            if(dummyHotelModel.getId() == id)
            {
                if(dummyHotelModel.getAvalRoom() == 0)
                {
                    System.out.println("Hotel is full");
                    flag1 = 1;
                    break;
                }
                else
                {
                    String n = getDetails();
                    dummyHotelModel.addCustomer(n,dummyHotelModel);
                    flag=1;
                    System.out.println(flag==0 ? "Hotel Not Exist with this id try again" : "Check In Done in Hotel " + hm.get(i).getName());
                    d.CustomerListEntry(n,hm.get(i).getName());
                    flag = 0;
                    flag1 = 1;
                    break;
                }
            }
        }
        if(flag1 == 0){
            System.out.println("Hotel doesn't exists");
        }
        flag1 = 0;
    }

    void CheckOut(String Name,int id){
        for(i=0;i<hm.size();i++){
            dummyHotelModel = hm.get(i);
            if(dummyHotelModel.getId() == id)
            {
                if(dummyHotelModel.getAvalRoom() == dummyHotelModel.getTotalRoom())
                {
                    System.out.println("Hotel is empty");
                    break;
                }
                else
                {
                    dummyHotelModel.delCustomer(Name,dummyHotelModel);
                    d.CustomerListRemove(Name, dummyHotelModel.getName());
                    flag1 = 1;
                    break;
                }
            }
        }
        if(flag1 == 0){
            System.out.println("Hotel doesn't exists");
        }
        flag1 = 0;
    }

    String getDetails(){
        sc.nextLine();
        System.out.println("Enter Name : ");
        return sc.nextLine();
    }

    int getId(){
        System.out.println("---Hotel List---");
        for(int i=0;i<hm.size();i++){
            System.out.println(hm.get(i).getId() + "\t" + hm.get(i).getName() + "\t" + hm.get(i).getAvalRoom());
        }
        System.out.println("Choose id of Hotel");
        return sc.nextInt();
    }
}
