package org.example;

import java.util.ArrayList;

public class Print {
    ArrayList<UserData> list;
    int elements;

    public void print(ArrayList<UserData> list, int elements) {
        this.list = list;
        this.elements = elements;
        switch (elements){
            case 1:
                printEmail();
                break;
            case 2:
                printDate();
                break;
            case 3:
                printFirstName();
                break;
            case 4:
                printSecondName();
                break;
            case 5:
                printAll();
                break;

        }




    }

    void printSecondName() {
        for (UserData element: list){
            System.out.println(element.getSecondName());
        }
    }

    void printFirstName() {
        for (UserData element: list){
            System.out.println(element.getFirstName());
        }
    }

    void printDate() {
        for (UserData element: list){
            System.out.println(element.getDate());
        }
    }

    void printEmail() {
        for (UserData element: list){
            System.out.println(element.getEmail());
        }
    }

    private void printAll(){
        for (UserData element: list){
            System.out.println(element.getEmail()+" | "
                    +element.getDate()+" | "
                    +element.getFirstName()+" | "
                    +element.getSecondName());
        }
    }

    int printWithId(ArrayList<UserData> list){
        this.list = list;
        for (int i = 1; i <= list.size(); i++){
            UserData element = list.get(i-1);
            System.out.println(i+" - "+
                    element.getEmail()+" | "
                    +element.getDate()+" | "
                    +element.getFirstName()+" | "
                    +element.getSecondName());
        }
        return list.size();
    }
}
