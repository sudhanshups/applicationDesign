package parkingLot;


import lombok.Data;

@Data
public abstract class ParkingSpot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private final SpotType type;

    abstract public boolean IsFree();

    public ParkingSpot(SpotType type) {
        this.type = type;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
        return free;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        free = true;
        return free;
    }
}


class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot() {
        super(SpotType.HANDICAPPED);
    }
    public boolean IsFree() {
        return false;
    }
}

class MotorcycleSpot extends ParkingSpot {
    public MotorcycleSpot() {
        super(SpotType.MOTORCYCLE);
    }
    public boolean IsFree() {
        return false;
    }
}

class ElectricSpot extends ParkingSpot {
    public ElectricSpot() {
        super(SpotType.ELECTRIC);
    }
    public boolean IsFree() {
        return false;
    }
}
