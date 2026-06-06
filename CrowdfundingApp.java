// classe qui représente un utilisateur de la plateforme
public class Utilisateur {

    // les infos de base d'un utilisateur
    private String nom;
    private String email;
    private String type; // "porteur" ou "contributeur"

    // constructeur pour créer un utilisateur
    public Utilisateur(String nom, String email, String type) {
        this.nom = nom;
        this.email = email;
        this.type = type;
    }

    // on affiche les infos de l'utilisateur
    public void afficher() {
        System.out.println("Nom   : " + nom);
        System.out.println("Email : " + email);
        System.out.println("Type  : " + type);
    }

    // getters pour lire les attributs depuis l'extérieur
    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    // setters pour modifier les attributs
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
