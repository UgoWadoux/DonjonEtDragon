package fr.campus.dd.ui;

import fr.campus.dd.character.Personnage;
import fr.campus.dd.database.DbManager;
import fr.campus.dd.database.HeroesDb;
import fr.campus.dd.equipment.Potion;
import fr.campus.dd.equipment.offenseweapons.Arme;
import fr.campus.dd.equipment.offenseweapons.Sort;
import fr.campus.dd.ui.cases.*;
import fr.campus.dd.ui.cases.EmptyCase;
import fr.campus.dd.ui.exception.PersonnageHorsPlateauException;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    private int positionPlayer;

    public void setPositionPlayer(int positionPlayer) {
        this.positionPlayer = positionPlayer;
    }

    private int board;

    public void setBoard(int board) {
        this.board = board;
    }

    private Menu menu;
    private Personnage perso;

    public Game(Menu menu) {
        this.menu = menu;
        setPositionPlayer();
    }

    public void setPositionPlayer() {

        String continueGame = "Y";

        int min = 1;
        int max = 6;

        while (true) {

            positionPlayer = 1;
            board = 64;

            if (continueGame.equals("Y")) {
                while (board > 0) {
                    tryRound();
                }
                System.out.println("Fin!");
            }

            if (continueGame.equals("N")) {
                System.out.println("Aurevoir");
                return;
            }

            System.out.println("Recommencer une partie ? [Y/N]");
            Scanner restart = new Scanner(System.in);
            continueGame = restart.nextLine();
        }

    }

    public void playRound(int min, int max) {
        try {

            System.out.println(menu.getCharacter());
            int dice = (int) (Math.random() * (max - min + 1) + min);
            positionPlayer += dice;
            System.out.println("Position du jouer sur le plateau:" + positionPlayer + "/64");
            board -= dice;
            System.out.println("Le dé à fait: " + dice);
            System.out.println("Il reste: " + board + " cases");
            if (board < 0) {
                throw new PersonnageHorsPlateauException();
            }

        } catch (PersonnageHorsPlateauException e) {
            System.out.println("Depassement du plateau");
        }
    }

    public void tryRound() {
        setBoard(3);
        setPositionPlayer(0);
        int dice = 1;

        EnnemiCase ennemiCase = new EnnemiCase();
        PotionCase potionCase = new PotionCase();
        WeaponCase weaponCase =new WeaponCase();
        EmptyCase emptyCase = new EmptyCase();
        ArrayList<Case> board1 = new ArrayList<Case>();
        board1.add(0, emptyCase);
        board1.add(1, ennemiCase);
        board1.add(2,weaponCase);
        board1.add(3, potionCase);

        HeroesDb heroesDb =new HeroesDb();
        heroesDb.getHeroes();
        System.out.println("Choisissez votre joueur :");
        String name;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Entrez un nom: ");
        name = myObj.nextLine();
        heroesDb.getOneHeroe(name);
        this.perso = heroesDb.getCharacter();
//        System.out.println(board1.size());
        for (int i = 0; i < board1.size(); i++) {

            System.out.print("position du joueur: " + positionPlayer + " ");
            System.out.println(" Case: " + board1.get(i));
            if (board1.get(i)==ennemiCase){
                Fight fight=new Fight(perso,ennemiCase.getEnnemi());
                fight.fighting();
            }
            if (board1.get(i)==potionCase){
                potionCase.addPotion(perso);
            }if (board1.get(i)==weaponCase){
                System.out.println(weaponCase.getOffensifWeapong().getClass().getSimpleName());
                String nameWeapon = weaponCase.getOffensifWeapong().getClass().getSimpleName();
                String classe = perso.getClass().getSimpleName();
                int OffensePointCase = weaponCase.getOffensifWeapong().getOffensePoint();
                int OffensePointWeaponHero =  perso.getOffensiveEquipment().getOffensePoint();
                System.out.println(classe);
                if (nameWeapon.equals("Arme") && classe.equals("Guerriers")){
                    if (OffensePointCase >OffensePointWeaponHero){
                        System.out.println("|Vous récupérez l'arme |");
                        perso.setOffensiveEquipment(weaponCase.getOffensifWeapong());
                        heroesDb.editHero(perso, perso.getName());
                    }
                    System.out.println("nouvelle arme guerrier");
                } else if(nameWeapon.equals("Sort") && classe.equals("Magiciens")){
                    if (OffensePointCase >OffensePointWeaponHero){
                        System.out.println("|Vous récupérez le sort |");
                        perso.setOffensiveEquipment(weaponCase.getOffensifWeapong());
                        heroesDb.editHero(perso, perso.getName());
                    }
                }else {
                    System.out.println("| Vous ne récupérez rien |");
                }
            }
            positionPlayer += dice;
            board -= dice;
        }
    }
}
