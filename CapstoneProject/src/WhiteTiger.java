import java.awt.*;

public class WhiteTiger extends Tiger {

    boolean hasInfectedAnother;
    public WhiteTiger(){
        super();
    }

    public Color getColor(){
        return Color.WHITE;
    }

    public String toString(){
        if( hasInfectedAnother == false ){
            return "tgr";
        } else {
            return "TGR";
        }
    }

    public Action getMove(CritterInfo info){
        count++;
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        } else if( info.getFront() == Neighbor.WALL ||  info.getRight()== Neighbor.WALL ){
            return Action.LEFT;
        } else if( info.getFront() == Neighbor.SAME ){
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }

    }
}
