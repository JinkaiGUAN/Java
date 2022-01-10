public class Computer {

    public void powerOn() {
        System.out.println("Power on the computer!");
    }

    public void powerOff() {
        System.out.println("Power off the computer!");
    }

    public void useDevice(USB usb) {
        usb.open();

        usb.close();
    }

}
