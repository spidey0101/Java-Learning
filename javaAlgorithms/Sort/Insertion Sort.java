import java.util.Scanner;
class insertionsort
{
public static void main(String args[])
{
int n;
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
int arr[]=new int[n];
for(int i=0;i<n;i++)
{
arr[i]=sc.nextInt();
}
for(int i=0;i<n;i++)
{
int j=i;
while(j>0 && arr[j-1]>arr[j])
{
int temp=arr[j];
arr[j]=arr[j-1];
arr[j-1]=temp;
j--;
}
}
for(int i=0;i<n;i++)
{
System.out.print(arr[i]+" ");
}
System.out.println();
}}


