/**
 * @author: Peter
 * @date: 29/12/2021
 * @description:
 */
public class Technician {
    private String name;
    private String techType;

    public Technician(String techName, String techType) {
        this.name = techName;
        this.techType = techType;
    }

    public String getIdentity() {
        return techType + " technician " + name;
    }

}
