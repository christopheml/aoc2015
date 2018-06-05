package day2;

class Present {

    private Present(int width, int length, int height) {

    }

    int paperSize() {
        return 0;
    }

    static Present create(String dimensions) {
        return new Present(0, 0, 0);
    }

}
