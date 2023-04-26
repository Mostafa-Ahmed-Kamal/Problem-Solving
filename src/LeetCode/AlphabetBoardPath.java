package LeetCode;

public class AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        StringBuilder result = new StringBuilder();
        int[] currentPosition = new int[2];
        for (char c: target.toCharArray()){
            int[] characterPosition = getCharacterPosition(c);
            if (characterPosition[0]!=currentPosition[0] || characterPosition[1]!=currentPosition[1]){
                int rowMoves = Math.abs(characterPosition[0]-currentPosition[0]);
                int colMoves = Math.abs(characterPosition[1]-currentPosition[1]);
                result.append(new String(new char[rowMoves]).replace("\0",characterPosition[0]<currentPosition[0]?"U":"D"));
                result.append(new String(new char[colMoves]).replace("\0",characterPosition[1]<currentPosition[1]?"L":"R"));
            }
            currentPosition[0] = characterPosition[0];
            currentPosition[1] = characterPosition[1];
            result.append("!");
        }
        return result.toString();
    }
    private int[] getCharacterPosition(char c){
        int characterIndex = c-'a';
        return new int[] {characterIndex/5, characterIndex%5};
    }

    public static void main(String[] args) {
        AlphabetBoardPath abp = new AlphabetBoardPath();
        System.out.println(abp.alphabetBoardPath("leet"));
    }
}
