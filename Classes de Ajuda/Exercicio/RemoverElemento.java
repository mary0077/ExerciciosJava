import java.util.Arrays;

public class RemoverElemento {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        
        int[] novoArray = new int[arr.length - 1];
        
        for (int i = 1; i < arr.length; i++) {
            novoArray[i - 1] = arr[i];
        }
        
        System.out.println("Novo array após remoção: ");
        for (int num : novoArray) {
            System.out.print(num + " ");
        }
    }
}
