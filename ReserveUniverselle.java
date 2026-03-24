import java.util.ArrayList;
import java.util.List;

public class ReserveUniverselle<T> {
    private List<T> contenu;

    public ReserveUniverselle() {
        this.contenu = new ArrayList<>();
    }

    public void ajouter(T element) {
        contenu.add(element);
    }

    public T prendre(int index) {
        return contenu.remove(index);
    }

    public int taille() {
        return contenu.size();
    }

    public void ajouterTous(List<? extends T> source) {
        contenu.addAll(source);
    }

    public <U extends T> ReserveUniverselle<U> filtrer(Class<U> type) {
        ReserveUniverselle<U> result = new ReserveUniverselle<>();
        for (T element : contenu) {
            if (type.isInstance(element)) {
                result.ajouter(type.cast(element));
            }
        }
        return result;
    }
}
