package fr.campus.dd.ui;

import fr.campus.dd.character.Personnage;
import fr.campus.dd.character.types.Guerriers;
import fr.campus.dd.character.types.Magiciens;
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
import java.util.Random;
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
                System.out.println(" ");
                System.out.println(" ");
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
        setBoard(64);
        setPositionPlayer(0);
        int dice = 1;


        ArrayList<Case> board1 = new ArrayList<Case>();

        HeroesDb heroesDb = new HeroesDb();
        heroesDb.getHeroes();
        System.out.println("Choisissez votre joueur :");
        String name;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Entrez un nom: ");
        name = myObj.nextLine();
        heroesDb.getOneHeroe(name);
        this.perso = heroesDb.getCharacter();
//        System.out.println(board1.size());
        int min = 1;
        int max = 6;

        for (int i = 0; i < 64; i++) {
            EnnemiCase ennemiCase = new EnnemiCase();
            EmptyCase emptyCase = new EmptyCase();
            PotionCase potionCase = new PotionCase();
            WeaponCase weaponCase = new WeaponCase();

            for (int j =0; j<64; j++){
                Random r = new Random();
                int n = r.nextInt(4);
                if (n==0){
                    board1.add(j,emptyCase);
                }else if (n==1){
                    board1.add(j,ennemiCase);
                }else if (n==2){
                    board1.add(j,potionCase);
                }else {
                    board1.add(j,weaponCase);
                }
            }

            dice = (int) (Math.random() * (max - min + 1) + min);
            i+= dice-1;
            Scanner scanner = new Scanner(System.in);
            String wait = scanner.nextLine();
            System.out.println("Vous jetez le dé, vous avancez de:  " +dice );
            positionPlayer = i;
            System.out.print("position du joueur: " + positionPlayer + " ");
            System.out.println(" Case: " + board1.get(i));
            if (board1.get(i)instanceof EnnemiCase) {
//                System.out.println(ennemiCase.getEnnemi());
                Fight fight = new Fight(perso, ennemiCase.getEnnemi());
                fight.fighting();
            }
            if (board1.get(i) instanceof PotionCase) {
                potionCase.addPotion(perso);
            }
            if (board1.get(i) instanceof WeaponCase) {
//                System.out.println(weaponCase.getOffensifWeapong().getClass().getSimpleName());
                String nameWeapon = weaponCase.getOffensifWeapong().getClass().getSimpleName();
                String classe = perso.getClass().getSimpleName();
                int offensePointCase = weaponCase.getOffensifWeapong().getOffensePoint();
                int offensePointWeaponHero = perso.getOffensiveEquipment().getOffensePoint();
//                System.out.println(classe);
                if (weaponCase.getOffensifWeapong() instanceof Arme && perso instanceof Guerriers && offensePointCase > offensePointWeaponHero) {
//                    if (OffensePointCase >OffensePointWeaponHero){
                    System.out.println("|Vous récupérez l'arme |");
                    perso.setOffensiveEquipment(weaponCase.getOffensifWeapong());
                    heroesDb.editHero(perso, perso.getName());
//                    }
                    System.out.println("nouvelle arme guerrier");
                } else if (weaponCase.getOffensifWeapong() instanceof Sort && perso instanceof Magiciens && offensePointCase > offensePointWeaponHero) {
//                    if (OffensePointCase >OffensePointWeaponHero){
                    System.out.println("|Vous récupérez le sort |");
                    perso.setOffensiveEquipment(weaponCase.getOffensifWeapong());
                    heroesDb.editHero(perso, perso.getName());
//                    }
                } else {
                    System.out.println("| Vous ne récupérez rien |");
                }
            }


        }
        board =0;
    }
}
