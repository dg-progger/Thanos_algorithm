package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {97,13, 78, 5, 7};
        int[] sec_array = new int[array.length];
        thanos_sort(array, sec_array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    public static void thanos_sort(int[] main_array, int[] second_array, int start_index, int end_index) {
        if (start_index == end_index) {
            return;
        }
        double average = get_average(main_array, start_index, end_index);
        int left_counter;
        int right_counter;
        left_counter = start_index;
        right_counter = end_index;
        for (int i = start_index; i <= end_index; i++) {
            if (main_array[i] <= average) {
                second_array[left_counter] = main_array[i];
                left_counter = left_counter + 1;

            }
            else {
                second_array[right_counter] = main_array[i];
                right_counter = right_counter - 1;
            }
        }

        for (int j = start_index; j <= end_index; j++) {
            main_array[j] = second_array[j];
        }
        thanos_sort(main_array, second_array, start_index, right_counter);
        thanos_sort(main_array, second_array,right_counter + 1, end_index);
    }

    public static double get_average(int[] arr, int start_index, int end_index) {
        double avg;
        avg = 0;
        for (int i = start_index; i < end_index + 1; i++) {
            double x = arr[i];
            avg = avg + x;
        }
        double y = end_index - start_index + 1;
        avg = avg / y;
//        System.out.println(avg);
        return avg;
    }
}
