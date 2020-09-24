package Array;

import java.util.Arrays;

class Array {
    int[] value;
    int[] weight;
    private int kelem; //кол-во элементов
    private int[] indx;

    public Array(int[] value, int[] weight) {
        this.value = value;
        this.weight = weight;
        kelem = 0;
        for (int weights : weight) {
            kelem += weights;
        }
        indx = new int[kelem];
        int cursor = 0;

        for(int i = 0; i < weight.length; i++){
            for(int j = 0; j < weight[i]; j++){
                indx[cursor++] = value[i];
            }
        }
    }
    public int Random() {
        int random = (int) (Math.random() * ( indx.length - 1));
        return indx[random];
    }

    @Override
    public String toString() {
        return "Array{" +
                "value=" + Arrays.toString(value) +
                ", weight=" + Arrays.toString(weight) +
                ", kelem=" + kelem +
                ", indx=" + Arrays.toString(indx) +
                '}';
    }
}

class Arraymain {
    public static void main(String[] args) {
        int Arrayv[]  = {1, 2, 3};
        int Arrayw[] = {1, 2, 10};
        Array KK = new Array(Arrayv, Arrayw);
            System.out.println(KK.Random());

        }
    }

