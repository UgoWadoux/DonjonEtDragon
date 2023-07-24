package fr.campus.dd.ui;

import fr.campus.dd.character.Personnage;
import fr.campus.dd.database.HeroesDb;
import fr.campus.dd.equipment.EquipementDefensif;
import fr.campus.dd.equipment.EquipementOffensif;

import java.util.Scanner;

public class Fight {
    Personnage hero;
    Personnage ennemi;
    int hpHero;
    int hpEnnemi;
    String exit = "";
    public Fight(Personnage hero, Personnage ennemi) {
        this.hero = hero;
        this.ennemi = ennemi;
    }

    public void attakHero() {
        int attakHero = hero.getAttackStrength();
        EquipementOffensif weaponHero = hero.getOffensiveEquipment();
        attakHero = attakHero + weaponHero.getOffensePoint();

        System.out.println("| Attaque du hero: " + attakHero+" |");

        ennemi.updateHp(-attakHero);

        this.hpEnnemi = ennemi.getHealthPoint();
        if (hpEnnemi<0){
            this.hpEnnemi=0;
        }
        System.out.println("| Point de vie restant de l'ennemi : "+hpEnnemi+" |");

    }

    public void attakEnnemi() {


        int attakEnnemi = ennemi.getAttackStrength();
        EquipementDefensif armorHero = hero.getDefensiveEquipment();
        int defPoint = armorHero.getDefensePoint();
        float percentage = (1-((float) defPoint /100));
        attakEnnemi = (int) Math.round(attakEnnemi * percentage);
        System.out.println("| Attaque du ennemi: " + attakEnnemi+" |");

        hero.updateHp(-attakEnnemi);
        HeroesDb heroesDb =new HeroesDb();
        heroesDb.changeLifePoint(hero,hero.getHealthPoint());
        this.hpHero = hero.getHealthPoint();
        if (hpHero<0){
            this.hpHero=0;
        }
        System.out.println("| Point de vie restant au Hero : "+hpHero+" |");

    }

    public void fighting(){

        while (true) {
            attakHero();
            if (hpEnnemi==0){
                System.out.println("| Vous avez tuez l'ennemi |");
                return;
            }
            Scanner scanner = new Scanner(System.in);
            String wait = scanner.nextLine();
            attakEnnemi();
            if (hpHero==0){
                System.out.println("| Vous etes mort |");
                return;
            }
            System.out.println("| Continuer le combat ou fuir ? [C/F] |");
            this.exit = scanner.nextLine();
            if (exit.equals("F")){
                System.out.println("| Vous avez fuis le combat ! |");
                return;
            }
        }
    }
}
