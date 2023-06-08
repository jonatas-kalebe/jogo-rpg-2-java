package Rpg;

public class Enemies {
    int life, damage, speed,xp,level,speedmax;
    String name;
    Enemies(String name, int life,int damage,int speed,int level ){
        this.name=name;
        this.life=life+(30*level);
        this.damage=damage+(3*level);
        this.speed=speed+(1*level);
        speedmax=speed;
        this.xp=5*level;
        this.level=level;
    }
}

