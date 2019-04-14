import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        boolean fromFile = false;
        Scanner in = new Scanner(System.in);
        if (args.length != 0) {
            try {
                File inputFile = new File(args[0]);
                in = new Scanner(inputFile);
                fromFile = true;
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
        ParkingLot park = null;
        String cmd = "";
        while (fromFile ? in.hasNextLine() : !cmd.equals("exit")) {
            if (!fromFile) System.out.print("$ ");
            cmd = in.nextLine();
            String[] parkcmd = cmd.split(" ");
            if (parkcmd[0].equals("create_parking_lot")) {
                if (parkcmd.length == 2) {
                    park = new ParkingLot(Integer.parseInt(parkcmd[1]));
                }
                else {
                    System.out.println("Undefined command; there is 'create_parking_lot <size>' command");
                }
            }
            else if (parkcmd[0].equals("park")) {
                if (park != null) {
                    if (parkcmd.length == 3) {
                        Car c = new Car(parkcmd[1], parkcmd[2], park.searchEmptySlot());
                        park.parkCar(c);
                    }
                    else {
                        System.out.println("Undefined command; there is 'park <regitration_number> <colour>'");
                    }
                }
                else {
                    System.out.println("Parking lot has not been made; there is 'create_parking_lot <size>' command");
                }
            }
            else if (parkcmd[0].equals("leave")) {
                if (park != null) {
                    if (parkcmd.length == 2) {
                        park.freeSlot(Integer.parseInt(parkcmd[1]));
                    }
                    else {
                        System.out.println("Undefined command; there is 'park <slot_number>' command");
                    }
                }
                else{
                    System.out.println("Parking lot has not been made; there is 'create_parking_lot <size>' command");
                }
            }
            else if (parkcmd[0].equals("status")) {
                if (park != null) {
                    System.out.println("Slot No.\tRegistration No.\tColour");
                    for (Car c : park.getParkingSlot()) {
                        if (c != null) {
                            System.out.println(c.getSlotNumber() + "\t\t" + c.getRgstNumber() + "\t\t" + c.getColour());
                        }
                    }
                }
            }
            else if (parkcmd[0].equals("registration_numbers_for_cars_with_colour")) {
                if (park != null) {
                    if (parkcmd.length == 2) {
                        park.findCarWithColour(parkcmd[1]);
                    }
                    else {
                        System.out.println("Undefined command; there is 'registration_numbers_for_cars_with_colour <colour>' command");
                    }
                }
                else {
                    System.out.println("Parking lot has not been made; there is 'create_parking_lot <size>' command");
                }
            }
            else if (parkcmd[0].equals("slot_numbers_for_cars_with_colour")) {
                if (park != null) {
                    if (parkcmd.length == 2) {
                        park.findSlotWithColour(parkcmd[1]);
                    }
                    else {
                        System.out.println("Undefined command; there is 'slot_numbers_for_cars_with_colour <colour>' command");
                    }
                }
                else {
                    System.out.println("Parking lot has not been made; there is 'create_parking_lot <size>' command");
                }
            }
            else if (parkcmd[0].equals("slot_number_for_registration_number")) {
                if (park != null) {
                    if (parkcmd.length == 2) {
                        park.findSlotWithReg(parkcmd[1]);
                    }
                    else {
                        System.out.println("Undefined command; there is 'slot_number_for_registration_number <registration_number>' command");
                    }
                }
                else {
                    System.out.println("Parking lot has not been made; there is 'create_parking_lot <size>' command");
                }
            }
            if (!fromFile) System.out.println();
        }
        in.close();
    }
}
