import java.util.*;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

// Fractional Knapsack Problem
public class Knapsack {

    double getMaxValue(int W, Item arr[], int n) {
        Arrays.sort(arr, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        double totalValue = 0.0;
        for (int i = 0; i < n; i++) {
            if (arr[i].weight <= W) {
                W -= arr[i].weight;
                totalValue += arr[i].value;
            } else {
                totalValue += arr[i].value * ((double) W / arr[i].weight);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        Item arr[] = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        int W = 50;
        int n = arr.length;
        System.out.println("Maximum value we can obtain = " + knapsack.getMaxValue(W, arr, n));
    }
}

