import java.awt.*;

public class Tiger extends Critter{

    int i;
    int count;
    public Tiger(){
        super();
        count = 0;
    }

    public Color getColor(){
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
        if( count %3 ==0 ){
            i = (int)(Math.random()*3);

        }
        return colors[i];
    }

    public String toString(){
        return "TGR";
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
