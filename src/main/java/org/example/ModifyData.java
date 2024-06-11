package org.example;

import java.util.ArrayList;

public class ModifyData {

    ArrayList<UserData> addElement(ArrayList<UserData> list,ArrayList<String> newElement){
        list.add(new UserData(
                newElement.get(0),
                newElement.get(1),
                newElement.get(2),
                newElement.get(3),
                newElement.get(4)
        ));

        return list;
    }

    public ArrayList<UserData> sort(ArrayList<UserData> list) {
        ArrayList<UserData> sortedList = new ArrayList<>();
        int maxYear = 0;
        for (UserData element: list){
            int year = element.getYear();
            if (maxYear<year)   maxYear = year;
        }
        int minYear = maxYear;
        for (UserData element: list){
            int year = element.getYear();
            if (minYear>year)   minYear = year;
        }
//        System.out.println(minYear+"   "+maxYear);
        for (int i = minYear; i <= maxYear; i++){
            for (int j = list.size()-1; j >= 0; j--){
                UserData element = list.get(j);
                int year = element.getYear();
                if (i==year)   sortedList.add(element);
//                System.out.println("1");
            }
        }

        return sortedList;
    }

    public ArrayList<UserData> edit(ArrayList<UserData> list,int element, int i, String newElement) {
        UserData row = list.get(i);
        list.remove(i);
        switch (element){
            case 0:
                list.add(i,new UserData(newElement,row.getDate(),row.getFirstName(), row.getSecondName(), String.valueOf(row.getYear())));
                break;
            case 1:
                list.add(i,new UserData(row.getEmail(),newElement,row.getFirstName(), row.getSecondName(), String.valueOf(row.getYear())));
                break;
            case 2:
                list.add(i,new UserData(row.getEmail(),row.getDate(),newElement, row.getSecondName(), String.valueOf(row.getYear())));
                break;
            case 3:
                list.add(i,new UserData(row.getEmail(),row.getDate(),row.getFirstName(), newElement, String.valueOf(row.getYear())));
                break;
        }

        return list;
    }

    public ArrayList<UserData> delete(ArrayList<UserData> data, int id) {
        data.remove(id);
        return data;
    }
}
