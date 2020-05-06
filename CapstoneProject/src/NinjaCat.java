import java.awt.*;

public class NinjaCat extends Critter{

    int count;

    public NinjaCat(){
        super();
    }

    public Color getColor(){
        return Color.BLACK;
    }

    public String toString(){
        return "Ninja";
    }

    public Action getMove(CritterInfo info){
        count++;
        if( info.getFront()==Neighbor.OTHER ){
            return Action.INFECT;
        } else if( info.getRight() == Neighbor.WALL || info.getLeft()==Neighbor.WALL ){
            return Action.HOP;
        } else {
            return Action.INFECT;
        }

    }

}
