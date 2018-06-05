package day2;

import java.util.Arrays;

class Present {

    private final int length;
    private final int width;
    private final int height;

    private Present(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    int paperSize() {
        int[] sideAreas = { length * width, length * height, width * height };
        Arrays.sort(sideAreas);
        return 2 * (sideAreas[0] + sideAreas[1] + sideAreas[2]) + sideAreas[0];
    }

    static Present create(String dimensions) {
        String[] extractedDimensions = dimensions.split("x");
        int length = Integer.parseInt(extractedDimensions[0]);
        int width = Integer.parseInt(extractedDimensions[1]);
        int height = Integer.parseInt(extractedDimensions[2]);
        return new Present(length, width, height);
    }

    int ribbonLength() {
        return 0;
    }

}
