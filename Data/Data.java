package Data;
import java.util.ArrayList;
import java.util.Scanner;

import Models.CustomerModel;
import Models.HotelModel;

public class Data {

    private static Data instance;
    Scanner sc = new Scanner(System.in);
    private ArrayList<HotelModel> HotelList = new ArrayList<>();
    private ArrayList<CustomerModel> CustomerList = new ArrayList<>();
    private int id = 1,r,TotalHotels=0;
    String name;

    private Data() {}

    public static Data getInstance(){
        if(instance == null)
        {
            instance = new Data();
        }
        return instance;
    }

    public int getTotalHotels() {
        return TotalHotels;
    }

    public ArrayList<HotelModel> getHotelList() {
        return HotelList;
    }

    public void setTotalHotels(int totalHotels) {
        TotalHotels = totalHotels;
    }

    public void PrintHotelList() {
        for(int i=0;i<HotelList.size();i++){
            System.out.println(HotelList.get(i).getId() + "\t" + HotelList.get(i).getName() + "\t" + HotelList.get(i).getTotalRoom());
        }
    }

    public Boolean AddHotel(){
        sc.nextLine();
        System.out.println("Enter Hotel Name :");
        name = sc.nextLine();
        System.out.println("Enter Total rooms :");
        r = sc.nextInt(); 
        HotelModel hm = new HotelModel(id,name,r);
        id++;
        TotalHotels++;
        return HotelList.add(hm);
    }

    public void DelHotel(){
        System.out.println("Enter Hotel Name :");
        name = sc.nextLine();
        Boolean b = HotelList.removeIf(obj -> obj.getName().equals(name) && obj.getAvalRoom() == obj.getTotalRoom());
        System.out.println(b == true ? "Hotel Removed" : "First let Customer do Check Out then Remove Hotel");
        TotalHotels = b ? TotalHotels - 1 : TotalHotels;
    }


    public ArrayList<CustomerModel> getCutomerList(){
        return this.CustomerList;
    }

    public void CustomerListEntry(String Cname,String Hname)
    {
        CustomerList.add(new CustomerModel(Cname, Hname));
    }

    public void CustomerListRemove(String Cname,String Hname)
    {

        System.out.println(CustomerList.removeIf(model -> model.getCutomerName().equals(Cname) && model.getHotelName().equals(Hname)) == true ? "Customer entry Removed" : "Get Error");
    }
}