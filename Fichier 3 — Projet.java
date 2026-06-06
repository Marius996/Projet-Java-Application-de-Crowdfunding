import java.util.ArrayList;

// classe qui représente un projet de crowdfunding
public class Projet {

    private String titre;
    private String description;
    private String categorie;
    private double montantRecherche;
    private double montantCollecte;
    private String dateLimite;
    private String etat; // "en cours", "financé", "échoué"
    private Utilisateur porteur;

    // liste pour stocker toutes les contributions du projet
    private ArrayList<Contribution> contributions;

    // constructeur
    public Projet(String titre, String description, String categorie,
                  double montantRecherche, String dateLimite, Utilisateur porteur) {
        this.titre = titre;
        this.description = description;
        this.categorie = categorie;
        this.montantRecherche = montantRecherche;
        this.montantCollecte = 0; // au départ rien n'est collecté
        this.dateLimite = dateLimite;
        this.etat = "en cours"; // un nouveau projet commence toujours en cours
        this.porteur = porteur;
        this.contributions = new ArrayList<Contribution>();
    }

    // ajouter une contribution au projet
    public void ajouterContribution(Contribution c) {
        contributions.add(c);
        // on ajoute le montant de la contribution au total collecté
        montantCollecte = montantCollecte + c.getMontant();

        // on vérifie si l'objectif est atteint
        if (montantCollecte >= montantRecherche) {
            etat = "financé";
            System.out.println(">>> Projet '" + titre + "' est maintenant finance ! <<<");
        }
    }

    // calculer le pourcentage de financement
    public double getPourcentage() {
        return (montantCollecte / montantRecherche) * 100;
    }

    // afficher les détails complets du projet
    public void afficher() {
        System.out.println("----------------------------------");
        System.out.println("Titre       : " + titre);
        System.out.println("Description : " + description);
        System.out.println("Categorie   : " + categorie);
        System.out.println("Porteur     : " + porteur.getNom());
        System.out.println("Objectif    : " + montantRecherche + " FCFA");
        System.out.println("Collecte    : " + montantCollecte + " FCFA");
        System.out.println("Progression : " + getPourcentage() + " %");
        System.out.println("Date limite : " + dateLimite);
        System.out.println("Etat        : " + etat);
        System.out.println("----------------------------------");
    }

    // getters
    public String getTitre() { return titre; }
    public String getCategorie() { return categorie; }
    public double getMontantRecherche() { return montantRecherche; }
    public double getMontantCollecte() { return montantCollecte; }
    public String getEtat() { return etat; }
    public Utilisateur getPorteur() { return porteur; }
    public ArrayList<Contribution> getContributions() { return contributions; }

    // setters
    public void setDescription(String description) { this.description = description; }
    public void setEtat(String etat) { this.etat = etat; }
}
