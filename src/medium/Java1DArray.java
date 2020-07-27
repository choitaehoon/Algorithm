package medium;

public class Java1DArray {

    public static void main(String[] args) {
        System.out.println(canWin(
                3,
                new int[]{0, 0, 1, 1, 1, 0}
        ));
    }

    public static boolean canWin(int leap, int[] game) {
        return searchGames(leap, game, 0);
    }

    private static boolean searchGames(int leap, int[] game, int index) {
        if (index < 0) return false;
        if (game[index] == 1) return false;
        if (index + leap >= game.length) return true;
        if (index + 1 >= game.length) return true;

        game[index] = 1;

        return searchGames(leap, game, index - 1) ||
                searchGames(leap, game, index + 1) || searchGames(leap, game, index + leap);
    }
}
