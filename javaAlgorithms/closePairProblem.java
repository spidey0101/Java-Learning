import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class point{
    int x;
    int y;
    public point(int n1, int n2){
        this.x = n1;
        this.y = n2;
    }
}
public class closePairProblem{
    static double distance(point a, point b){
        return Math.sqrt(Math.pow(a.x -b.x, 2) + Math.pow(a.y - b.y,2));
    }
    static point[] closest(point[] arr, int n){
        point[] Px = Arrays.copyOf(arr, n);
        Arrays.sort(Px, (p1, p2) -> p1.x - p2.x);
        point[] Py = Arrays.copyOf(arr, n);
        Arrays.sort(Py, (p1, p2) -> p1.y - p2.y);
        return closestPair(Px, Py, n);
    }
    static point[] closestPair(point[] Px, point[] Py, int n){
        if(n <= 3){
            return bruteForce(Py, n);
        }else{
            int mid = n/2;
            point midPoint = Px[mid];
            point[] Ly = Arrays.copyOfRange(Py, 0, mid);
            point[] Ry = Arrays.copyOfRange(Py, mid, n);
            point[] dl_points = closestPair(Px, Ly, mid);
            double dl = distance(dl_points[0], dl_points[1]);
            point[] dr_points = closestPair(Arrays.copyOfRange(Px, mid, n), Ry, n-mid);
            double dr = distance(dr_points[0], dr_points[1]);
            double d = Math.min(dl, dr);
            point[] min_points;
            if(dl < dr){
                min_points = dl_points;
            } 
            else{ 
                min_points = dr_points;
            }
            List<point> strip = new ArrayList<point>();
            for(point p : Py){
                if(Math.abs(p.x - midPoint.x) < d){
                    strip.add(p);
                }
            }
            return stripClosest(strip.toArray(new point[strip.size()]), min_points, strip.size(), d);
          } 
    }
    static point[] stripClosest(point[] strip, point[] minpts, int size, double d){
        double min = d;
        for(int i=0; i< size; ++i){
            for(int j = i+1; j< size && (strip[j].y - strip[i].y) < min; ++j){
                double dist = distance(strip[i] , strip[j]);
                if(dist < min){
                    min = dist;
                    minpts[0] = strip[i];
                    minpts[1] = strip[j];
                }
            }
        }
        return minpts;
    }
    static point[] bruteForce(point[] arr, int n){
        point[] res = new point[2];
        double min = Double.MAX_VALUE;
        for(int i = 0; i<n; ++i){
            for(int j = i+1; j< n; ++j){
                double dist = distance(arr[i], arr[j]);
                if(dist<min){
                    min = dist;
                    res[0] = arr[i];
                    res[1] = arr[j];
                }
            }
        }
        return res;
    }
    static void displayPoint(point p){
        System.out.print("("+ p.x +","+p.y+")");
    }
    static boolean Equal(point a, point b){
        if(a.x == b.x && a.y == b.y){
            return true;
        }else{
            return false;
        } 
    }
    static point[] secondClosest(point[] arr, int n, point[] closestPairs){
        List<point> temp = new ArrayList<point>();
        for(point p : arr){
            if(!(Equal(p, closestPairs[0]))){
                temp.add(p);
            }
        }
        point[] arr1 = new point[temp.size()];
        temp.toArray(arr1);
        point[] res = closest(arr1, arr1.length);
        double dist1  = distance(res[0], res[1]);
        List<point> temp1 = new ArrayList<point>();
        for(point p : arr){
            if(!(Equal(p, closestPairs[1]))){
                temp1.add(p);
            }
        }
        point[] arr2 = new point[temp1.size()];
        temp1.toArray(arr2);
        point[] res1 = closest(arr2, arr2.length);
        double dist2 = distance(res1[0], res1[1]);
        if(dist1<dist2){
            return res;
        }else{
            return res1;
        }
    }
    static point[] thirdClosest(point[] arr, int n, point[] closestPair, point[] sencondClosestPair){
        List<point> temp0 = new ArrayList<point>();
        List<point> temp1 = new ArrayList<point>();
        List<point> temp01 = new ArrayList<point>();
        List<point> temp02 = new ArrayList<point>();
        List<point> temp11 = new ArrayList<point>();
        List<point> temp12 = new ArrayList<point>();
        for(point p: arr){
            if(!(Equal(p, closestPair[0])))
                temp0.add(p);
            if(!(Equal(p, closestPair[1])))
                temp1.add(p);
        }
        for(point p: temp0){
            if(!(Equal(p, sencondClosestPair[0])))
                temp01.add(p);
            if(!(Equal(p, sencondClosestPair[1])))
                temp02.add(p);
        }
        for(point p : temp1){
            if(!(Equal(p, sencondClosestPair[0])))
                temp11.add(p);
            if(!(Equal(p, sencondClosestPair[1])))
                temp12.add(p);
        }
        point[] arr0 = new point[temp0.size()];
        point[] arr1 = new point[temp1.size()];
        point[] arr01 = new point[temp01.size()];
        point[] arr02 = new point[temp02.size()];
        point[] arr11 = new point[temp11.size()];
        point[] arr12 = new point[temp12.size()];
        temp0.toArray(arr0);
        temp1.toArray(arr1);
        temp01.toArray(arr01);
        temp02.toArray(arr02);
        temp11.toArray(arr11);
        temp12.toArray(arr12);
        point[] res;
        point[] res0 = closest(arr0, arr0.length);
        point[] res1 = closest(arr1, arr1.length);
        point[] res01 = closest(arr01, arr01.length);
        point[] res02 = closest(arr02, arr02.length);
        point[] res11 = closest(arr11, arr11.length);
        point[] res12 = closest(arr12, arr12.length);
        List<Double> dist_arr = new ArrayList<Double>();
        double dist0 = distance(res0[0], res0[1]);
        double dist1 = distance(res1[0], res1[1]);
        double dist;
        dist_arr.add(distance(res01[0], res01[1]));
        dist_arr.add(distance(res02[0], res02[1]));
        dist_arr.add(distance(res11[0], res11[1]));
        dist_arr.add(distance(res12[0], res12[1]));
        if(dist1 == distance(sencondClosestPair[0], sencondClosestPair[1])){
            res = res0;
            dist = dist0;
        }else{
            res = res1;
            dist = dist1;
        }
        double min = Double.MAX_VALUE;
        int idx = 0; 
        for(double d : dist_arr){
            if(d < min){
                min = d;
                idx = dist_arr.indexOf(d);
            }
        }
        if(min<dist){
            if(idx == 0)
                return res01;
            if(idx == 1)
                return res02;
            if(idx == 2)
                return res11;
            if(idx == 3)
                return res12;
        }
        return res;
        //find cp in all 
    }

    public static void main(String[] args){
        System.out.println("Enter the points :");
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        point[] arr = new point[n];
        System.out.println("Enter your points (x y) : ");
        for(int i=0; i<arr.length;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            point temp = new point(x, y);
            arr[i] = temp;
        }
        point[] p = closest(arr, arr.length);
        double dis = distance(p[0], p[1]);
        System.out.print("\nClosest points are ");
        displayPoint(p[0]);
        System.out.println(" and ");
        displayPoint(p[1]);
        System.out.print(" with distance "+ dis);
        point[] p2 = secondClosest(arr, arr.length, p);
        System.out.println("\nSecond closest points are ");
        displayPoint(p2[0]);
        System.out.print(" and ");
        displayPoint(p2[1]);
        System.out.println(" with distance "+distance(p2[0], p2[1])+".");
        point[] p3 = thirdClosest(arr, arr.length, p, p2);
        System.out.println("\nThird closest points are ");
        displayPoint(p3[0]);
        System.out.print(" and ");
        displayPoint(p3[1]);
        System.out.println(" with distance "+distance(p3[0], p3[1])+".");
        scan.close();

    }
}

