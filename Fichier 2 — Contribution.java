// classe qui représente une contribution faite sur un projet
public class Contribution {

    private Utilisateur contributeur;
    private double montant;
    private String date;

    // constructeur
    public Contribution(Utilisateur contributeur, double montant, String date) {
        // on vérifie que le montant est bien positif avant de créer la contribution
        if (montant <= 0) {
            throw new IllegalArgumentException("Erreur : le montant doit etre superieur a 0 !");
        }
        this.contributeur = contributeur;
        this.montant = montant;
        this.date = date;
    }

    // afficher les détails de la contribution
    public void afficher() {
        System.out.println("  Contributeur : " + contributeur.getNom());
        System.out.println("  Montant      : " + montant + " FCFA");
        System.out.println("  Date         : " + date);
    }

    // getter pour récupérer le montant
    public double getMontant() {
        return montant;
    }

    public Utilisateur getContributeur() {
        return contributeur;
    }
}
