package com.example.LiterAlura.principal;

import com.example.LiterAlura.models.Book;
import com.example.LiterAlura.models.DadosBook;
import com.example.LiterAlura.models.DadosBooks;
import com.example.LiterAlura.repositories.BookRepository;
import com.example.LiterAlura.service.ConsumoAPI;
import com.example.LiterAlura.service.ConverteDados;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/";
    private ObjectMapper mapper = new ObjectMapper();
    private BookRepository repositorio;

    public void exibeMenu() {
        var opcao = -1;
        while(opcao != 0) {
            var menu = """
                    1 - buscar livro por titulo
                    2 - listar livros registrados
                    3 - listar autores registrados
                    4 - listar autores vivos apartir de ano
                    5 - listar livros conforme idioma      
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch(opcao) {
                case 1:
                    buscarBookWeb();
                    break;
                case 2:
                    listarBooks();
                    break;
                case 3:
                    listarAuthors();
                    break;
                case 4:
                    listarAuthorPorAno();
                case 5:
                    listarBookPorIdioma();
                    break;
                case 0:
                    System.out.println("saindo");
                    break;
                default:
                    System.out.println("opcao invalida (" + opcao + ")");
            }
        }
    }

    private void listarBookPorIdioma() {
    }

    private void listarAuthorPorAno() {
    }

    private void listarAuthors() {
    }

    private void listarBooks() {
    }

    public void buscarBookWeb() {
        List<DadosBook> dados = getDadosBook();
        List<Book> books = new ArrayList<>();
        for(int i = 0; i < dados.size(); i++) {
            Book book = new Book(dados.get(0));
            books.add(book);
        }
        books.forEach(System.out::println);
    }

    public List<DadosBook> getDadosBook() {
        System.out.print("nome do livro: ");
        var nomeLivro = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + "books?search=" + nomeLivro.replace(" ", "%20"));
        List<DadosBook> books;
        try {
            books = mapper.readValue(json, new TypeReference<List<DadosBook>>() {});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}
