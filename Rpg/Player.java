package Rpg;


public class Player{
    String name,classe;
    int hp, ataq, speed, maxHp, stamina, maxStamina,level,xp,maxXp,speedmax;
    Player(String name,String classe, int ataqx,int speedx,int maxStaminax,int maxHpx){
        this.name=name;
        level = 1;
        maxHp=maxHpx;
        hp=maxHp;
        ataq=ataqx;
        speed=speedx;
        speedmax=speed;
        maxStamina=maxStaminax;
        stamina=maxStamina;
        xp=0;
        maxXp=20+5*(level);
        this.classe=classe;
    }
    int playerAtaq(){
        System.out.println("Select a Ataq");
        System.out.printf("1) %s fury(+4 stamina,1*ataq)\n2) %s charged attack(-10 Stamina, 2*ataq)\n",classe,classe);
        int temp;
        do{
            temp=Main.scan.nextInt();
            Main.scan.nextLine();
        }while(temp <1 || temp >2);
        switch (temp) {
            case 1 -> {
                stamina += 4;
                if (stamina > maxStamina) {
                    stamina = maxStamina;
                }
                return ataq;
            }
            case 2 -> {
                stamina -= 10;
                return ataq * 2;
            }
        }
        return 0;
    }
    void playerLevelUp(){
        if(xp>=maxXp){
            level++;
            xp-=maxXp;
            maxHp+=5*level;
            ataq+=3*level;
            speed+=4*level;
            speedmax=speed;
            maxStamina+=4*level;
            maxXp=20+5*(level);
            System.out.println("Congrags you leveled up");
            System.out.printf("You are at level %d\n",level);
        }
    }
}
