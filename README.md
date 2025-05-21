# Système de Gestion des Bornes de Recharge Électrique

## Auteur
Léo Peyronnet

## Description
Ce projet est une application de gestion de bornes de recharge électrique permettant aux utilisateurs de réserver des créneaux de recharge pour leurs véhicules électriques. L'application gère les utilisateurs, les lieux de recharge, les bornes et les réservations.

## Technologies et Implémentation

### Base de Données
- **MySQL** : Choix motivé par sa robustesse, sa large adoption et sa compatibilité avec Hibernate
- **Hibernate** : ORM utilisé pour la persistance des données
- **JPA** : API de persistance pour la gestion des entités

### Architecture
- **Pattern DAO** : Implémentation d'une couche d'accès aux données avec des interfaces génériques
- **Validation** : Utilisation des annotations Jakarta Validation pour la validation des données
- **Gestion des Relations** : Implémentation des relations JPA (@OneToMany, @ManyToOne)

### Fonctionnalités Principales
1. **Gestion des Utilisateurs**
   - Inscription et authentification
   - Différents rôles (ADMIN, USER)
   - Validation des comptes

2. **Gestion des Lieux de Recharge**
   - Création et gestion des parkings
   - Informations détaillées sur les emplacements

3. **Gestion des Bornes**
   - Suivi de l'état des bornes (DISPONIBLE, OCCUPEE, MAINTENANCE)
   - Tarification horaire
   - Instructions d'utilisation

4. **Système de Réservation**
   - Validation des créneaux horaires
   - Gestion des statuts de réservation
   - Vérification de la disponibilité des bornes

### Validation des Données
- Validation personnalisée pour les dates de réservation
- Contraintes sur les champs obligatoires
- Validation des relations entre entités

### Sécurité
- Gestion des mots de passe
- Validation des emails
- Système de rôles

## Structure du Projet
```
electricityBusiness/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── humanbooster/
│                   ├── dao/         # Couche d'accès aux données
│                   ├── model/       # Entités JPA
│                   └── utils/       # Utilitaires
└── README.md
```