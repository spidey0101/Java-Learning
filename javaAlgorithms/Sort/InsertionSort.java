import java.util.*;
class InsertionSort{
  public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the size of the array: ");
    int n=s.nextInt();
    System.out.println("Enter the elements: ");
    int[] a=new int[n];
    for(int i=0;i<n;i++){
      a[i]=s.nextInt();
    }
    insertionsort(a,n);
    for(int i=0;i<n;i++){
      System.out.print(a[i]+" ");
    }
    System.out.println();
  }
  public static void insertionsort(int[] a,int n){
    int i;
    for(i=1; i<n; i++){
            int x=a[i];  
            int j=i-1;
            while(j>=0){
                if(x<a[j]){
                    a[j+1]=a[j];
                }
                else{
                    break;
                }
                j=j-1;
            }
            a[j+1]=x;
        }
    }
}
