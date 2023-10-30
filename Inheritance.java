package midsem;

import java.util.ArrayList;
import java.util.Scanner;

class USER{
    String name;
    String dateOfBirth;
    String address;
    String pan;
    void setDetails(){
        System.out.println("enter name : ");
        name = DIVY_2201070.scan.next();
        System.out.println("enter date (dd-mm-yy) : ");
        dateOfBirth = DIVY_2201070.scan.next();
        System.out.println("enter address : ");
        address = DIVY_2201070.scan.next();
        System.out.println("enter pan : ");
        pan = DIVY_2201070.scan.next();
    }
    void getDetails(){
        System.out.println("the name :" + name);
        System.out.println("date of birth :"+dateOfBirth);
        System.out.println("address is  :"+address);
        System.out.println("PAN no. "+pan);
    }
    void menu(){
        int temp = -1;
        System.out.println("entering the user menu :");
        System.out.println(" 1.) get details \n 2.) set details");
        temp = DIVY_2201070.scan.nextInt();
        while(temp >0){
            if(temp == 1)
                setDetails();
        }
    }
}
class SUPERUSER extends USER{
    private int superUserId;
    private String password;
    String dateOfJoining;
    int salary;
    String permissibleOperations;
    SUPERUSER(int id, String pass){
        superUserId = id;
        password = pass;
    }
    int getSuperUserId(){
        return superUserId;
    }
    void setPassword(String pass){
        password = pass;
    }
    String getPassword(){
        return password;
    }
    void addNewStock(ITEM item){
        System.out.println("Enter the choice for item you want to add (0 for consumable and 1 for non consumable)");
        int choice = DIVY_2201070.scan.nextInt();
        System.out.println("Enter the item code :");
        int code = DIVY_2201070.scan.nextInt();
        if(choice == 0){
            item = new CONSUMABLES(code);
            item.setDetails();
            DIVY_2201070.itemList.add(item);
        }else if(choice == 1){
            item = new NON_CONSUMABLES(code);
            item.setDetails();
            DIVY_2201070.itemList.add(item);
        }
    }
    Boolean deleteStock(int code){
        for(ITEM i : DIVY_2201070.itemList){
            if(i.itemCode == code){
                if(i.availableQuantity >0){
                    DIVY_2201070.itemList.remove(i);
                    return true;
                }
                else{
                    System.out.println("Item Quantity is 0");
                    return false;
                }
            }
        }
        return false;
    }
    Boolean modifyStock(int code){
        for(ITEM i : DIVY_2201070.itemList){
            if(i.itemCode == code){
                System.out.println("Enter new quantity : ");
                int aval = DIVY_2201070.scan.nextInt();
                i.updateDetails(aval);
                return true;
            }
        }
        return false;
    } 
    @Override void setDetails(){
        super.setDetails();
        System.out.println("enter date of joining (dd-mm-yy)");
        dateOfJoining = DIVY_2201070.scan.next();
        System.out.println("enter salary : ");
        salary = DIVY_2201070.scan.nextInt();
        System.out.println("enter permissible operations : ");
        permissibleOperations = DIVY_2201070.scan.next();
    }
    @Override void getDetails(){
        super.getDetails();
        System.out.println("the date of joining"+dateOfJoining);
        System.out.println("Salary :"+salary);
        System.out.println("permissible operation"+permissibleOperations);
    }
    @Override void menu(){
        int temp = 1;
        System.out.println("Entering Super User Menu :");
        while(temp>0){
            System.out.println("1.) Get super User ID \n 2.)add New stocks\n 3.) delete stock\n 4.) modify stock.\n 5.)exit");
            temp = DIVY_2201070.scan.nextInt();
            if(temp == 1){
                System.out.print(getSuperUserId());
            }else if( temp == 2){
                ITEM itm = null;
                addNewStock(itm);
            }else if(temp == 3){
                System.out.println("Enter item code:");
                int num = DIVY_2201070.scan.nextInt();
                boolean status = deleteStock(num);
                if(status)
                    System.out.println("deleted succelfully");
                else{
                    System.out.println("Operation Failed");
                }
            }else if(temp == 4){
                System.out.println("Enter item code:");
                int num = DIVY_2201070.scan.nextInt();
                boolean status = modifyStock(num);
                if(status)
                    System.out.println("modified succelfully");
                else{
                    System.out.println("Operation Failed");
                }
            }else if(temp == 5){
                System.out.println("exiting super user menu ");
                break;
            }else{
                System.out.println("Please Enter a valid choice.");
            }
        }
    }
}
class NORMALUSER extends USER{
    int userId;
    int dutyHourPerDay;
    String dateOfJoining;
    int salary;
    void sellItem(int code, int qty){
        for(ITEM i : DIVY_2201070.itemList){
            if(i.itemCode == code){
                if(i.availableQuantity < qty){
                    System.out.println("Trying to sell items which which have less availablity");
                    break;
                }
                SELL temp = new SELL();
                temp.setDetails(code, qty);
                DIVY_2201070.sellList.add(temp);
                i.availableQuantity = i.availableQuantity - qty;
            }
        }
    }
    void returnItem(int code, int qty){
        for(ITEM i : DIVY_2201070.itemList){
            if(i.itemCode == code){
                String check = "nonconsumable";
                if(i.ofClass().equals(check)){
                    i.availableQuantity += qty;
                }else{
                    System.out.println("the type is not nonconsumable");
                }
            }
        }
    }
    void displayStock(int code){
        for(ITEM i : DIVY_2201070.itemList){
            if(i.itemCode == code){
                i.getClass();
            }
        }
    }
    void displayToBeExpiredItems(String m){
        for(ITEM i : DIVY_2201070.itemList){
            char[] temp = i.getExpiry().toCharArray();
            char[] given = m.toCharArray();
            if((int) given[0] > (int) temp[3] || (int) given[1] > (int) temp[4]){
                i.getDetails();
            }
        }
    }
    void displaySell(String date1 , String date2){
        for(SELL i : DIVY_2201070.sellList){
            char[] date = i.dateOfSale.toCharArray();
            char[] start = date1.toCharArray();
            char[] end = date2.toCharArray();
            if((int)start[0] < (int) date[6] || (int) start[1] < (int) date[7] && (int)end[0] > (int) date[6] || (int) end[1] > (int) date[7] ){
                i.getDetails();
            }
        }
    }
    @Override void setDetails(){
        super.setDetails();
        System.out.println("enter user id : ");
        userId = DIVY_2201070.scan.nextInt();
        System.out.println("enter dutyPerHour : ");
        dutyHourPerDay = DIVY_2201070.scan.nextInt();
        System.out.println("enter date of joining : ");
        dateOfJoining = DIVY_2201070.scan.next();
        System.out.println("enter salary : ");
        salary = DIVY_2201070.scan.nextInt();
    }
    @Override void getDetails(){
        super.getDetails();;
        System.out.println("User ID : "+userId);
        System.out.println("Duty hours : "+dutyHourPerDay);
        System.out.println("Date of joining : "+dateOfJoining);
        System.out.println("Salary : "+ salary);
    }
    @Override void menu(){
        int temp = -1;
        System.out.println("Entering Normal User Menu :");
        System.out.println("1.) Sell items  \n 2.) return Item \n 3.) display  stock\n 4.) display  stock in range .\n 5.)get user information. \n 6.) Exit");
        temp = DIVY_2201070.scan.nextInt();
        while(temp>0){
            if(temp == 1){
                System.out.println("Enter the item code :");
                int cd = DIVY_2201070.scan.nextInt();
                System.out.println("Enter the quantity :");
                int qty = DIVY_2201070.scan.nextInt();
                sellItem(cd, qty);
            }else if( temp == 2){
                System.out.println("Enter the item code :");
                int cd = DIVY_2201070.scan.nextInt();
                System.out.println("Enter the quantity :");
                int qty = DIVY_2201070.scan.nextInt();
                returnItem(cd, qty);
            }else if(temp == 3){
                System.out.println("Enter the item code :");
                int cd = DIVY_2201070.scan.nextInt();
                displayStock(cd);
            }else if(temp == 4){
                System.out.println("Enter starting year (YY)");
                String start = DIVY_2201070.scan.next();
                System.out.println("Enter ending year (YY)");
                String end = DIVY_2201070.scan.next();
                displaySell(start, end);
            }else if(temp == 5){
                getDetails();
            }else if(temp == 6){
                System.out.println("exiting super user menu ");
                break;
            }else{
                System.out.println("Please Enter a valid choice.");
            }
        }
    }
}
class ITEM{
    int itemCode;
    int price;
    int availableQuantity;
    void setDetails(){
        System.out.println("Enter Price :");
        this.price = DIVY_2201070.scan.nextInt();
        System.out.println("Enter Quantity :");
        this.availableQuantity = DIVY_2201070.scan.nextInt();
    }
    void updateDetails(int aval){
        availableQuantity = aval;
    }
    void getDetails(){
        System.out.println("THe Item Code is: "+itemCode);
        System.out.println("The price is : "+ price);
        System.out.println("the available Quantity : "+ availableQuantity);
    }
    String getExpiry(){
        return null;
    }
    String ofClass(){
        return "item";
    }
}
class CONSUMABLES extends ITEM{
    String dateOfExpiry;
    CONSUMABLES(int code){
        while(code%2 != 0){
            System.out.println("You have entered incorrect itemCode for consumables");
            System.out.println("Please Enter new Valid code :");
            code = DIVY_2201070.scan.nextInt();
        }
        this.itemCode = code;
    }
    @Override void setDetails(){
        super.setDetails();
        System.out.println("Enter date of Expiry (format dd-mm-yy) :");
        this.dateOfExpiry = DIVY_2201070.scan.next();
    }
    @Override void getDetails(){
        super.getDetails();
        System.out.println("the date of expiry"+dateOfExpiry);
    }
    @Override String getExpiry(){
        return dateOfExpiry;
    }
    @Override String ofClass(){
        return "consumable";
    }
}
class NON_CONSUMABLES extends ITEM{
    int returnCount;
    NON_CONSUMABLES(int code){
        while(code%2 == 0){
            System.out.println("You have entered incorrect itemCode for non-consumables");
            System.out.println("Please Enter new Valid code :");
            code = DIVY_2201070.scan.nextInt();
        }
        this.itemCode = code;
    }
    @Override void setDetails(){
        super.setDetails();
        System.out.println("Enter return Quantity :");
        this.returnCount = DIVY_2201070.scan.nextInt();
    }
    @Override void getDetails(){
        super.getDetails();
        System.out.println("the Quantity to be returned : "+returnCount);
    }
    @Override String ofClass(){
        return "nonconsumable";
    }   
}
class SELL{
    String dateOfSale;
    int itemCode;
    int quantity;
    int totalAmount;
    void setDetails(int code, int qty){
        System.out.println("Enter sale date : ");
        dateOfSale = DIVY_2201070.scan.next();
        itemCode = code;
        quantity = qty;
        System.out.println("Enter the sell amount : ");
        totalAmount = DIVY_2201070.scan.nextInt();
    }
    void getDetails(){
        System.out.println("date of sale :"+dateOfSale);
        System.out.println("item code :"+itemCode);
        System.out.println("Quantity :"+quantity);
        System.out.println("total Amount :"+totalAmount);
    }
}
class RETURN{
    String dateOfReturn;
    int itemCode;
    int quantity;
    int returnAmmount;
}
public class DIVY_2201070 {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<ITEM> itemList = new ArrayList<>();
    static ArrayList<SELL> sellList = new ArrayList<>();
    static ArrayList<RETURN> returnList = new ArrayList<>();
    public static void main(String[] args){
        ArrayList<NORMALUSER> normalUserList = new ArrayList<>();
        SUPERUSER su = null;
        USER current = null;
        int choice = 1;
        boolean setup = false;
        while(choice>0){
            System.out.println(" 1. Setup \n 2. SuperUser mode\n 3. Normal user mode\n 4. Exit");
            choice = scan.nextInt();
            if(choice == 1){
                System.out.print("Enter super user ID : ");
                int id = scan.nextInt();
                System.out.print("\nEnter pass : ");
                String pass = scan.next();
                su = new SUPERUSER(id, pass);
                int ans = 0;
                ans = scan.nextInt();
                while(ans != 1){
                    System.out.println("Want to add normal user (0 for yes 1 for no)");
                    ans = scan.nextInt();
                    NORMALUSER temp = new NORMALUSER();
                    temp.setDetails();
                    normalUserList.add(temp);
                }
                setup = true;   
            }else if(choice == 2){
                if(setup == false){
                    System.out.println("please perform setup before");
                }
                else{
                System.out.println("entering super user mode");
                System.out.print("Enter id :");
                int id = scan.nextInt();
                System.out.print("\n enter password: ");
                String pass = scan.next();
                if(id == su.getSuperUserId() && pass.equals(su.getPassword())){
                    current = su;
                    current.menu();
                }
                else{
                    System.out.println("Error");
                }
            }
            }else if(choice == 3){
                 if(setup == false){
                    System.out.println("please perform setup before");
                 }
                 else{
                 System.out.print("Enter the user ID :");
                 int id = scan.nextInt();
                 for(NORMALUSER u : normalUserList){
                    if(u.userId == id)
                        current = u;
                        current.menu();;
                 }
                 if(current == null){
                    System.out.println("no user found continue");
                    continue;
                 }
                }
            }else if(choice == 4){
                System.out.println("exiting the system");
                break;
            }
        }
    }
}
