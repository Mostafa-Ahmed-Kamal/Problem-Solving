package InterviewQuestions;

public class PharosSolutions {

    public String formACountryName(String[] input) {
        StringBuilder country = new StringBuilder(input[0]);
        int counter = input.length-1;
        while(counter>0){
            for (int i = 0; i < input.length; i++) {
                if (country.charAt(0)==input[i].charAt(1)){
                    country.insert(0,String.valueOf(input[i].charAt(0)));
                    counter--;
                }
                else if(country.charAt(country.length()-1) == input[i].charAt(0)){
                    country.append(input[i].charAt(1));
                    counter--;
                }
            }
        }
        return country.toString();
    }

    public static void main(String[] args) {
        PharosSolutions p = new PharosSolutions();

        String[] a = {"RM", "ER", "GE", "AN", "NY", "MA"}; //germany
        System.out.println(p.formACountryName(a));

        a = new String[]{"GY", "EG", "YP", "PT"}; //germany
        System.out.println(p.formACountryName(a));
    }
}
