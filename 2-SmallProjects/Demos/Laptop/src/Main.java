public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.powerOn();

        USB mouse = new Mouse();
        Keyboard keyboard = new Keyboard();

        computer.useDevice(mouse);
        computer.useDevice(keyboard);

        computer.powerOff();
    }
}
