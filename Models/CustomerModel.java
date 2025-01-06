package Models;
public class CustomerModel {
    private String CutomerName,HotelName;

    public String getCutomerName() {
        return CutomerName;
    }

    public CustomerModel(String cutomerName, String hotelName) {
        CutomerName = cutomerName;
        HotelName = hotelName;
    }

    public void setCutomerName(String cutomerName) {
        CutomerName = cutomerName;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }
}
