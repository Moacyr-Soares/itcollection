package br.com.moacyr.itcollection.main;

public class Main {

    public void display() {
        System.out.println("""
            ===========================================================
                                LiterAlura
            -----------------------------------------------------------
                                 Menu
                       1- Buscar livros pelo título
                       2- Listar livros registrados
                       3- Listar autores registrados
                       4- Listar autores vivos em um determinado ano
                       5- Listar livros em um determinado idioma
                       0- Sair
            """);
    }

    public String getUrl(String urlBook){
        String url = "https://gutendex.com/books?search=" + urlBook;
        return url;
    }
}