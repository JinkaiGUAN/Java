public class Mouse implements USB{

    @Override
    public void open() {
        System.out.println("Open the mouse!");
    }

    @Override
    public void close() {
        System.out.println("Turn of the mouse!");
    }

}
