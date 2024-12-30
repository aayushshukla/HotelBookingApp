package services;

import java.util.Scanner;

public class PaymentService {

    public  int payment()
    {
        int dailyCharges=1000;
        Scanner sc = new Scanner(System.in);
        System.out.println("Payment type  is prepaid ?");
        boolean paymentType=sc.nextBoolean();
        if(paymentType)
        {
            System.out.println("Enter no of persons");
            int noOfPersons=sc.nextInt();
            System.out.println("How many days");
            int days=sc.nextInt();
            int totalBill = (noOfPersons*dailyCharges)*days;
            return  totalBill;
        }
        else
        {
            return  -1;
        }

    }
}
