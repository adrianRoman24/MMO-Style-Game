package game;

import java.util.Objects;

public class Point2D {
    /** OX axis coordinate .*/
    private  int x;
    /** OY axis coordinate .*/
    private  int y;

    /** @return .*/
    public int getX() {
        return x;
    }

    /** @return .*/
    public int getY() {
        return y;
    }

    /**@param x1 is param.*/
    public void setX(final int x1) {
        this.x = x1;
    }

    /**@param y1 is param.*/
    public void setY(final int y1) {
        this.y = y1;
    }

    /**Comparison method.*/
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point2D point2D = (Point2D) o;
        return x == point2D.x && y == point2D.y;
    }

    /**hashcode method.*/
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
