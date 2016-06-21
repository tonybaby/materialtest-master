package materialtest.vivz.slidenerd.extras;

/**
 * Created by HP on 3/18/2016.
 */
public class StoreDetailsTaxiServices {

    //Data Variables
    private String imageName;
    private String vehicleType;
    private String seatingCapacity;
    private String ratePerDay;
    private String ratePerAdditionalKm;
    private String allowedKmPerDay;

    //Getters and Setters
    public String getImageName() {
       // Log.i("img","http://192.168.178.1/keralaTourism/images/" + imageUrl);
        return  imageName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getSeatingCapacity() {
        return seatingCapacity;
    }

    public String getRatePerDay() {
        return ratePerDay;
    }

    public String getRatePerAdditionalKm() {
        return ratePerAdditionalKm;
    }

    public String getAllowedKmPerDay() {
        return allowedKmPerDay;
    }


    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setSeatingCapacity(String seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public void setRatePerDay(String ratePerDay) {
        this.ratePerDay = ratePerDay;
    }

    public void setRatePerAdditionalKm(String ratePerAdditionalKm) {
        this.ratePerAdditionalKm = ratePerAdditionalKm;
    }

    public void setAllowedKmPerDay(String allowedKmPerDay) {
        this.allowedKmPerDay = allowedKmPerDay;
    }

//    public static Comparator<StoreDetailsTaxiServices> priceAsc = new Comparator<StoreDetailsTaxiServices>() {
//        @Override
//        public int compare(StoreDetailsTaxiServices lhs, StoreDetailsTaxiServices rhs) {
//            return lhs.getPrice().compareTo(rhs.getPrice());
//        }
//    };
//
//    public static Comparator<StoreDetailsTaxiServices> priceDesc = new Comparator<StoreDetailsTaxiServices>() {
//        @Override
//        public int compare(StoreDetailsTaxiServices lhs, StoreDetailsTaxiServices rhs) {
//            return rhs.getPrice().compareTo(lhs.getPrice());
//        }
//    };
//
//    public static Comparator<StoreDetailsTaxiServices> daysDesc = new Comparator<StoreDetailsTaxiServices>() {
//        @Override
//        public int compare(StoreDetailsTaxiServices lhs, StoreDetailsTaxiServices rhs) {
//            return rhs.getDuration().compareTo(lhs.getDuration());
//        }
//    };
//
//    public static Comparator<StoreDetailsTaxiServices> daysAsc = new Comparator<StoreDetailsTaxiServices>() {
//        @Override
//        public int compare(StoreDetailsTaxiServices lhs, StoreDetailsTaxiServices rhs) {
//            return lhs.getDuration().compareTo(rhs.getDuration());
//        }
//    };
}
