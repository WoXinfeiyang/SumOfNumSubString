import java.util.Scanner;

/**
 * �ļ�����:�ַ����������Ӵ����
 * ʱ��:2016-9-1 17:55
 * ˵����1����Ŀ������һ���ַ���str,������ȫ�����ִ������������֮�͡�
 * Ҫ��a������С�����ַ���
 * b��������������Ӵ���������'-',���������ֵ�����Ϊ����ʱ��������Ϊ����
 * �������ֵ�����Ϊż��ʱ����������Ϊ����
 * 
 * 
 * */
public class SumOfNumSubString {
	
	public static int numSun(String str){
		if(str==null){
			return 0;
		}
		char[]charArray=str.toCharArray();
		/*�ۼӽ��ֵ*/
		int result=0;
		/*��ǰ�ռ�������ֵ*/
		int num=0;
		/*��ǰ�ַ�����Ӧ������ֵ*/
		int current=0;
		/*�Ƿ�����������־λ*/
		boolean isPositive=true;
		int i=0;
		
		for(i=0;i<charArray.length;i++){
			/*�����ǰ�ַ�λ��'0'��'9'֮��*/
			if((charArray[i]>='0')&&(charArray[i]<='9')){
				current=charArray[i]-'0';
				num=num*10+(isPositive?current:(-1)*current);
			}
			/*�����ǰ�ַ�λ��'0'��'9'֮��*/
			else if(charArray[i]<'0'||charArray[i]>'0'){
				/*�Ƚ��ռ��������ֶ�Ӧ������ֵ�ۼ�*/
				result+=num;
				/*����ǰ�ռ�������ֵ����*/
				num=0;
				/*�����ǰ�ַ���'-'*/
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
