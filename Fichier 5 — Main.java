import java.util.Scanner;

// fichier principal qui lance l'application
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Plateforme plateforme = new Plateforme();

        // on crée des utilisateurs de départ
        Utilisateur marius = new Utilisateur("Marius SAVADOGO",
                                             "marius@email.com", "porteur");
        Utilisateur alice = new Utilisateur("Alice Dianda",
                                            "alice@email.com", "contributeur");
        plateforme.ajouterUtilisateur(marius);
        plateforme.ajouterUtilisateur(alice);

        // on crée deux projets de départ pour tester
        Projet p1 = new Projet("Ecole Numerique",
                               "Creer une ecole digitale au Burkina Faso",
                               "Education", 500000, "31/12/2025", marius);

        Projet p2 = new Projet("Agri-Tech Sahel",
                               "Agriculture intelligente pour les jeunes",
                               "Agriculture", 300000, "30/06/2025", marius);

        plateforme.ajouterProjet(p1);
        plateforme.ajouterProjet(p2);

        int choix = 0;

        // boucle principale du menu
        while (choix != 6) {

            System.out.println("\n===== CROWDFUNDING APP =====");
            System.out.println("1. Voir tous les projets");
            System.out.println("2. Rechercher un projet");
            System.out.println("3. Creer un projet");
            System.out.println("4. Faire une contribution");
            System.out.println("5. Tableau de bord");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");

            // on gère le cas où l'utilisateur entre autre chose qu'un chiffre
            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erreur : entrez un chiffre entre 1 et 6 !");
                continue;
            }

            // option 1 : voir tous les projets
            if (choix == 1) {
                plateforme.afficherTousLesProjets();

            // option 2 : rechercher un projet
            } else if (choix == 2) {
                System.out.print("Entrez le titre a rechercher : ");
                String titre = scanner.nextLine();

                // on vérifie que l'utilisateur n'a pas laissé le champ vide
                if (titre.isEmpty()) {
                    System.out.println("Erreur : le titre ne peut pas etre vide !");
                } else {
                    Projet trouve = plateforme.rechercherParTitre(titre);
                    if (trouve == null) {
                        System.out.println("Aucun projet trouve avec ce titre.");
                    } else {
                        trouve.afficher();
                    }
                }

            // option 3 : créer un nouveau projet
            } else if (choix == 3) {
                System.out.print("Titre du projet : ");
                String titre = scanner.nextLine();
                System.out.print("Description : ");
                String desc = scanner.nextLine();
                System.out.print("Categorie : ");
                String cat = scanner.nextLine();
                System.out.print("Date limite : ");
                String date = scanner.nextLine();

                // on gère le cas où l'utilisateur entre un montant invalide
                double montant = 0;
                try {
                    System.out.print("Montant recherche (FCFA) : ");
                    montant = Double.parseDouble(scanner.nextLine());
                    if (montant <= 0) {
                        System.out.println("Erreur : le montant doit etre positif !");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Erreur : entrez un nombre valide !");
                    continue;
                }

                Projet nouveau = new Projet(titre, desc, cat, montant, date, marius);
                plateforme.ajouterProjet(nouveau);

            // option 4 : faire une contribution
            } else if (choix == 4) {
                System.out.print("Titre du projet a financer : ");
                String titre = scanner.nextLine();
                Projet cible = plateforme.rechercherParTitre(titre);

                if (cible == null) {
                    System.out.println("Projet introuvable.");
                } else {
                    // on vérifie que le projet est encore en cours
                    if (cible.getEtat().equals("financé")) {
                        System.out.println("Ce projet est deja finance !");
                    } else {
                        try {
                            System.out.print("Votre montant (FCFA) : ");
                            double montant = Double.parseDouble(scanner.nextLine());
                            Contribution c = new Contribution(alice, montant, "03/06/2026");
                            cible.ajouterContribution(c);
                            System.out.println("Contribution enregistree avec succes !");
                            c.afficher();
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erreur : " + e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println("Erreur : entrez un nombre valide !");
                        }
                    }
                }

            // option 5 : tableau de bord
            } else if (choix == 5) {
                plateforme.afficherTableauDeBord();

            // option 6 : quitter
            } else if (choix == 6) {
                System.out.println("Merci d'avoir utilise CrowdfundingApp. A bientot !");

            } else {
                System.out.println("Choix invalide ! Entrez un chiffre entre 1 et 6.");
            }
        }

        scanner.close();
    }
}
