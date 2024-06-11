package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scan;
    Data data;
    Print print;


    Menu(){
        data = new Data();
        scan = new Scanner(System.in);
        print = new Print();
        while(true) {
            System.out.println("Menu:\n1-dodaj\n2-wyświetl\n3-zmień\n4-usuń\n5-zapisz zmiany");
            boolean passed;
            do {
                passed = true;
                switch (scan.nextInt()) {
                    case 1:
                        addElement();
                        break;
                    case 2:
                        wyswietl(chooseElements());
                        break;
                    case 3:
                        edit();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        data.save();
                        break;
                    default:
                        System.out.println("Wprowadź jedną lizcbę od 1 do 5:");
                        passed = false;
                }
            } while (!passed);
        }
    }

    private void delete() {
        int size = print.printWithId(data.getList());
        System.out.println("Wybier element od 1 do "+size);
        int choose = scan.nextInt();
        data.delete(choose);
    }

    private void edit() {
        int size = print.printWithId(data.getList());
        System.out.println("Wybier element od 1 do "+size);
        int choose = scan.nextInt();
        scan.nextLine();
        System.out.println("Wpisz nowy email(enter żeby pominąć):");
        String newData = scan.nextLine();
        if (!newData.equals("")){
            data.editEmail(newData, choose);
        }
        System.out.println("Wpisz nową date(enter żeby pominąć):");
        newData = scan.nextLine();
        if (!newData.equals("")){
            data.editDate(newData, choose);
        }
        System.out.println("Wpisz nowe imię(enter żeby pominąć):");
        newData = scan.nextLine();
        if (!newData.equals("")){
            data.editFirstName(newData, choose);
        }
        System.out.println("Wpisz nowe nazwisko(enter żeby pominąć):");
        newData = scan.nextLine();
        if (!newData.equals("")){
            data.editSecondName(newData, choose);
        }
    }

    private void addElement() {
        ArrayList<String> newElement = new ArrayList<>();
        for(String element: new String[]{"e-mail", "data_urodzenia", "imie", "nazwisko"}){
            System.out.println("Podaj "+element+":");
            if(element.equals("e-mail"))    scan.nextLine();
            newElement.add(scan.nextLine());
        }
        newElement.add("2004");
        data.addElement(newElement);
    }


    private void wyswietl(int elements){
        System.out.println("Wyświetl:\n1-wszystkie\n2-ostatnio dodane");
        boolean passed;
        do {
            passed = true;
            switch (scan.nextInt()){
                case 1:
                    print.print(data.getList() ,elements);
                    break;
                case 2:
                    print.print(data.getLastAdded() ,elements);
                    break;
                default:
                    System.out.println("Wprowadź jedną lizcbę od 1 do 2:");
                    passed = false;
            }
        } while (!passed);
    }

    private int chooseElements() {
        System.out.println("Jakie elementy chcesz wyświtlić:\n1-e-mail\n2-datę urodzenia\n3-imię\n4-nazwisko\n5-wszystkie");
        boolean passed;
        do {
            passed = true;
            int choose = scan.nextInt();
            if(choose<=5&&choose>0){
                return choose;
            }else{
                System.out.println("Wprowadź jedną lizcbę od 1 do 5:");
                passed = false;
            }
        } while (!passed);
        return 2;
    }


}
