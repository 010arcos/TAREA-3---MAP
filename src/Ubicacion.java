import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    private int id;
    private String description;
    private Map<String, Integer > exits;


    public Ubicacion(int id, String description) {
        this.id = id;
        this.description = description;
        this.exits = new HashMap<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }

    public void setExits(Map<String, Integer> exits) {
        this.exits = exits;
    }


    public Ubicacion() {
    }



    public void addExit(String direccion, int idUbicacion){
        exits.put(direccion, idUbicacion); // lo meto al map del objeto ubicacion

    }
}
