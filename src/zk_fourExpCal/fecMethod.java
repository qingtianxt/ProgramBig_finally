package zk_fourExpCal;
/**
 * ������ʽ���㷽����
 * @author dmego
 * @tme 2017-5-3
 *
 */
import java.util.Stack;

public class fecMethod {
	/**
	 * ��׺���ʽתǰ׺���ʽ
	 * @param input
	 * @return
	 */
	public Stack<String> toPolishNotation(String input){
		int Len = input.length(); //��������
		Stack<String> s1 = new Stack<String>(); //�洢�������ջs1
		Stack<String> s2 = new Stack<String>(); //�洢���ʽ(�м����)��ջs2
		String c;
		int index = -1;
		if(Len != 0){
			for(int i = Len - 1; i >= 0 ; --i){
				char cc = input.charAt(i);
				c = String.valueOf(cc);
				if(Character.isDigit(cc)){ //����ַ� c ������
					index = checknext1(input, i);
					String number = input.substring(index, i + 1);
					s2.push(number);
					i = index;
				}else if(isOperator(c)){ //����ַ� c �ǲ�����
					while(!s1.isEmpty() && !s1.peek().equals(")")  && compare(c, s1.peek()) == -1){
						s2.push(s1.pop());
					}
					//������� s1 Ϊ�� ���� c �����ȼ� s1 ջ��������߻����
					s1.push(c); //ѹ�� ջ s1��	
				}else if( c.equals(")")){
					s1.push(c);
				}else if( c.equals("(")){
					while(!s1.peek().equals(")")){ //���s1��ջ��Ԫ�ز�Ϊ ")"
						s2.push(s1.pop());
					}
					if(s1.peek().equals(")")){
						s1.pop(); //�� " )" ����
					}
				} // --for
			} // --if
			while(!s1.isEmpty()){ //��s1�е�ʣ�����������ε�������ѹ��s1��
				s2.push(s1.pop());
			}
		}
		return s2;
		
	}
	/**
	 * ��׺���ʽת��׺���ʽ
	 * @param input
	 * @return
	 */
	public  Stack<String> toReversePolish(String input){
		Stack<String> s1 = new Stack<String>(); //�洢�������ջs1
		Stack<String> s2 = new Stack<String>(); //�洢���ʽ(�м����)��ջs2
		String c;
		int index = -1;
			for(int i = 0; i < input.length() ; i++){
				char cc = input.charAt(i);
				c =String.valueOf(cc) ;
				if(Character.isDigit(cc)){ //����ַ� c ������
					index = checknext2(input, i);
					String number = input.substring(i,index+1);
					s2.push(number);
					i = index;
				}else if(isOperator(c)){ //����ַ� c �������
					while(true){
						if(s1.isEmpty() || s1.peek().equals("(") || compare(c, s1.peek()) == 1){
							s1.push(c);//���S1Ϊ�ջ���S1��ջ��Ԫ��Ϊ "(",ֱ����ջ
							break;
						}else if(compare(c, s1.peek()) == -1 || compare(c, s1.peek()) == 0 ){
							s2.push(s1.pop());
						}
					}
				}else if( c.equals("(")){
					s1.push(c);
				}else if( c.equals(")")){
					while(!s1.peek().equals("(")){ //���s1��ջ��Ԫ�ز�Ϊ "("
						s2.push(s1.pop());
					}
					if(s1.peek().equals("(")){
						s1.pop(); //�� "(" ����
					}
				} // --for
			} // --if
			while(!s1.isEmpty()){ //��s1�е�ʣ�����������ε�������ѹ��s1��
				s2.push(s1.pop());
			}
		Stack<String> s3 = new Stack<String>();
		while(!s2.isEmpty()){
			s3.push(s2.pop());
		}
		return s3;
		
	}
	
	/**
	 * ��׺תǰ׺����������һ����������±� +1
	 * @param input
	 * @param start
	 * @return
	 */
	public int checknext1(String input, int start){
		int index = 0;
		for(int i = start-1; i >= 0;--i){
			char c = input.charAt(i);
			if(!Character.isDigit(c) && c != '.'){
				index = i+1;
				break;
			}
		}
		return index;
	}
	
	/**
	 * ��׺ת��׺����������һ����������±�-1
	 * @param input
	 * @param start
	 * @return
	 */
	public int checknext2(String input, int start){
		int index = 0;
		for(int i = start+1; i <=input.length();i++){
			if(i == input.length()){
				index = i-1;
				break;
			}else{
				char c = input.charAt(i);
				if(!Character.isDigit(c) && c != '.'){
					index = i-1;
					break;
				}	
			}
		}
		return index;
	}
	/**
	 * ����ǰ׺���ʽ������
	 * @param polishExp
	 * @return
	 */
	public double calcPolish(Stack<String> Exp){
		Stack<String> s1 = new Stack<String>();	
		while(!Exp.isEmpty()){
			String falg = Exp.pop();
			if(!isOperator(falg)){
				s1.push(falg);
			}else{
				double num1 = Double.parseDouble(s1.pop());
				double num2 = Double.parseDouble(s1.pop());
				double answer = calc(num1, num2, falg);
				System.out.println(num1 +" "+ falg +" "+ num2+" = " + answer);
				s1.push(String.valueOf(answer));
			}
		}
		return Double.parseDouble(s1.pop());
	}
	
	/**
	 * �����׺���ʽ������
	 * @param ReverseExp
	 * @return
	 */
	public double calReverse(Stack<String> Exp){
		Stack<String> s1 = new Stack<String>();	
		while(!Exp.isEmpty()){
			String falg = Exp.pop();
			if(!isOperator(falg)){
				s1.push(falg);
			}else{
				double num1 = Double.parseDouble(s1.pop());
				double num2 = Double.parseDouble(s1.pop());
				double answer = calc(num2, num1, falg);
				System.out.println(num1 +" "+ falg +" "+ num2+" = " + answer);
				s1.push(String.valueOf(answer));
			}
		}
		return Double.parseDouble(s1.pop());
	}
	
	/**
	 * �Ƚ���������������ȼ�
	 * @param op1
	 * @param op2
	 * @return
	 */
	public static int compare(String op1, String op2){
		if(op1.equals("+") || op1.equals("-") )
		{
			if(op2.equals("+") || op2.equals("-")){
				return 0; //ͬ������ 0 
			}else if (op2.equals("*") || op2.equals("/")){
				return  -1; //op1 �� op2  ���ȼ���ʱ���� -1
			}
		}else if(op1.equals("*") || op1.equals("/")){
			if(op2.equals("*") || op2.equals("/")){
				return 0;
			}else if(op2.equals("+") || op2.equals("-")){
				return 1; //op1 �� op2 ���ȼ���ʱ���� 1
			}
		}
		return 0;
	}
	/**
	 * ����������������������������
	 * @param num1
	 * @param num2
	 * @param op
	 * @return
	 */
	public static double calc(double num1, double num2, String op){
		double answer = 0;
		if(op.equals("+")){
			answer =  num1 + num2;
		}
		else if(op.equals("-")){
			answer = num1 - num2;
		}
		else if(op.equals("*")){
			answer = num1 * num2;
		}else if(op.equals("/")){
			if(num2 == 0)
			System.out.println("�����˱�����Ϊ 0 �����!������Ϊ������");
			else 
				answer = num1 / num2;
		}
		return answer;
	}

	/**
	 * �ж��ַ��Ƿ�Ϊ������
	 * @param c
	 * @return
	 */
	public static boolean isOperator(String c){
		if(c.equals("+") || c.equals("-")  || c.equals("*") || c.equals("/")){
			return true;
		}
		return false;
	}
	
	/**
	 * �����ʽ�Ƿ���Ϲ淶
	 * �����������������
	 * 1.���ʽΪ��
	 * 2.�������ʽ�г����˳�" + , - , * , / , . " ֮��������ַ�
	 * 3.���ʽ���ַ���β�ַ���������
	 * 4.����һ��С�������һ���ַ��������ֻ��߻�����ֳ������֮��������ַ�
	 * @param input
	 */
	public boolean checkinput(String input){
		boolean flag = true;
		if(input == null || input == ""){
			System.out.println("���ʽΪ��");
			//msg = "���ʽΪ��";
			flag = false;
		}else{
			char firstStr = input.charAt(0);
			char endStr = input.charAt(input.length()-1);
			if(!Character.isDigit(firstStr) || !Character.isDigit(endStr)){
				System.out.println("���ʽ���ַ�����β�ַ���������");
				//msg = "���ʽ���ַ�����β�ַ���������";
				flag = false;
			}
			for(int i = 1; i < input.length()-1;i++){
				char c = input.charAt(i);
				if(c != '.' && c != '(' && c != ')' && !isOperator(String.valueOf(c)) && !Character.isDigit(c)){
					System.out.println("���ʽ�г����˳��������С����֮��������ַ����߿ո�");
					//msg = "���ʽ�г����˳��������С����֮��������ַ����߿ո�";
					flag = false;
				}
				if(c == '.'){//�������С����
					char cc = input.charAt(i+1);
					if(!Character.isDigit(cc)){
						System.out.println("���ʽ����С����������ֵ����");
						//msg = "���ʽ����С����������ֵ����";
						flag = false;
					}
					for(int j = i+2; j < input.length(); j++){
						char ccc = input.charAt(j);
						if( ccc == '.'){
							System.out.println("һ����������С�����������");
							//msg = "һ����������С�����������";
							flag = false;break;
						}else if(isOperator(String.valueOf(ccc))){
							break; 
						}
					}
				}
			}
		}
		return flag;
	}
}
