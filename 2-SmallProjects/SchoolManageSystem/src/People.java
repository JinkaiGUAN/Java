/**
 * @author: Peter
 * @date: 12/01/2022
 * @description:
 */
public class People {
    private int id;
    private String name;

    public People() {}

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return  id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
