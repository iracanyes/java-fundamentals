/*
* The values stored in the elements of an array parameter can always be changed inside the method
*/
package com.jdojo.array;

import java.util.Arrays;

public class ModifyArrayElements{
    public static void main(String[] args) {
        int[] originNums = { 10, 84, 95};
        String[] originNames = {"Mike", "Tyson"};
        System.out.printf("Before method call, originNums: %s%n", Arrays.toString(originNums));
        System.out.printf("Before method call, originNames: %s%n", Arrays.toString(originNames));

        // Call methods
        tryElementChange(originNums);
        tryElementChange(originNames);

        System.out.printf("After method call, originNums: %s%n", Arrays.toString(originNums));
        System.out.printf("After method call, originNames: %s%n", Arrays.toString(originNames));
    }

    public static void tryElementChange(int[] nums){
        //
        if(nums != null & nums.length > 0){
            nums[0] = 654;
        }
    }

    public static void tryElementChange(String[] names){
        //
        if(names != null & names.length > 0){
            names[0] = "Kaenu";
        }
    }
}
