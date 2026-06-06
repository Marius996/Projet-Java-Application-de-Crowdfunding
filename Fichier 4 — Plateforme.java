import java.util.ArrayList;

// classe qui gère toute la plateforme (projets + utilisateurs)
public class Plateforme {

    private ArrayList<Projet> projets;
    private ArrayList<Utilisateur> utilisateurs;

    // constructeur
    public Plateforme() {
        projets = new ArrayList<Projet>();
        utilisateurs = new ArrayList<Utilisateur>();
    }

    // ajouter un utilisateur à la plateforme
    public void ajouterUtilisateur(Utilisateur u) {
        utilisateurs.add(u);
        System.out.println("Utilisateur '" + u.getNom() + "' ajoute !");
    }

    // ajouter un projet à la plateforme
    public void ajouterProjet(Projet p) {
        projets.add(p);
        System.out.println("Projet '" + p.getTitre() + "' cree !");
    }

    // afficher tous les projets
    public void afficherTousLesProjets() {
        if (projets.isEmpty()) {
            System.out.println("Aucun projet disponible pour le moment.");
        } else {
            System.out.println("\n=== Liste de tous les projets ===");
            for (int i = 0; i < projets.size(); i++) {
                projets.get(i).afficher();
            }
        }
    }

    // rechercher un projet par son titre
    public Projet rechercherParTitre(String titre) {
        for (int i = 0; i < projets.size(); i++) {
            // on compare en minuscule pour ne pas avoir de problème de casse
            if (projets.get(i).getTitre().toLowerCase().contains(titre.toLowerCase())) {
                return projets.get(i);
            }
        }
        // si on ne trouve rien on retourne null
        return null;
    }

    // afficher le tableau de bord général
    public void afficherTableauDeBord() {
        int nbFinances = 0;
        int nbEnCours = 0;

        // on compte les projets selon leur état
        for (int i = 0; i < projets.size(); i++) {
            if (projets.get(i).getEtat().equals("financé")) {
                nbFinances = nbFinances + 1;
            } else {
                nbEnCours = nbEnCours + 1;
            }
        }

        System.out.println("\n======= TABLEAU DE BORD =======");
        System.out.println("Utilisateurs    : " + utilisateurs.size());
        System.out.println("Projets total   : " + projets.size());
        System.out.println("Projets finances: " + nbFinances);
        System.out.println("Projets en cours: " + nbEnCours);
        System.out.println("================================");
    }

    public ArrayList<Projet> getProjets() { return projets; }
    public ArrayList<Utilisateur> getUtilisateurs() { return utilisateurs; }
}
