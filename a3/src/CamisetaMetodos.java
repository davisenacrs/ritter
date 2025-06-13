import java.util.ArrayList;
import java.util.List;

public class CamisetaMetodos {

    private List<Camiseta> catalogo = new ArrayList<>();


    public CamisetaMetodos() {
        if (catalogo.isEmpty()) {
            catalogoCamisetas();
        }
    }

    public List<Camiseta> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Camiseta> catalogo) {
        this.catalogo = catalogo;
    }

    public void catalogoCamisetas() {
        catalogo.add(new Camiseta(1,"Camiseta Yamal", 129.0, 0.10, "P"));
        catalogo.add(new Camiseta(2,"Camiseta Messi", 129.0, 0.15, "M"));
        catalogo.add(new Camiseta(3,"Camiseta CR7", 119.0, 0.05, "M"));
        catalogo.add(new Camiseta(4,"Camiseta Neymar", 109.0, 0.20, "G"));
        catalogo.add(new Camiseta(5,"Camiseta R9", 109.0, 0.10, "GG"));
        catalogo.add(new Camiseta(6,"Camiseta R10", 109.0, 0.15, "G"));
        catalogo.add(new Camiseta(7,"Camiseta Kaká", 89.0, 0.05, "P"));
        catalogo.add(new Camiseta(8,"Camiseta Mbappé", 99.0, 0.20, "M"));
    }
}
