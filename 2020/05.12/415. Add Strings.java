class Solution {
    
    public String addStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }
            sb.append(sum % 10);
            carry = sum/ 10;
            
            
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
