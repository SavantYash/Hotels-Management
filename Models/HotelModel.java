package Models;
import java.util.ArrayList;

public class HotelModel{
    private String Name;
    private ArrayList<String> Cname = null;

    public void addCustomer(String Name,HotelModel obj){
        obj.Cname.add(Name);
        obj.AvalRoom--;
    }

    public void delCustomer(String Name,HotelModel obj){
        if(obj.Cname.contains(Name))
        {
            obj.Cname.remove(Name);
            obj.AvalRoom++;
            System.out.println("Check out of " + Name + " done from " + obj.Name);
        }else{
            System.out.println(Name + " doesn't check in in " + obj.Name);
        }
    }

    private int TotalRoom=0,AvalRoom=0,id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HotelModel(String name) {
        Name = name;
    }
    
    public HotelModel(int id,String name, int totalRoom) {
        this.id = id;
        this.Name = name;
        this.TotalRoom = totalRoom;
        AvalRoom = totalRoom;
        Cname = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public int getTotalRoom() {
        return TotalRoom;
    }
    public void setTotalRoom(int totalRoom) {
        this.TotalRoom = totalRoom;
    }
    public int getAvalRoom() {
        return AvalRoom;
    }
    public void setAvalRoom(int aval9Room) {
        this.AvalRoom = aval9Room;
    }

    public ArrayList<String> getCname() {
        return Cname;
    }
}