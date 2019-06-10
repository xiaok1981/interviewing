public class Main {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToEnglish(long num) {
        if(num == 0) return "Zero";
        int i=0;
        String word ="";
        while(num > 0) {
            word = helper((int) num%1000) + " " + THOUSANDS[i] + " " + word;
            num/=1000;
            i++;
        }

        return word.trim();
    }

    public String helper(int number) {
        if(number ==0) return "";
        if(number<20) return LESS_THAN_20[number];
        if(number<100) return TENS[number/10] + " " + LESS_THAN_20[number%10];
        return LESS_THAN_20[number/100] + " " + "Hundreds" + " " + helper(number%100);
    }

    public static void main(String[] args) {
        Main ma = new Main();

        System.out.println(ma.numberToEnglish(230));
    }
}
