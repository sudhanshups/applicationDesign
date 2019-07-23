package parkingLot;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;

public class ParkingLot {
    private String name;
    private String address;
    private ParkingRate parkingRate;

    private int compactSpotCount;
    private int largeSpotCount;
    private int motorbikeSpotCount;
    private int electricSpotCount;

    private final int maxCompactCount = 10;
    private final int maxLargeCount = 10;
    private final int maxMotorbikeCount = 10;
    private final int maxElectricCount = 10;

    private HashMap<String, EntrancePanel> entrancePanels;
    private HashMap<String, ExitPanel> exitPanels;
    private HashMap<String, ParkingFloor> parkingFloors;

    // all active parking tickets, identified by their ticketNumber
    private HashMap<String, ParkingTicket> activeTickets;

    // singleton ParkingLot to ensure only one object of ParkingLot in the system,
    // all entrance panels will use this object to create new parking ticket: getNewParkingTicket(),
    // similarly exit panels will also use this object to close parking tickets
    private static ParkingLot parkingLot = null;

    // private constructor to restrict for singleton
    private ParkingLot() {
        // 1. initialize variables: read name, address and parkingRate from database
        // 2. initialize parking floors: read the parking floor map from database,
        //  this map should tell how many parking spots are there on each floor. This
        //  should also initialize max spot counts too.
        // 3. initialize parking spot counts by reading all active tickets from database
        // 4. initialize entrance and exit panels: read from database
    }

    // static method to get the singleton instance of StockExchange
    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    // note that the following method is 'synchronized' to allow multiple entrances
    // panels to issue a new parking ticket without interfering with each other
    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException {
        if (this.isFull(vehicle.getVehicleType())) {
            throw new ParkingFullException();
        }
        ParkingTicket ticket = new ParkingTicket();
        vehicle.assignTicket(ticket);
        //ticket.saveInDB();
        // if the ticket is successfully saved in the database, we can increment the parking spot count
        this.incrementSpotCount(vehicle.getVehicleType());
        this.activeTickets.put(ticket.getTicketNumber(), ticket);
        return ticket;
    }

    public boolean isFull(VehicleType type) {
        // trucks and vans can only be parked in LargeSpot
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            return largeSpotCount >= maxLargeCount;
        }

        // motorbikes can only be parked at motorbike spots
        if (type == VehicleType.MOTORCYCLE) {
            return motorbikeSpotCount >= maxMotorbikeCount;
        }

        // cars can be parked at compact or large spots
        if (type == VehicleType.CAR) {
            return (compactSpotCount + largeSpotCount) >= (maxCompactCount + maxLargeCount);
        }

        // electric car can be parked at compact, large or electric spots
        return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount
                + maxElectricCount);
    }

    // increment the parking spot count based on the vehicle type
    private boolean incrementSpotCount(VehicleType type) {
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            largeSpotCount++;
        } else if (type == VehicleType.MOTORCYCLE) {
            motorbikeSpotCount++;
        } else if (type == VehicleType.CAR) {
            if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        } else { // electric car
            if (electricSpotCount < maxElectricCount) {
                electricSpotCount++;
            } else if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        }
        return true;
    }

    public boolean isFull() {
        for (String key : parkingFloors.keySet()) {
            if (!parkingFloors.get(key).isFull()) {
                return false;
            }
        }
        return true;
    }

    public void addParkingFloor(ParkingFloor floor) {
    /* stores in database */
    }

    public void addEntrancePanel(EntrancePanel entrancePanel) {
    /* stores in database */
    }

    public void addExitPanel(ExitPanel exitPanel) {
    /* stores in database */
    }
}


@Data
class ParkingTicket {
    String ticketNumber;
    Date issuedAt;
    Date payedAt;
    TicketStatus status;
    //    Vehicle vehicle;
//    ParkingSpot parkingSpot;

    String getTicketNumber(){
        return ticketNumber;
    }
}

class ParkingRate {
    float firstHr = 4;
    float secondHr = 3.5f;
    float thirdHr = 3.5f;
}

enum VehicleType {
    CAR, TRUCK, VAN, MOTORCYCLE, ELECTRIC;
}

enum TicketStatus {
    PAID, UNPAID;
}

enum AccountStatus {
    ACTIVE, BLOCKED, ARCHIVED;
}