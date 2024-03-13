package org.javaarrayworkshop;
import java.util.Scanner;
import java.util.Arrays;

public class NameRepository {
    static String[] strArrayRepository = new String[10];//Need to set a fixed size for name repository
    static String[] strFirstNameArr = new String[strArrayRepository.length];
    static String[] strLastNameArr = new String[strArrayRepository.length];
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
                    strFullName = getFullName("Enter full name");
                    bNameAdded = add(strFullName);
                    break;
                case 2:
                     strFullName = getFullName("Enter name to search for");
                     strSearchFullName = find(strFullName);
                     if(strSearchFullName != null){
                         System.out.println("The name " + strFullName + " is found in the repository");
                     }else{
                         System.out.println("The name "+ strFullName + " does not exist in the repository");
                     }
                     break;
                case 3:
                    strFullName = getFullName("Enter first name");
                    strFirstNameArr = findByFirstName(strFullName);
                    break;
                case 4:
                    strFullName = getFullName("Enter Last name");
                    strLastNameArr = findByLastName(strFullName);
                    break;
                case 5: printRepository("Full names in repository",strArrayRepository);
                    break;
                case 6:
                    printRepository("First names in repository",strFirstNameArr);
                    break;
                case 7:
                    printRepository("Last names in repository",strLastNameArr);
                    break;
                case 8:
                    System.out.println("ByBy");
                    break;
            }
        }while(iSelection!=8);

    }

    private static void showMeny(){
        System.out.println("**********************");
        System.out.println("1.Register/Add full name: " );
        System.out.println("2.Find by full name:     " );
        System.out.println("3.Find by first name: " );
        System.out.println("4.Find by last name: " );
        System.out.println("5.Print full name repository:" );
        System.out.println("6.Print first name repository:" );
        System.out.println("7.Print last name repository:" );
        System.out.println("8.Quit " );
        System.out.println("**********************");

    }
    private static int getSelection(){
        Scanner iScan = new Scanner(System.in);
        System.out.print("Enter menu choice: ");
        return  iScan.nextInt();

    }
    private static String getFullName(String strprint){
        Scanner strScan = new Scanner(System.in);
        System.out.print(strprint + ": ");
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
    private static void printRepository(String strHeading, String[] strPrntRepository){
        System.out.println(strHeading);
        System.out.println(Arrays.toString(strPrntRepository));
    }

    public static String[] findByFirstName(final String firstName){
        String strDecodeName ="";
        int iSpacePosition=0;
        int iSizeOfFirstNameArr = 0;
        int iFirstNameIndex=0;

        for (int i = 0; i < strArrayRepository.length; i++) {
            //Check for null
            if (strArrayRepository[i] == null) {
                continue;
            }
            //Get the first element from the repository and remove any space before and after the name
            strDecodeName = strArrayRepository[i].trim();
            //Check where in the string the space is
            iSpacePosition = strDecodeName.indexOf(" ");

            if (iSpacePosition > 0) {
                //Get the first name using position of space
                strDecodeName = strDecodeName.substring(0,iSpacePosition);
                //Check if it is the correct first name
                if (strDecodeName.equalsIgnoreCase(firstName)) {
                    iSizeOfFirstNameArr = strFirstNameArr.length;
                    //Add to the name to the temp arr
                    strFirstNameArr[iFirstNameIndex] = strArrayRepository[i];
                    iFirstNameIndex++;
                }

            }
        }
        return strFirstNameArr;

    }
   public static String[] findByLastName(final String lastName){
       String strDecodeName ="";
       int iSpacePosition=0;
       int iStringLength =0;
       int iLastNameIndex =0;

       for (int i = 0; i < strArrayRepository.length; i++) {
           //Check for null
           if (strArrayRepository[i] == null) {
               break;
           }
           //Get the first element from the repository and remove any space before and after the name
           strDecodeName = strArrayRepository[i].trim();
           //Check where in the string the space is
           iSpacePosition = strDecodeName.indexOf(" ");
           //Get the full length of the name string
           iStringLength = strDecodeName.length();

           if (iSpacePosition > 0) {
               //Get the last name using position of space
               strDecodeName = strDecodeName.substring(iSpacePosition,iStringLength);

               //Check if it is the correct last name
               if (strDecodeName.trim().equalsIgnoreCase(lastName)) {

                   //Add to the name to the last name arr
                   strLastNameArr[iLastNameIndex] = strArrayRepository[i];
                   iLastNameIndex++;
               }

           }
       }
       return strLastNameArr;
    }
 /*   public static boolean update(final String original, final String updatedName){
        //
    }

    private String decodeFirstName(String strfullName){
        return " ";
    }*/
}
