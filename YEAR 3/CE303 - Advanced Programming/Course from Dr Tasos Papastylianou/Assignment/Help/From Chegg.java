import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float total=0;
        int n=1;
     System.out.println("Welcome to our Cafe!");
     System.out.println("Please select ");
     System.out.println("Enter 1 for Americano - 4 $ ");
     System.out.println("Enter 2 for Cappuccino - 4.5 $");
     System.out.println("Enter 3 for Latte -4.75 $");
     System.out.println("Enter 4 for Mocha - 4.35$");
     System.out.println("Enter 5 for Tea - 3.50$");
     System.out.println("Enter 0 when you are done");
    while(n!=0){
     System.out.print("New Choice:");
     n=sc.nextInt();
     if(n==0) break;
     else if(n>=1 && n<=5){
     System.out.print("How many would you like ? Quantity:");
     int m=sc.nextInt();
     if(n==1) total+=(4*m);
     else if(n==2) total+=(4.5*m);
     else if(n==3) total+=(4.75*m);
     else if(n==4) total+=(4.35*m);
     else if(n==5) total+=(3.50*m);
     }
     else {
         System.out.println("You have entered a choice that is not on the menu. Please try again");
         continue;
     }
    }
    System.out.println("Proceeding to check-out.");
    System.out.println("Your total is: "+total); 
    System.out.println("Thank you. Have a nice day.");
    }
}
