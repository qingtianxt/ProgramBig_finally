package wzw_jsp;

public class wzw_jsp_rds
{
    public static int[] sort(int[] number, int d) //d��ʾ�������ж���λ
    {
        int k = 0;
        int n = 1;
        int m = 1; //���Ƽ�ֵ������������һλ
        int[][]temp = new int[10][number.length]; //����ĵ�һά��ʾ���ܵ�����0-9
        int[]order = new int[10]; //����orderp[i]������ʾ��λ��i�����ĸ���
        while(m <= d)
        {
            for(int i = 0; i < number.length; i++)
            {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for(int i = 0; i < 10; i++)
            {
                if(order[i] != 0)
                    for(int j = 0; j < order[i]; j++)
                    {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
        return number;
    }
//    public static void main(String[] args)
//    {
//        int[]data =
//        {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
//        RadixSort.sort(data, 3);
//        for(int i = 0; i < data.length; i++)
//        {
//            System.out.print(data[i] + " ");//��������
//        }
//        System.out.println();
//        for(int i=data.length-1;i>=0;i--)
//        {
//        	System.out.print(data[i]+" ");//��������
//        }
//    }
}
