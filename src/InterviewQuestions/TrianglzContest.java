package InterviewQuestions;

import java.util.*;

public class TrianglzContest {

    public void solution(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int arr[] = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.next());
            set.add(Math.max(50-arr[i],0));
        }
        int count;
        int maxCount = 0;
        System.out.println(set);
        for (Iterator<Integer> it = set.iterator(); it.hasNext(); ) {
            count = 0;
            int i = it.next();
            for (int j = 0; j < n; j++) {
                if(arr[j]+i>100) {
                    count = 0;
                    break;
                }
                if(arr[j]+i<=100 && arr[j]+i>=50)count++;
            }
            maxCount = Math.max(maxCount,count);
        }
        System.out.println(maxCount);
    }
    public void WizardingSchool(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.next());
        }
        Arrays.sort(arr);
        for (int i = n-1; i > 0; i--) {
            if((arr[i]-arr[i-1])%2!=0){
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
    public void bananaPlantation(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int count = 0;
        char spouts[] = scanner.next().toCharArray();
        for (int i = 0; i < n-1; i++) {
            if(spouts[i]=='*')spouts[i+1] = spouts[i+1]=='*'?'*':'-';
            else if(spouts[i+1]=='*')spouts[i]='-';
            else if(spouts[i]=='.') {
                spouts[i + 1] = '*';
                count++;
            }
        }
        if(spouts[n-1]=='.')count++;
        System.out.println(count);
    }
    public void redDiamond(){
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        int arr[][] = new int[B.length()][A.length()];
        char b0 = B.charAt(0);
        int temp = 0;
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i)==b0)temp++;
            arr[0][i] = temp;
        }
        for (int i = 1; i < B.length(); i++) {
            for (int j = i; j < A.length(); j++) {
                arr[i][j]=A.charAt(j)==B.charAt(i)?arr[i-1][j-1]+arr[i][j-1]:arr[i][j-1];
            }
        }
        System.out.println(arr[arr.length-1][arr[0].length-1]);
    }
    public void zoo(){
        Scanner scanner = new Scanner(System.in);
        int M = Integer.parseInt(scanner.next());
        int B = Integer.parseInt(scanner.next());
        int monkeys[] = new int[M];
        int bananaHands[] = new int[B];
        for (int i = 0; i < M; i++) {
            monkeys[i] = Integer.parseInt(scanner.next());
        }
        for (int i = 0; i < B; i++) {
            bananaHands[i] = Integer.parseInt(scanner.next());
        }
        Arrays.sort(monkeys);
        Arrays.sort(bananaHands);
    }

    public static void main(String[] args) {
        TrianglzContest tc = new TrianglzContest();
        tc.zoo();
    }
}
