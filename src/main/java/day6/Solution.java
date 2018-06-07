package day6;

import common.PuzzleInput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    private static final Pattern COMMAND = Pattern.compile("(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)");

    public static void main(String... args) {
        LightGrid grid = new LightGrid(1000, 1000);
        PuzzleInput.read("/day6.txt").stream()
                .forEach(command -> mutateGrid(grid, command));
        System.out.println("Lumières allumées : " + grid.litCount());
    }

    private static void mutateGrid(LightGrid grid, String command) {
        Matcher matcher = COMMAND.matcher(command);
        if (matcher.matches()) {
            int startX = Integer.parseInt(matcher.group(2));
            int startY = Integer.parseInt(matcher.group(3));
            int endX = Integer.parseInt(matcher.group(4));
            int endY = Integer.parseInt(matcher.group(5));
            switch (matcher.group(1)) {
                case "turn on":
                    grid.on(startX, startY, endX, endY);
                    break;
                case "turn off":
                    grid.off(startX, startY, endX, endY);
                    break;
                case "toggle":
                    grid.toggle(startX, startY, endX, endY);
                    break;
            }
        }
    }

}
