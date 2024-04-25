import java.io.File;


public class Main {
    public static void main(String[] args) {

// Antes de gravar um arquivo, garanta que a pasta existe
        File dotFolder = new File("dotFiles");
        if (!dotFolder.exists()) {
            dotFolder.mkdir(); // Cria a pasta se não existir
        }

        BST tree = new BST();

        // Inserção de valores na árvore
        tree.insert(45);
        tree.insert(25);
        tree.insert(70);
        tree.insert(15);
        tree.insert(35);
        tree.insert(55);
        tree.insert(85);

        System.out.println("Pre-ordem:");
        tree.preOrder();
        System.out.println("\nEm ordem:");
        tree.inOrder();
        System.out.println("\nPós-ordem:");
        tree.postOrder();

        System.out.println("\nProcurando 40: " + tree.search(40));
        System.out.println("Procurando 100: " + tree.search(100));

        // Remoção de valores
        tree.delete(20);
        System.out.println("Após remoção de 20, em ordem:");
        tree.inOrder();

         //Geração do arquivo DOT
        tree.generateDOTFile("dotFiles/ArvoreBinGerado.dot");
        System.out.println("Arquivo DOT gerado.");
    }
}