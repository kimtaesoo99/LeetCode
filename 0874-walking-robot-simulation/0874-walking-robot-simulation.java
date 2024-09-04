/**
 * 북 Y+
 * 동 X+
 * 남 Y-
 * 서 X-
 */

/**
 * -2는 왼쪽
 * -1은 오른쪽
 */

class Solution {

    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public int robotSim(int[] commands, int[][] obstacles) {
        int y = 0;
        int x = 0;
        int direction = 0;
        int max = 0;

        for (int command : commands) {
            if (command == -1) {
                direction += 1;
                direction %= 4;
            } else if (command == -2) {
                direction -= 1;
                if (direction == -1) {
                    direction = 3;
                }
            } else {
                loop:
                for (int i = 0; i < command; i++) {
                    int moveY = y + dy[direction];
                    int moveX = x + dx[direction];

                    for (int[] obstacle : obstacles) {
                        if (obstacle[0] == moveX && obstacle[1] == moveY) {
                            break loop;
                        }
                    }
                    y = moveY;
                    x = moveX;
                }
                max = Math.max(max, (int) (Math.pow(x, 2) + Math.pow(y, 2)));
            }
        }

        return max;
    }
}