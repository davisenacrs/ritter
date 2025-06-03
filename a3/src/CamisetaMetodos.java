import java.util.ArrayList;
import java.util.List;

public class CamisetaMetodos {

    private List<Camiseta> catalogo = new ArrayList<>();

    public List<Camiseta> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Camiseta> catalogo) {
        this.catalogo = catalogo;
    }

    public void catalogoCamisetas() {
        catalogo.add(new Camiseta("Camiseta Yamal", 129.0, 0.10, "P"));
        catalogo.add(new Camiseta("Camiseta Messi", 129.0, 0.15, "M"));
        catalogo.add(new Camiseta("Camiseta CR7", 119.0, 0.05, "M"));
        catalogo.add(new Camiseta("Camiseta Neymar", 109.0, 0.20, "G"));
        catalogo.add(new Camiseta("Camiseta R9", 109.0, 0.10, "GG"));
        catalogo.add(new Camiseta("Camiseta R10", 109.0, 0.15, "G"));
        catalogo.add(new Camiseta("Camiseta Kaká", 89.0, 0.05, "P"));
        catalogo.add(new Camiseta("Camiseta Mbappé", 99.0, 0.20, "M"));
    }

}
