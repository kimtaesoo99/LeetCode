import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    public boolean isPathCrossing(String movementPath) {
        Set<String> visitedPoints = new HashSet<>();
        int nowX = 0;
        int nowY = 0;
        
        visitedPoints.add(nowX + "," + nowY);

        for (char direction : movementPath.toCharArray()) {
            if (direction == 'N') {
                nowY++;
            } else if (direction == 'S') {
                nowY--;
            } else if (direction == 'E') {
                nowX++;
            } else {
                nowX--;
            }

            String point = nowX + "," + nowY;
            
            if (visitedPoints.contains(point)) {
                return true;
            }

            visitedPoints.add(point);
        }

        return false;
    }
}