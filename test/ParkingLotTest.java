public class ParkingLotTest {
    public static void main(String[] args) {
        //Constructor test
        ParkingLot parkingLot = new ParkingLot(5);
        for (int i = 0; i < parkingLot.getSize(); i++) {
            assert parkingLot.getParkingCar(i) == null;
        }

        //Size
        assert parkingLot.getSize() == 5;
        //getParkingSlot
        assert parkingLot.getParkingSlot() != null;

        //Parking a car
        //1. with defined slot number
        Car c = new Car("X-XX-XXXX-XX", "White", 3);
        parkingLot.parkCar(c);
        assert parkingLot.getParkingCar(2) != null;
        //2. With exceed slot number
        Car c2 = new Car("test", "Black", 30);
        parkingLot.parkCar(c2);
        assert parkingLot.getParkingCar(1) == null;
        //3. With undefined slot number
        Car c3 = new Car("test", "Black", -12);
        parkingLot.parkCar(c2);
        assert parkingLot.getParkingCar(1) == null;
        //4. With 0 slot number, expect false because slot number starts with 1
        Car c4 = new Car("test", "Black", 0);
        parkingLot.parkCar(c2);
        assert parkingLot.getParkingCar(1) == null;

        //free slot test
        //1. free from null value
        parkingLot.freeSlot(1);
        //2. free slot from car
        parkingLot.freeSlot(3);
        //3. free slot from undefined slot number
        parkingLot.freeSlot(-200);

        //finding test
        System.out.println("Slot No.\tRegistration No.\tColour");
        for (Car car : parkingLot.getParkingSlot()) {
            if (car != null) {
                System.out.println(car.getSlotNumber() + "\t\t" + car.getRgstNumber() + "\t\t" + car.getColour());
            }
        }
        parkingLot.findCarWithColour("Black");
        parkingLot.findSlotWithColour("Red");
        parkingLot.findSlotWithReg("XX-XX-XXX-XXX");

        System.out.println("Parking Lot OK\n");
    }
}
