package parkingLot;


class Person {
    private String name;
    private String address;
    private String email;
    private String phone;
}

abstract class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;

    public boolean resetPassword() {
        return true;
    }
}

class ParkingAttendant extends Account {
    public boolean processTicket(String TicketNumber) {
        return true;
    }

}


class Admin extends Account {

    public boolean addParkingFloor(ParkingFloor floor) {
        return true;
    }

    public boolean addParkingSpot(String floorName, ParkingSpot spot) {
        return true;
    }

    public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard) {
        return true;
    }

    public boolean addCustomerInfoPanel(String floorName, CustomerInfoPortal infoPanel) {
        return true;
    }

    public boolean addEntrancePanel(EntrancePanel entrancePanel) {
        return true;
    }

    public boolean addExitPanel(ExitPanel exitPanel) {
        return true;
    }
}

/*
class System {
    List<ParkingFloor> floors;
    String lineSeparator(){
        return "|";
    }
}*/
