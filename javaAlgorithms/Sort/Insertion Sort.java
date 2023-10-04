package java.javaAlgorithms.Sort;
public class insertionsort
{
public static void insertionsort(int n,int arr[])
{
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
}}