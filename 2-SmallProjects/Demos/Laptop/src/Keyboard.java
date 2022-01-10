public class Keyboard implements USB{

    @Override
    public void open() {
        System.out.println("Open the keyboard!");
    }

    @Override
    public void close() {
        System.out.println("Turn of the keyboard!");
    }

}
