package org.javaarrayworkshop;
import java.util.Scanner;
import java.util.Arrays;

public class NameRepository {
    static String strArrayRepository[]= new String[10];//Need to set a fixed size for name repository
    static int iCountStoredNames = 0;
    public static void main(String[] args) {

        //String strArrayRepository[]= new String[10];
        String strFullName = ""; //Store the entered full name
        String strSearchFullName = ""; //Returned searched name or null

        int iSelection=0; //Meny selection
        boolean bNameAdded = false;

        do{
            showMeny();
            iSelection = getSelection();

            switch (iSelection){
                case 1:
                    strFullName = getFullName();
                    bNameAdded = add(strFullName);
                    break;
                case 2:
                     strFullName = getFullName();
                     strSearchFullName = find(strFullName);
                     if(strSearchFullName != null){
                         System.out.println("Name: " + strSearchFullName + " found in the repository");
                     }else{
                         System.out.println("The Name does not exist in the repository");
                     }
                     break;
                case 3: printRepository();
                    break;
                case 5:
                    System.out.println("ByBy");
                    break;
            }
        }while(iSelection!=5);

    }

    private static void showMeny(){
        System.out.println("**********************");
        System.out.println("1.Register/Add full name: " );
        System.out.println("2.Find full name:     " );
        System.out.println("3.Print name repository:" );
        System.out.println("5.Quit " );
        System.out.println("**********************");

    }
    private static int getSelection(){
        Scanner iScan = new Scanner(System.in);
        System.out.print("Enter meny choice: ");
        return  iScan.nextInt();

    }
    private static String getFullName(){
        Scanner strScan = new Scanner(System.in);
        System.out.print("FullName: ");
        return strScan.nextLine();

    }
    public static String find(final String fullName){

           String searchName = null;
           for (String name : strArrayRepository) {
               if(name == null) continue;
               if (name.equalsIgnoreCase(fullName)) {
                   searchName = name;
                   break;
               }

           }
           return searchName;



    }
    public static boolean add(final String fullName){
        boolean bSavedName = false;
        if(find(fullName) != null){
            bSavedName = false; //is in the registry

        }else{
            //Save the name
            saveName(fullName);
            bSavedName = true; //Name saved
        }
        return bSavedName;

    }

    private static void saveName(String strFullName){
        //Check if this is the first name in the array
        //1. Check the name counter.
        if(iCountStoredNames == 0 && strArrayRepository[0] == null){
            //Store the first name
            strArrayRepository[0] = strFullName;
            iCountStoredNames++;
        }else if(iCountStoredNames > 0 && iCountStoredNames < strArrayRepository.length) {
            //Store name
            strArrayRepository[iCountStoredNames] = strFullName;
            iCountStoredNames++;
        }else {
            System.out.println("Name repository is full,try another day");
        }
        //return iNameCount;


    }
    private static void printRepository(){
        System.out.println("Names in repository");
        System.out.println(Arrays.toString(strArrayRepository));
    }


}
