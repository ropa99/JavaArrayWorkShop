package org.javaarrayworkshop;
import java.util.Scanner;
import java.util.Arrays;

public class NameRepository {
    static String names[]= new String[0];


    public static String find(final String fullName){

        String searchName = null;
        for (String name : names) {

            if (compareStrings(name,fullName)) {
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
            //Create a copy names array
            String namesCopy[] = new String[names.length +1] ;
            //Copy content of old names array to new array
            namesCopy = Arrays.copyOf(names,names.length+1);
            //Add new name to last position of new array
            namesCopy[namesCopy.length - 1]= fullName;
            //Set new arr to old arr
            names=namesCopy;
            bSavedName = true; //Name saved
        }
        return bSavedName;

    }

    public static String[] findByFirstName(final String firstName){
        String strDecodeName ="";
        int iSpacePosition=0;
        int iSizeOfFirstNameArr = 0;
        int iFirstNameIndex=0;
        String[] strFirstNameArr = new String[0];

        for (int i = 0; i < names.length; i++) {


                   //Get the first element from the repository and remove any space before and after the name
                    strDecodeName = names[i].trim();
                    //Check where in the string the space is
                    iSpacePosition = strDecodeName.indexOf(" ");

                    if (iSpacePosition > 0) {
                        //Get the first name using position of space
                        strDecodeName = getSubString(strDecodeName,0,iSpacePosition);
                        //Check if it is the correct first name
                        if (compareStrings(strDecodeName,firstName)) {

                            //Create a copy names array
                            String tempArray[] = new String[strFirstNameArr.length +1] ;
                            //Copy content of old names array to new array
                            tempArray = Arrays.copyOf(strFirstNameArr,strFirstNameArr.length+1);
                            //Add new name to last position of new array
                            tempArray[tempArray.length - 1]= names[i];
                            //Set new arr to old arr
                            strFirstNameArr=tempArray;


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
        String[] strLastNameArr = new String[0];

        for (int i = 0; i < names.length; i++) {

            //Get the first element from the repository and remove any space before and after the name
            strDecodeName = names[i].trim();
            //Check where in the string the space is
            iSpacePosition = strDecodeName.indexOf(" ");
            //Get the full length of the name string
            iStringLength = strDecodeName.length();

            if (iSpacePosition > 0) {
                //Get the last name using position of space
                strDecodeName = getSubString(strDecodeName,iSpacePosition,iStringLength);
                //Check if it is the correct last name
                if (compareStrings (strDecodeName,lastName)) {


                    //Create a copy names array
                    String tempArray[] = new String[strLastNameArr.length +1] ;
                    //Copy content of old names array to new array
                    tempArray = Arrays.copyOf(strLastNameArr,strLastNameArr.length+1);
                    //Add new name to last position of new array
                    tempArray[tempArray.length - 1]= names[i];
                    //Set new arr to old arr
                    strLastNameArr=tempArray;
                }

            }
        }
        return strLastNameArr;
    }


    public static boolean update(final String original, final String updatedName){
        boolean retValue=false;
        //Check if the original name or the name to update  exist in the repository
        if(find(original) == null && find(updatedName) == null) {
            retValue  = false;
        }else {
            //update the name
            for (int i = 0; i < names.length; i++) {
                if (compareStrings(names[i], original)) {
                    names[i] = updatedName;
                    retValue =  true;
                }

            }
        }
        //printRepository("After update:", names);
        return retValue;

    }

    public static boolean remove(final String fullName){
        int i,x =0;
        //Check if name in names repository
        if(find(fullName) == null){ //name not found
            return false;
        }
        //printRepository("Before remove:", names);
        //Create an temp array with new size names -1
        String tempArray[]= new String[names.length - 1];
        //Move the other names to the temp array
        for (i = 0; i < names.length; i++) {
            if(!compareStrings(names[i],fullName)){
                tempArray[x] = names[i];
                x++;
            }

        }
        //Set temp array = to old array
        names = tempArray;
        //printRepository("After remove:", names);
        return true;
    }

    private static String getSubString(String strToDecode,int startPosition,int endPosition){
        return strToDecode.substring(startPosition,endPosition);
    }

    private static boolean compareStrings(String oldString,String newString){
        if (oldString.trim().equalsIgnoreCase(newString) ) {
            return true;

        } else{
            return false;
        }


    }


    public static void printRepository(String strHeading, String[] strPrntRepository){
        System.out.println(strHeading);
        System.out.println(Arrays.toString(strPrntRepository));
    }

}
