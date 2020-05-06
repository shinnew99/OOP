import java.awt.*;

public class Bear extends Critter {

    int count;
    boolean polar;

    public Bear(boolean polar){
        super();
        this.polar = polar;
    }

    public Color getColor(){
        if( polar){
            return Color.WHITE;
        } else {
            return super.getColor();
        }
    }

    public String toString(){
        if(count%2==0){
            return "/";
        } else {
            return "\\";
        }
    }

    public Action getMove(CritterInfo info){
        count++;
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        } else if( info.getFront() == Neighbor.EMPTY ){
            return Action.LEFT;
        } else {
            return Action.HOP;
        }
    }
}
