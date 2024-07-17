package br.com.moacyr.itcollection.model;

import java.util.Scanner;

public class UserInteraction {

    private Scanner sc;

    public UserInteraction(){
        this.sc = new Scanner(System.in);
    }

    public int getOptionFromUser(){
        System.out.println("""
                                        Escolha uma opção válida:
                                        ************************** 
                           """);
        return sc.nextInt();
    }
    public String findBook(){
        System.out.println("Insira o nome do livro que você deseja procurar ");
        return sc.nextLine();
    }
}
