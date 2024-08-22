class Solution {
    public int findComplement(int num) {
        int sum=0; 
        int base=0;
        
        while(sum < num){
            sum+= Math.pow(2, base);
            base++;
        }
        
        return sum - num;
    }
}