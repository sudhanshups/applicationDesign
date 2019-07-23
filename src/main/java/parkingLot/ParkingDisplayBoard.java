package parkingLot;

import lombok.Data;

@Data
public class ParkingDisplayBoard {
    private String id;
    private ParkingSpot handicappedFreeSpot;
    private ParkingSpot electricFreeSpot;


    public void showEmptySpotNumber() {
        String message = "";
        if (handicappedFreeSpot.IsFree()) {
            message += "Free Handicapped: " + handicappedFreeSpot.getNumber();
        } else {
            message += "Handicapped is full";
        }
        message += System.lineSeparator();

        if (electricFreeSpot.IsFree()) {
            message += "Free Electric: " + electricFreeSpot.getNumber();
        } else {
            message += "Electric is full";
        }

        System.out.println(message);
    }

    ParkingSpot getHandicappedFreeSpot(){
        return handicappedFreeSpot;
    }
    void setHandicappedFreeSpot(ParkingSpot p){
        handicappedFreeSpot= p;
    }

}