package LeetCode;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int m = strs.length;
        int deletedRows = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(strs[j].charAt(i)<strs[j-1].charAt(i)){
                    deletedRows++;
                    break;
                }
            }
        }
        return deletedRows;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSorted dc = new DeleteColumnsToMakeSorted();
        String[] strs = {"cba","daf","ghi"};
        System.out.println(dc.minDeletionSize(strs));
    }
}
