package LeetCode;

public class AddDigits {
    public int addDigits(int num) {
        int result = 0;
        while(num>0){
            result+= num%10;
            num /=10;
        }
        return result<10?result:addDigits(result);
    }

    public int mathematicalApproach(int num) {
        if(num==0)return 0;
        return num%9==0?9:num%9;
    }

    public static void main(String[] args) {
        AddDigits ad = new AddDigits();
        int num = 124215;
        System.out.println("recursive : "+ad.addDigits(num) + "\nmathematical : "+ad.mathematicalApproach(num));
    }
}
