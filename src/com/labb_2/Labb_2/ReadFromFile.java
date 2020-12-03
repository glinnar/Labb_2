package com.labb_2.Labb_2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public class ReadFromFile {




    /*
    * FileInputStream fin = new FileInputStream("test.txt");
            ObjectInputStream in = new ObjectInputStream(fin);


            list2 = (ArrayList<Contact>)in.readObject();
            System.out.println(list2 +"\n");

            in.close();*/


    public void readFromFile() throws IOException, ClassNotFoundException {

        //ArrayList<Striker> slist = new ArrayList<>();

        try {
            FileInputStream fin = new FileInputStream("StrikerList.txt");
            ObjectInputStream in = new ObjectInputStream(fin);
            //list = (PlayerList) in.readObject();

            PlayerList list;
            list=(PlayerList) in.readObject();

            list.listStriker();




           in.close();
           fin.close();



           // lister = list;

            //assert list != null;
            //lister.listStriker();

        } catch (InvalidObjectException e){
            e.printStackTrace();
            System.out.println("Något gick fel");
        }

    }

}
