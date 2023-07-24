package fr.campus.dd.ui;

import fr.campus.dd.character.Personnage;
import fr.campus.dd.character.types.Guerriers;
import fr.campus.dd.character.types.Magiciens;
import fr.campus.dd.database.HeroesDb;

import java.util.Scanner;

public class Menu {
    Personnage character;

    public Menu() {
        choiceInMenu();
    }

    public void choiceInMenu() {

        int menuChoice;

        String name = "";


        while (true) {
            System.out.println("* * * * * * * * * * * * * * * * * * * *");
            System.out.println("*         1. Creation Perso           *");
            System.out.println("*         2. Changement Perso         *");
            System.out.println("*         3. Demarrage Partie         *");
            System.out.println("*         4. Supprimer personnage     *");
            System.out.println("*         5. Fin                      *");
            System.out.println("* * * * * * * * * * * * * * * * * * * *");
            HeroesDb  heroesDb = new HeroesDb();

            System.out.println(" ");
            System.out.print("Choix: ");

//            System.out.println(heroesDb.nullCheck());

            Scanner Choice = new Scanner(System.in);
            menuChoice = Choice.nextInt();

            if (menuChoice == 1) {

                name = inputName();
                inputType(name);
                HeroesDb hero = new HeroesDb();
                hero.createHero(character);
                System.out.println(character);

            } else if (menuChoice == 2 && heroesDb.nullCheck()!=0) {

                System.out.println("Afficher le personnage, le modififier [A/M]");
                Scanner inputModif = new Scanner(System.in);
                String characterChange = inputModif.nextLine();

                if (characterChange.equals("A")) {


//                    System.out.println(character.toString());
                    HeroesDb hero = new HeroesDb();
                    hero.getHeroes();

                }
                if (characterChange.equals("M")) {
                    HeroesDb hero = new HeroesDb();

                    hero.getHeroes();
                    System.out.println("Choisissez le nom du personnage que vous voulez modifié: ");
                    String oldName = inputName();
                    name = newName();
                    inputType(name);
                    hero.editHero(character, oldName);
                    System.out.println(character.toString());
                }

            } else if (menuChoice == 3 && heroesDb.nullCheck()!=0) {

                System.out.println("Demarrage partie");
                Game play = new Game(this);

            } else if (menuChoice == 4) {

                HeroesDb hero = new HeroesDb();
                hero.getHeroes();
                System.out.println("Entrez le nom du personnage que vous voulez supprimé: ");
                Scanner delete = new Scanner(System.in);
                String deletePerso = delete.nextLine();
                hero.deletePerso(deletePerso);
                hero.getHeroes();

            } else if (menuChoice == 5) {

                System.out.println("Aurevoir");
                return;

            } else {

                System.out.println("Veuillez d'abord créé un personnage");

            }

        }

    }

    private void inputType(String name) {
        String type;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Entrez un type: Guerrier ou Magicien:" );
        type = myObj.nextLine();
        type = type.toUpperCase();
        if (type.equals("GUERRIER")) {
            this.character = new Guerriers(name);
        }
        if (type.equals("MAGICIEN")) {
            this.character = new Magiciens(name);
        }

    }

    private String inputName() {
        String name;
        Scanner myObj = new Scanner(System.in);

        System.out.println("Entrez un nom: ");
        name = myObj.nextLine();
        return name;
    }

    private String newName() {
        String name;
        Scanner myObj = new Scanner(System.in);

        System.out.println("Entrez un nouveau nom: ");
        name = myObj.nextLine();
        return name;
    }


    public Personnage getCharacter() {
        return character;
    }
}
