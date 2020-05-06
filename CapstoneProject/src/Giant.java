import java.awt.*;

public class Giant extends Critter{
    int count;

    public Giant(){
        super();
        count = 0;
    }

    public Color getColor(){
        return Color.GRAY;
    }

    public String toString(){
        int Remaining = count %24;
        if(Remaining<6){
            return "fee";
        } else if(Remaining >=6 && Remaining <12  ){
            return "fie";
        } else if(Remaining >=12 && Remaining <18 ){
            return "foe";
        } else {
            return "fum";
        }
    }


    public Action getMove(CritterInfo info){
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        } else if( info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }

    }
}
