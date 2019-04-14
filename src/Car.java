public class Car {
    //Atribut
    private final String rgstNumber;
    private final String colour;
    private final int slotNumber;

    //Constructor
    Car(String rgstNumber, String colour, int slotNumber) {
        this.rgstNumber = rgstNumber;
        this.colour = colour;
        this.slotNumber = slotNumber;
    }

    //Getter
    public String getRgstNumber() {
            return rgstNumber;
        }
    public String getColour() {
            return colour;
        }
    public int getSlotNumber() { return slotNumber; }
}
