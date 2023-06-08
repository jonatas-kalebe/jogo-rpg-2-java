package Rpg;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner (System.in);

    public static void main(String[] args) {
        Player player1= buildPlayer();
        //game
        while(player1.hp>0){
            int xpGain=0;
            Enemies enemie = buildEnemies(player1);
            System.out.println("you found a "+enemie.name);
            System.out.printf("he has %d hp\n",enemie.life);
            //combat
            while(player1.hp>0 && enemie.life>0){
                //player ataq
                do{
                    int z=player1.playerAtaq();
                    enemie.life-=z;
                    if(enemie.life<=0){
                        System.out.println("you defeated "+enemie.name);
                        break;
                    }    
                    System.out.printf("you dealed %d damage\nEnemie have %d hp\n",z,enemie.life);
                    player1.speed-=enemie.speed;
                }while(player1.speed>=enemie.speed);
                player1.speed=player1.speedmax;
                if(enemie.life<=0){
                    xpGain=enemie.xp;
                    break;
                }
                //monster ataq
                do{
                    int z= enemie.damage;//*((2*Math.random())+0.00001);
                    player1.hp-=z;
                    System.out.printf("you received %d damage\n",z);
                    if(player1.hp<=0){
                        System.out.println(player1.name+" were defeated. Good luck next time");
                        break;
                    }    
                    System.out.printf("You have %d hp\n",player1.hp);
                    enemie.speed-=player1.speed;
                }while(player1.speed<=enemie.speed);
                enemie.speed=enemie.speedmax;
                if(player1.hp<=0){
                    break;
                }
            }
            if(xpGain>0){
                player1.xp+=xpGain;
                player1.playerLevelUp();
            }
        }
    }
    public static Player buildPlayer(){
        int a,b,c,d,e;
        String classe;
        System.out.println("Say your name brave warrior!!");
        String name=scan.nextLine();
        System.out.print("Pick your class\n1)Guardian\n2)Dps\n3)Speedster\n");
        do{
        e= scan.nextInt();
        scan.nextLine();
        }while(e<1 || e>3);
        //get a class
        switch (e) {
            case 1 -> {
                classe = "Guardian";
                a = 5;
                b = 7;
                c = 13;
                d = 15;
            }
            case 2 -> {
                classe = "Dps";
                a = 15;
                b = 10;
                c = 7;
                d = 8;
            }
            case 3 -> {
                classe = "Speedster";
                a = 10;
                b = 30;
                c = 7;
                d = 8;
            }
            default -> {
                classe = "Chad";
                a = 0;
                b = 0;
                c = 0;
                d = 0;
            }
        }
        return new Player(name,classe, a, b, c, d);
    }
    static Enemies buildEnemies(Player lPlayer){
        String name;
        int a,b,c,e;
        //randoomize monsters
        int x=(int)(4*Math.random())+1;
        switch (x) {
            case 1 -> {
                name = "Slime beta";
                a = 12;
                b = 7;
                c = 11;
                e = (int) (lPlayer.level * Math.random()) + 1;
            }
            case 2 -> {
                name = "Spider chad";
                a = 7;
                b = 12;
                c = 11;
                e = (int) (lPlayer.level * Math.random()) + 1;
            }
            case 3 -> {
                name = "Bunny idiot";
                a = 5;
                b = 5;
                c = 20;
                e = (int) (lPlayer.level * Math.random()) + 1;
            }
            case 4 -> {
                name = "Goblin cringe";
                a = 10;
                b = 10;
                c = 10;
                e = (int) (lPlayer.level * Math.random()) + 1;
            }
            default -> {
                name = "";
                a = 0;
                b = 0;
                c = 0;
                e = 0;
            }
        }
        return new Enemies(name, a,b,c,e);

    }
    
}
