import java.util.ArrayList;

public class ParkingLot {
    //Atribut
    private int size;
    private ArrayList<Car> parkingSlot;

    //Constructor
    public ParkingLot(int size) {
        this.size = size;
        parkingSlot = new ArrayList<>(size);
        for (int i = 0; i <= size; i++) {
            parkingSlot.add(null);
        }
        System.out.println("Creating a parking lot with " + size + " slots");
    }

    //Getter
    public int getSize() {
        return size;
    }
    public ArrayList<Car> getParkingSlot() {
        return parkingSlot;
    }
    public Car getParkingCar(int idx) {
        return parkingSlot.get(idx);
    }

    //Method to place car to Parking Lot
    public void parkCar(Car c) {
        if (c.getSlotNumber() > 0 && c.getSlotNumber() <= size) {
            if (c.getSlotNumber() != -1) {
                parkingSlot.set(c.getSlotNumber(), c);
                System.out.println("Allocated slot number: " + c.getSlotNumber());
            }
            else {
                System.out.println("Sorry, parking lot is full");
            }
        }
        else {
            System.out.println("Undefined slot number");
        }
    }

    //Method to free parking slot from car
    public void freeSlot(int i) {
        try {
            if (parkingSlot.get(i) != null) {
                parkingSlot.set(i, null);
                System.out.println("Slot number " + i + " is free");
            }
            else {
                System.out.println("Slot number " + i + "is already empty");
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Slot " + i + " tidak ada");
        }
    }

    //Method to searching the first empty slot from entry point
    public int searchEmptySlot() {
        for (int i = 1; i <= size; i++) {
            if (parkingSlot.get(i) == null) {
                return i;
            }
        }
        return -1;
    }

    //Method to find registration number car with specific colour
    public void findCarWithColour(String colour) {
        ArrayList<String> result = new ArrayList<>();
        for (Car c : parkingSlot) {
            if (c != null) {
                if (c.getColour().equals(colour)) {
                    result.add(c.getRgstNumber());
                }
            }
        }
        int idx = 0;
        for (String regNum : result) {
            if (idx < result.size() - 1) {
                System.out.print(regNum + ", ");
            }
            else {
                System.out.println(regNum);
            }
            idx+=1;
        }
        if (result.size() == 0) {
            System.out.println("Not found");
        }
    }

    //Method to find number slot in parking lot that car parked has specific registration number
    //Assume : every car has unique registration number and can only have one slot to be allocated
    public void findSlotWithReg(String reg) {
        boolean found = false;
        for (Car c : parkingSlot) {
            if (c != null) {
                if (c.getRgstNumber().equals(reg)) {
                    System.out.println(c.getSlotNumber());
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Not found");
        }
    }

    //Method to find slot number with the car parked has specific colour
    public void findSlotWithColour(String colour) {
        ArrayList<String> result = new ArrayList<>();
        for (Car c : parkingSlot) {
            if (c != null) {
                if (c.getColour().equals(colour)) {
                    result.add(Integer.toString(c.getSlotNumber()));
                }
            }
        }
        int idx = 0;
        for (String regNum : result) {
            if (idx < result.size() - 1) {
                System.out.print(regNum + ", ");
            }
            else {
                System.out.println(regNum);
            }
            idx += 1;
        }
        if (result.size() == 0) {
            System.out.println("Not found");
        }
    }
}
