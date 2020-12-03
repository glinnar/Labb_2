package com.labb_2.Labb_2;
import java.io.*;

public class WriteToFile {
    private File contactList = null;
    private String filePath = "StrikerList.txt";

    public void createFile() throws IOException {
        contactList = new File(this.filePath);
        filePath = contactList.getPath();
        try {
            if (!contactList.exists()) {
                contactList.createNewFile();

                System.out.println("File " + filePath + "created");
            } else {
                System.out.println("File Allready exits");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeDataToFile(PlayerList list) throws IOException {
        try {
            FileOutputStream out = new FileOutputStream(this.contactList);
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(list);
            obs.flush();
            obs.close();
        } catch (ObjectStreamException e) {
            e.printStackTrace();
        }


    }
}
