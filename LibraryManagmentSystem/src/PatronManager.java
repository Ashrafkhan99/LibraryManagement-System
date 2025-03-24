import java.util.ArrayList;
import java.util.List;

public class PatronManager {
    private List<Patron> patrons;

    public PatronManager() {
        this.patrons = new ArrayList<>();
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void updatePatron(Patron patron) {
        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getPatronId() == patron.getPatronId()) {
                patrons.set(i, patron);
                return;
            }
        }
    }

    public void removePatron(int patronId) {
        patrons.removeIf(patron -> patron.getPatronId() == patronId);
    }

    public Patron getPatronById(int patronId) {
        return patrons.stream().filter(p -> p.getPatronId() == patronId).findFirst().orElse(null);
    }

    public List<Patron> getAllPatron() {
        return patrons;
    }
}