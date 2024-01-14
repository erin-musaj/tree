import java.io.File;

public class Main {
    public static void tree(File dir, int offset) {
        for (int i = 0; i < offset; i++) {
            System.out.print("|   ");
        }
        System.out.println("|--" + dir.getName());
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    tree(file, offset + 1);
                } else {
                    for (int i = 0; i <= offset; i++) {
                        System.out.print("|   ");
                    }
                    System.out.println("|-- " + file.getName());
                }
            }
        }
    }

    public static void tree(File dir){
        tree(dir, 0);
    }

    public static void main(String[] args) {
        File root = new File(args[0]);
        if (root.exists() && root.isDirectory()) {
            tree(root);
        } else {
            System.out.println("Percorso non valido");
        }
    }
}
