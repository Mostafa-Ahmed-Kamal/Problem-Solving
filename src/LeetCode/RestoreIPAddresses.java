package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    HashMap<Integer, List<String>> dp;
    List<String> result = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        dp = new HashMap<>();
        restoreIPAddressesRecursive(s,"",0,0);
        return result;
    }
    public void restoreIPAddressesRecursive(String s, String currentIP, int index, int currentNumberOfDots){
        if(currentNumberOfDots>3){
            if(index>=s.length()){
                result.add(currentIP);
            }
            return;
        }
        if(index >= s.length())return;
        if(currentIP.length()!=0){
            currentIP+=".";
        }
        StringBuilder number = new StringBuilder("");
        while(number.length()==0 || (index < s.length() && !number.toString().equals("0"))){
            number.append(s.charAt(index));
            index++;
            if(Integer.parseInt(number.toString())>255){
                break;
            }
            restoreIPAddressesRecursive(s,currentIP+number,index,currentNumberOfDots+1);
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses rip = new RestoreIPAddresses();
        String s = "25525511135";
        System.out.println(rip.restoreIpAddresses(s));
    }
}
