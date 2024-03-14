package org.javaarrayworkshop;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String arr[] = new String[0];

        NameRepository.find("Kalle Karlsson");
        NameRepository.add("Kalle Karlsson");
        NameRepository.add("Kalle Anka");
        NameRepository.add("Olle olsson");
        arr = NameRepository.findByFirstName("Kalle");
        NameRepository.printRepository("First names search array:",arr );
        arr = NameRepository.findByLastName("Karlsson");
        NameRepository.printRepository("Last names search array:",arr );
        NameRepository.update("Kalle Karlsson","Kalle Karlsson");
        NameRepository.remove("Kalle Karlsson");



    }

}
