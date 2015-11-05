package PureStorage;
/*
 * count number of sub palindromes
 * time:n^2
 * space:o(1)
 */
public class CountSubstringPalindrome {
	public int getCount(String s){
		if(s==null||s.length()==0){
			return 0;
		}
		int res=0;
		for(int i=0;i<s.length();i++){
			res+=getPalin(s,i,i);
			if(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)){
				res+=getPalin(s,i,i+1);
			}
		}
	  return res;
	}
	public int getPalin(String s, int l, int r){
		int count=0;
		while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
			l--;
			r++;
			count++;
		}
	  return count;
	}
   
	public static void main(String[] args){
		String s="aba";
		CountSubstringPalindrome cc=new CountSubstringPalindrome();
		System.out.println(cc.getCount(s));
	}
	
	
	
	
	
	
	
	
}
