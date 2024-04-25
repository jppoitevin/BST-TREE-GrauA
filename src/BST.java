import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class BST {
    Node root;

    // Inserção de um novo nodo
    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Busca por um valor específico
    boolean search(int value) {
        return searchRec(root, value);
    }

    boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        if (value < root.value) {
            return searchRec(root.left, value);
        } else {
            return searchRec(root.right, value);
        }
    }

    // Caminhamentos: pré-ordem, em ordem e pós-ordem
    void preOrder() {
        preOrderRec(root);
    }

    void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    void inOrder() {
        inOrderRec(root);
    }

    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }

    void postOrder() {
        postOrderRec(root);
    }

    void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Remoção de um nodo
    void delete(int value) {
        root = deleteRec(root, value);
    }

    Node deleteRec(Node root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    int minValue(Node root) {
        int minV = root.value;
        while (root.left != null) {
            minV = root.left.value;
            root = root.left;
        }
        return minV;
    }

    // Geração do arquivo DOT para visualização
    void generateDOTFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("BST {");
            writer.newLine();
            generateDOTRec(root, writer);
            writer.write("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void generateDOTRec(Node node, BufferedWriter writer) throws IOException {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            writer.write(node.value + " -> " + node.left.value + ";");
            writer.newLine();
            generateDOTRec(node.left, writer);
        }
        if (node.right != null) {
            writer.write(node.value + " -> " + node.right.value + ";");
            writer.newLine();
            generateDOTRec(node.right, writer);
        }
    }
}