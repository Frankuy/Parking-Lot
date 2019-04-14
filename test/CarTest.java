public class CarTest {
    public static void main(String[] args) {
        //Constructor Test
        Car c = new Car("X-XX-XXXX-XX","Black", 2 );
        assert c != null;

        //getter test
        assert c.getSlotNumber() == 2;
        assert c.getColour().equals("Black");
        assert c.getRgstNumber().equals("X-XX-XXXX-XX");
        System.out.println("Car Test OK\n");
    }
}