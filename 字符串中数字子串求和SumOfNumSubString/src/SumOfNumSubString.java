import java.util.Scanner;

/**
 * 文件名称:字符串中数字子串求和
 * 时间:2016-9-1 17:55
 * 说明：1、题目：给定一个字符串str,求其中全部数字串所代表的数字之和。
 * 要求：a、忽略小数点字符。
 * b、如果紧贴数字子串的左侧出现'-',当连续出现的数量为奇数时则数字视为负，
 * 连续出现的数量为偶数时，则数字视为正。
 * 
 * 
 * */
public class SumOfNumSubString {
	
	public static int numSun(String str){
		if(str==null){
			return 0;
		}
		char[]charArray=str.toCharArray();
		/*累加结果值*/
		int result=0;
		/*当前收集到整数值*/
		int num=0;
		/*当前字符所对应的整数值*/
		int current=0;
		/*是否是正整数标志位*/
		boolean isPositive=true;
		int i=0;
		
		for(i=0;i<charArray.length;i++){
			/*如果当前字符位于'0'与'9'之间*/
			if((charArray[i]>='0')&&(charArray[i]<='9')){
				current=charArray[i]-'0';
				num=num*10+(isPositive?current:(-1)*current);
			}
			/*如果当前字符位于'0'与'9'之外*/
			else if(charArray[i]<'0'||charArray[i]>'0'){
				/*先将收集到的数字对应的整数值累加*/
				result+=num;
				/*将当前收集到整数值清零*/
				num=0;
				/*如果当前字符是'-'*/
				if(charArray[i]=='-'){
					if((i-1>-1)&&(charArray[i-1]=='-')){
						isPositive=!isPositive;						
					}else{
						isPositive=false;
					}
				}else{
					isPositive=true;
				}
			}			
		}	
		result+=num;
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String str=in.nextLine();
			System.out.println(numSun(str));
		}
		
	}
}
