package angels;

import game.Game;
import game.Point2D;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public abstract class Angel {
    /**angel type for output.*/
    private String type;
    /**current coordinated.*/
    private Point2D position = new Point2D();
    /**game in which the angels plays.*/
    private Game game;

    /**@param position1 is param.*/
    public void setPosition(final Point2D position1) {
        this.position = position1;
    }

    /**@return .*/
    public Game getGame() {
        return game;
    }

    /**@param game1 setter.*/
    public void setGame(final Game game1) {
        this.game = game1;
    }

    /**@return .*/
    public Point2D getPosition() {
        return position;
    }

    /**@param type1 .*/
    public void setType(final String type1) {
        this.type = type1;
    }

    /**@return .*/
    public String getType() {
        return type;
    }

    /**@param pyromancer hero to be visited.*/
    public abstract void visit(Pyromancer pyromancer);
    /**@param knight hero to be visited.*/
    public abstract void visit(Knight knight);
    /**@param rogue hero to be visited.*/
    public abstract void visit(Rogue rogue);
    /**@param wizard hero to be visited.*/
    public abstract void visit(Wizard wizard);
}
