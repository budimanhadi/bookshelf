/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshelf;

/**
 *
 * @author budiman hadi prayitno
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class crudBookShelf {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db_bookshelf";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    
    public static void main(String[] args) {
 
        try {
            Class.forName(JDBC_DRIVER);
                    
                    conn = DriverManager.getConnection(DB_URL,USER, PASS);
                    stmt = conn.createStatement();
                    
                    while (!conn.isClosed()) {
                        showMenu();
                    }
                    
                    stmt.close();
                    conn.close();
                    
                    
        } catch(Exception e) {
                e.printStackTrace();
                }
    }
    
    static void showMenu() {
        
        System.out.println("\n========= MAIN MENU =========");
        System.out.println("1. Insert Data");
        System.out.println("2. Show Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("0. Exit");
        System.out.println("");
        System.out.print("Choose > ");
        
        try {
        int pilihan = Integer.parseInt(input.readLine());

        switch (pilihan) {
            case 0:
                System.exit(0);
                break;
            case 1:
                insertBook();
                break;
            case 2:
                showData();
                break;
            case 3:
                updateBook();
                break;
            case 4:
                deleteBook();
                break;
            default:
                System.out.println("Pilihan salah!");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    static void showData(){
        String sql = "SELECT * FROM tb_book";
        try {
            rs = stmt.executeQuery(sql);

            System.out.println("+--------------------------------+");
            System.out.println("|    LIST BOOK IN LIBRARY   |");
            System.out.println("+--------------------------------+");
            while (rs.next()) {
                int idBook = rs.getInt("id_book");
                String slotNo = rs.getString("slot_no");
                String bookTitle = rs.getString("book_title");
                String author = rs.getString("author");

                System.out.println(String.format("%d. %s -- (%s)", idBook, slotNo, bookTitle, author));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static void insertBook() {
        try {
            
            
            System.out.print("Book Title: ");
            String bookTitle = input.readLine().trim();
            System.out.print("Author: ");
            String author = input.readLine().trim();
            System.out.print("Slot No: ");
            String slotNo = input.readLine().trim();

            
            String sql = "INSERT INTO tb_book (slot_no, book_title, author, create_by) VALUE('%s', '%s', '%s', 'Admin')";
            sql = String.format(sql, slotNo, bookTitle, author);

            
            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static void updateBook() {
        try {  
            
            System.out.print("ID yang mau diedit: ");
            int idBook = Integer.parseInt(input.readLine());
            System.out.print("Book Title: ");
            String bookTitle = input.readLine().trim();
            System.out.print("Author: ");
            String author = input.readLine().trim();
            System.out.print("Slot No: ");
            String slotNo = input.readLine().trim();
            String update_by = input.readLine().trim();
            

            
            String sql = "UPDATE tb_book SET book_title='%s', author='%s', slot_no='%s', update_by='Admin' WHERE id_book=%d";
            sql = String.format(sql, bookTitle, author, slotNo, update_by, idBook);

            
            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static void deleteBook() {
    try {
        
        
        System.out.print("ID yang mau dihapus: ");
        int idBook = Integer.parseInt(input.readLine());
        
        
        String sql = String.format("DELETE FROM tb_book WHERE id_book=%d", idBook);
        
        stmt.execute(sql);
        
        System.out.println("Data has been deleted.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}
