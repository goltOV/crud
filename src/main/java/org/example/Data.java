package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    File dane = new File("D:\\workSpace\\java\\desc\\crud\\src\\main\\java\\org\\example\\tajne_dane.csv");
    ArrayList<UserData> data = new ArrayList<>();
    ModifyData modifyData = new ModifyData();
    ArrayList<UserData> sortedData = new ArrayList<>();

    Data() {
        try {
            Scanner scan = new Scanner(dane);
            while(scan.hasNext()){
                String[] user = scan.nextLine().split(";");
                data.add(new UserData(user[0],user[1],user[2],user[3],user[4]));
            }
        }catch (FileNotFoundException e) {}
        sortedData = modifyData.sort(data);
    }


    public ArrayList<UserData> getList() {
        return sortedData;
    }

    public ArrayList<UserData> getLastAdded() {
        ArrayList<UserData> last = new ArrayList<>();
        last.add(sortedData.get(0));
        return last;
    }

    public void addElement(ArrayList<String> newElement) {
        data = modifyData.addElement(data,newElement);
        sortedData = modifyData.sort(data);
    }

    public void save() {
        try{
            FileWriter writer = new FileWriter(dane);
            for (UserData element: data){
                writer.write(element.getString());
                writer.write("\n");
            }
            writer.close();
            System.out.println("Zmiany zostały zapisane");
        } catch (IOException e){
            System.out.println("Zmiany nie zostały zapisane");
        }
    }

    public void editEmail(String newMail,int i) {
        data = modifyData.edit(data,0, i, newMail);
        sortedData = modifyData.sort(data);
    }

    public void editDate(String newDate,int i) {
        data = modifyData.edit(data,1, i, newDate);
        sortedData = modifyData.sort(data);
    }

    public void editFirstName(String newFirstName,int i) {
        data = modifyData.edit(data,2, i, newFirstName);
        sortedData = modifyData.sort(data);
    }

    public void editSecondName(String newSecondName,int i) {
        data = modifyData.edit(data,3, i, newSecondName);
        sortedData = modifyData.sort(data);
    }

    public void delete(int id) {
        data = modifyData.delete(data, id);
        sortedData = modifyData.sort(data);
    }
}
