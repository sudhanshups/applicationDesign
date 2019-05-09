package parkingLot;



abstract class Vehicle {
    private String licenseNumber;
    private final VehicleType type;
    private ParkingTicket ticket;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }

    abstract VehicleType getVehicleType();
}

class Car extends Vehicle {
    public Car(VehicleType type) {
        super(type);
    }

    @Override
    VehicleType getVehicleType() {
        return VehicleType.CAR;
    }
}
