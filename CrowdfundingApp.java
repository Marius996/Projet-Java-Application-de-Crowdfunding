import java.util.Scanner;

// Projet Java : Application de Crowdfunding
// Participant : SAVADOGO Nawengua P Marius

public class CrowdfundingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // on crée des tableaux pour stocker les infos des projets
        // on se limite à 10 projets maximum
        String[] titres = new String[10];
        String[] descriptions = new String[10];
        double[] objectifs = new double[10];
        double[] collectes = new double[10];
        String[] etats = new String[10];

        // on commence avec 2 projets déjà dans le système
        titres[0] = "École Numérique";
        descriptions[0] = "Créer une école digitale au Burkina Faso";
        objectifs[0] = 500000;
        collectes[0] = 0;
        etats[0] = "en cours";

        titres[1] = "Agri-Tech Sahel";
        descriptions[1] = "Agriculture intelligente pour les jeunes";
        objectifs[1] = 300000;
        collectes[1] = 0;
        etats[1] = "en cours";

        // compteur pour savoir combien de projets on a
        int nbProjets = 2;

        int choix = 0;

        // boucle principale du menu
        while (choix != 5) {

            // on affiche le menu
            System.out.println("\n=== CROWDFUNDING APP ===");
            System.out.println("1. Voir tous les projets");
            System.out.println("2. Rechercher un projet");
            System.out.println("3. Creer un projet");
            System.out.println("4. Faire une contribution");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // on vide le buffer apres nextInt

            // option 1 : afficher tous les projets
            if (choix == 1) {
                System.out.println("\n--- Liste des projets ---");
                for (int i = 0; i < nbProjets; i++) {
                    double pourcentage = (collectes[i] / objectifs[i]) * 100;
                    System.out.println("Projet " + (i+1) + " : " + titres[i]);
                    System.out.println("  Description : " + descriptions[i]);
                    System.out.println("  Objectif    : " + objectifs[i] + " FCFA");
                    System.out.println("  Collecte    : " + collectes[i] + " FCFA");
                    System.out.println("  Progression : " + pourcentage + " %");
                    System.out.println("  Etat        : " + etats[i]);
                }

            // option 2 : rechercher un projet par titre
            } else if (choix == 2) {
                System.out.print("Entrez le titre : ");
                String recherche = scanner.nextLine();
                boolean trouve = false;
                for (int i = 0; i < nbProjets; i++) {
                    // on vérifie si le titre contient ce qu'on cherche
                    if (titres[i].toLowerCase().contains(recherche.toLowerCase())) {
                        double pourcentage = (collectes[i] / objectifs[i]) * 100;
                        System.out.println("Projet trouve : " + titres[i]);
                        System.out.println("  Description : " + descriptions[i]);
                        System.out.println("  Objectif    : " + objectifs[i] + " FCFA");
                        System.out.println("  Collecte    : " + collectes[i] + " FCFA");
                        System.out.println("  Progression : " + pourcentage + " %");
                        System.out.println("  Etat        : " + etats[i]);
                        trouve = true;
                    }
                }
                if (trouve == false) {
                    System.out.println("Aucun projet trouve.");
                }

            // option 3 : créer un nouveau projet
            } else if (choix == 3) {
                System.out.print("Titre du projet : ");
                titres[nbProjets] = scanner.nextLine();
                System.out.print("Description : ");
                descriptions[nbProjets] = scanner.nextLine();
                System.out.print("Objectif en FCFA : ");
                objectifs[nbProjets] = scanner.nextDouble();
                scanner.nextLine();
                collectes[nbProjets] = 0; // au départ rien n'est collecté
                etats[nbProjets] = "en cours";
                nbProjets = nbProjets + 1; // on incrémente le compteur
                System.out.println("Projet cree avec succes !");

            // option 4 : faire une contribution
            } else if (choix == 4) {
                System.out.print("Titre du projet a financer : ");
                String recherche = scanner.nextLine();
                for (int i = 0; i < nbProjets; i++) {
                    if (titres[i].toLowerCase().contains(recherche.toLowerCase())) {
                        System.out.print("Votre montant en FCFA : ");
                        double montant = scanner.nextDouble();
                        scanner.nextLine();
                        // on vérifie que le montant est positif
                        if (montant <= 0) {
                            System.out.println("Montant invalide !");
                        } else {
                            collectes[i] = collectes[i] + montant;
                            System.out.println("Contribution enregistree !");
                            // on vérifie si le projet est maintenant financé
                            if (collectes[i] >= objectifs[i]) {
                                etats[i] = "financé";
                                System.out.println("Projet '" + titres[i] + "' est maintenant finance !");
                            }
                        }
                    }
                }

            // option 5 : quitter
            } else if (choix == 5) {
                System.out.println("Au revoir !");

            } else {
                System.out.println("Choix invalide, reessayez.");
            }
        }

        scanner.close();
    }
}
