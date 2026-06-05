Application de Crowdfunding 💰
Projet Java — Programmation Orientée Objet
Participant : SAVADOGO Nawengua P Marius
Université Virtuelle du Burkina Faso (UVBF) — 2026

C'est quoi ce projet ?
C'est une application Java en console qui simule une plateforme de financement participatif (crowdfunding).
Elle permet de créer des projets, de les rechercher, et de faire des contributions financières pour les soutenir.

Ce que l'application peut faire

✅ Voir tous les projets disponibles
✅ Rechercher un projet par son titre
✅ Créer un nouveau projet
✅ Faire une contribution financière à un projet
✅ Suivre automatiquement l'état d'un projet (en cours / financé)


Comment lancer le projet ?
1. Prérequis
Il faut avoir Java installé sur ton ordinateur.
Pour vérifier, ouvre un terminal et tape :
java -version
2. Compiler le code
javac CrowdfundingApp.java
3. Lancer l'application
java CrowdfundingApp

Comment utiliser le menu ?
Quand tu lances l'application, un menu s'affiche :
=== CROWDFUNDING APP ===
1. Voir tous les projets
2. Rechercher un projet
3. Creer un projet
4. Faire une contribution
5. Quitter
Votre choix :
Il suffit de taper le numéro correspondant à ce que tu veux faire et appuyer sur Entrée.

Structure du code
Tout le code est dans un seul fichier :
CrowdfundingApp.java
Les données sont stockées dans des tableaux simples :

titres[] → les titres des projets
descriptions[] → les descriptions
objectifs[] → les montants recherchés
collectes[] → les montants déjà collectés
etats[] → l'état du projet (en cours / financé)


Exemple d'utilisation
=== CROWDFUNDING APP ===
Votre choix : 4
Titre du projet a financer : École
Votre montant en FCFA : 500000
Contribution enregistree !
Projet 'École Numérique' est maintenant finance !

Concepts POO utilisés
ConceptOù on l'utiliseClasseCrowdfundingAppEncapsulationDonnées dans des tableaux privés au mainBoucleMenu principal avec whileConditionsGestion des choix avec if/elseGestion d'erreurVérification du montant avant contribution

Limites connues
L'application peut stocker maximum 10 projets
Les données sont perdues quand on ferme l'application (pas de base de données)
Il n'y a pas encore de système de connexion utilisateur


L'application peut stocker maximum 10 projets
Les données sont perdues quand on ferme l'application (pas de base de données)
Il n'y a pas encore de système de connexion utilisateur
