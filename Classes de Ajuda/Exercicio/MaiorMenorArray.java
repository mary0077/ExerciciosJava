public class MaiorMenorArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 2, 8, 1};
        int maior = arr[0];
        int menor = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maior) maior = arr[i];
            if (arr[i] < menor) menor = arr[i];
        }
        
        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);
    }
}
