// 206398596 Guy Reuveni

import java.util.ArrayList;
import java.util.List;

/**
 * this class create a GameEnvironment.
 *
 * @author Guy Reuveni.
 */
public class GameEnvironment {
    private List<Collidable> list;

    /**
     * this constructor creates a new array list.
     */
    public GameEnvironment() {
        this.list = new ArrayList<>();
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c a collidable.
     */
    public void addCollidable(Collidable c) {
        this.list.add(c);
    }

    /**
     * this check if an object moving from line.start() to line.end().
     * if this object will not collide with any of the collidables in this collection the method will
     * return null, else, it will return the information about the closest collision that is going to occur.
     *
     * @param trajectory a line
     * @return the information about the closest collision that is going to occur if there is collision,
     * otherwise will return null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (this.list.isEmpty()) {
            return null;
        }
        CollisionInfo temp;
        ArrayList<Point> distance = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            //this will whice of the points on the rectangle if the closet
            if (trajectory.closestIntersectionToStartOfLine(this.list.get(i).getCollisionRectangle()) != null) {
                distance.add(trajectory.closestIntersectionToStartOfLine(this.list.get(i).getCollisionRectangle()));
                //this will add the index of the intersection point to other list
                index.add(i);
            }
        }
        //these check if there are no intersections at all with the rectangles
        if (distance.isEmpty()) {
            return null;
        }
        // this will call the method that will check which is the close intersection point and will set a new
        // collision in by this
        temp = this.closestIntersectionOfList(distance, index, trajectory);
        return temp;
    }

    /**
     * this will check which of the list if the closet intersection point.
     *
     * @param dis        a list of points.
     * @param index      a list of indexes of the points from the list of the collision info.
     * @param trajectory a line.
     * @return a new collision info.
     */
    public CollisionInfo closestIntersectionOfList(ArrayList<Point> dis, ArrayList<Integer> index, Line trajectory) {
        int colIndex = 0;
        Point minIntersection = dis.get(0);
        double minDistance = trajectory.start().distance(dis.get(0));
        //this will check which of the collision point is the closet to the start point
        for (int i = 0; i < dis.size(); i++) {
            if (trajectory.start().distance(dis.get(i)) <= minDistance) {
                minDistance = trajectory.start().distance(dis.get(i));
                minIntersection = dis.get(i);
                colIndex = index.get(i);
            }
        }
        CollisionInfo col = new CollisionInfo(minIntersection, this.list.get(colIndex));
        return col;
    }

    /**
     * remove the given collidable from the environment.
     *
     * @param c a collidable.
     */
    public void removeCollidable(Collidable c) {
        this.list.remove(c);
    }
}
