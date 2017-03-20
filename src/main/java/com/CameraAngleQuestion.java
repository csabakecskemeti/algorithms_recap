package com;

import java.util.Arrays;

/**
 * Created by kecso on 3/14/17.
 */
public class CameraAngleQuestion {
    // camera has a view angle
    // we have points all around the camera
    // which camera angle the camera see the most points

    // solution proposal:
    // put points into an array represents the possible angles
    // view angle defines the size we see from the array
    // than max subarray like problem

    public static void main(String[] args) {
        System.out.println("Camera problem");
        int[][] points = {{1,1,-2,-3,3,2,1,6,-5,-5,-5}, {1,-1,2,-2,9,-10,7,6,-5,-5,-5}};
        System.out.println(bestOrientation(2, points));

//        int[] array = {1, 2, 3};
//        System.out.println(array[circularArray(array.length, 3)]);


    }

    private static int bestOrientation(int viewAngle, int[][] points) {
        int bestAngle = 0;
        int maxPoints = 0;
        int currMax = 0;
        int[] angleArray = pointToAngleArray(points);
        // init max
        for (int i = bestAngle - viewAngle/2; i <= bestAngle + viewAngle/2; i++) {
            currMax += angleArray[circularArray(angleArray.length, i)];
        }
        maxPoints = currMax;
        for (int i = 1; i < angleArray.length; i++) {
            currMax -= angleArray[circularArray(angleArray.length, i - viewAngle/2 - 1)];
            currMax += angleArray[circularArray(angleArray.length, i + viewAngle/2)];
            if (currMax > maxPoints) {
                maxPoints = currMax;
                bestAngle = i;
            }
        }
        System.out.println(maxPoints);
        return bestAngle - 180;
    }

    private static int[] pointToAngleArray(int[][] points) {
        if (points == null || points.length != 2) {
            return null;
        }
        int[] angleArray = new int[360];
        for (int i = 0; i < 360; i++) {
            angleArray[i] = 0;
        }
        for (int i = 0; i < points[0].length; i++) {
            int angle = (int)Math.toDegrees(Math.atan2(points[0][i], points[1][i]));
            angleArray[angle + 180] += 1;
        }
        return angleArray;
    }

    private static int circularArray(int arrayLength, int idx) {
        if (idx >= arrayLength) {
            return idx%arrayLength;
        } else if (idx < 0) {
            return arrayLength + idx;
        } else {
            return idx;
        }
    }
}
