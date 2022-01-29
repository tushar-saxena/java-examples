package com.ts.javaexamples.employee;

import java.util.Scanner;
import java.util.Stack;

public class RectArea
{
    static int getMaxAreaOfHistogram(int histogramArray[], int n)
    {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int element;
        int areaWithTop;

        int i = 0;
        while (i < n)
        {
            if (stack.empty() || histogramArray[stack.peek()] <= histogramArray[i])
                stack.push(i++);
            else
            {
                element = stack.peek();
                stack.pop();
                areaWithTop = histogramArray[element] * (stack.empty() ? i : i - stack.peek() - 1);
                if (maxArea < areaWithTop)
                    maxArea = areaWithTop;
            }
        }

        while (stack.empty() == false)
        {
            element = stack.peek();
            stack.pop();
            areaWithTop = histogramArray[element] * (stack.empty() ? i : i - stack.peek() - 1);
            if (maxArea < areaWithTop)
                maxArea = areaWithTop;
        }

        return maxArea;
    }

    public static void main(String[] args)
    {
//        int histogramArray[] = { 6, 2, 5, 4, 5, 1, 6 };
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size = scanner.nextInt();
        System.out.println("Enter the array element space separated");
        int[] histogramArray = new int[size];
        for (int i = 0; i < size; i++){
            histogramArray[i] = scanner.nextInt();
        }
        System.out.println("Maximum area found is " + getMaxAreaOfHistogram(histogramArray, histogramArray.length));
    }
}
