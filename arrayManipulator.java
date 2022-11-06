import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//John has finally become a junior developer and has received his first task. It's about manipulating an array of integers. He is not quite happy about it, since he hates manipulating arrays.
// They will pay him a lot of money, though, and he is willing to give somebody half of it if to help him do his job. You, on the other hand, love arrays (and money) so you decide to try your luck.
//The array may be manipulated by one of the following commands:
//    • exchange {index} – splits the array after the given index and exchanges the places of the two resulting subarrays. E.g. [1, 2, 3, 4, 5] -> exchange 2 -> result: [4, 5, 1, 2, 3]
//        ◦ If the index is outside the boundaries of the array, print "Invalid index".
//    • max even/odd – returns the INDEX of the max even/odd element -> [1, 4, 8, 2, 3] -> max odd -> print 4
//    • min even/odd – returns the INDEX of the min even/odd element -> [1, 4, 8, 2, 3] -> min even > print 3
//        ◦ If there are two or more equal min/max elements, return the index of the rightmost one.
//        ◦ If a min/max even/odd element cannot be found, print "No matches".
//    • first {count} even/odd – returns the first {count} elements -> [1, 8, 2, 3] -> first 2 even -> print [8, 2]
//    • last {count} even/odd – returns the last {count} elements -> [1, 8, 2, 3] -> last 2 odd -> print [1, 3]
//        ◦ If the count is greater than the array length, print "Invalid count".
//        ◦ If there are not enough elements to satisfy the count, print as many as you can. If there are zero even/odd elements, print an empty array "[]".
//    • end – stop taking input and print the final state of the array.

public class arrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //reading initial input as string then filling in an array
        String input = scanner.nextLine();
        String[] initialArray = input.split(" ");

        //reading the very first command given and adding to an array for easier looping through
        String command = scanner.nextLine();
        String[] commandArr = command.split(" ");

        //adding the initial array to an arrayList for easier manipulation
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < initialArray.length; i++) {
            arrayList.add(initialArray[i]);

        }

        while (!commandArr[0].equals("end")) {

            if (commandArr[0].equals("exchange")) {
                if (Integer.parseInt(commandArr[1]) > arrayList.size()) {
                    System.out.println("Invalid index");
                    command = scanner.nextLine();
                    commandArr = command.split(" ");
                    continue;
                }
                int splitIndex = Integer.parseInt(commandArr[1]);
                List<String> temp = new ArrayList<>();
                //adding after index values to a temporary arraylist
                for (int i = splitIndex + 1; i < initialArray.length; i++) {
                    temp.add(arrayList.get(i));
                }
                //removing the values from the initial arraylist
                for (int i = arrayList.size() - 1; i > splitIndex; i--) {
                    arrayList.remove(i);
                }
                //adding the removed to the start of the initial arrayList
                for (int i = 0; i < temp.size(); i++) {
                    arrayList.add(i, temp.get(i));
                }

            }
            if (commandArr[0].equals("max")) {
                if (commandArr[1].equals("even")) {
                    int biggestEven = 0;
                    int index = 0;
                    boolean found = false;
                    //finds the biggest even
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (Integer.parseInt(arrayList.get(i)) % 2 == 0) {
                            if (Integer.parseInt(arrayList.get(i)) >= biggestEven) {
                                biggestEven = Integer.parseInt(arrayList.get(i));
                                index = i;
                                found = true;
                            }
                        }
                    }
                    if (found) {
                        System.out.println(index);
                    }else{
                        System.out.println("No matches");
                    }
                } else if (commandArr[1].equals("odd")) {
                    int biggestOdd = 0;
                    int index = 0;
                    boolean found = false;
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (Integer.parseInt(arrayList.get(i)) % 2 != 0){
                            if (Integer.parseInt(arrayList.get(i)) >= biggestOdd){
                                biggestOdd = Integer.parseInt(arrayList.get(i));
                                index = i;
                                found = true;
                            }
                        }
                    }
                    if (found) {
                        System.out.println(index);
                    }else{
                        System.out.println("No matches");
                    }
                }
            }
            if (commandArr[0].equals("min")){
                if (commandArr[1].equals("even")) {
                    int minEven = 0;
                    int index = 0;
                    boolean found = false;
                    //finds the biggest even
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (Integer.parseInt(arrayList.get(i)) % 2 == 0) {
                            if (Integer.parseInt(arrayList.get(i)) <= minEven) {
                                minEven = Integer.parseInt(arrayList.get(i));
                                index = i;
                                found = true;
                            }
                        }
                    }
                    if (found) {
                        System.out.println(index);
                    }else{
                        System.out.println("No matches");
                    }
                } else if (commandArr[1].equals("odd")) {
                    int minOdd = 0;
                    int index = 0;
                    boolean found = false;
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (Integer.parseInt(arrayList.get(i)) % 2 != 0){
                            if (Integer.parseInt(arrayList.get(i)) <= minOdd){
                                minOdd = Integer.parseInt(arrayList.get(i));
                                index = i;
                                found = true;
                            }
                        }
                    }
                    if (found) {
                        System.out.println(index);
                    }else{
                        System.out.println("No matches");
                    }
                }

            }
            if (commandArr[0].equals("first")){
                if (Integer.parseInt(commandArr[1]) > arrayList.size()){
                    System.out.println("Invalid count");
                    command = scanner.nextLine();
                    commandArr = command.split(" ");
                    continue;
                }
                if (commandArr[2].equals("even")){
                    int breakCounter = 0;
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (breakCounter >= Integer.parseInt(commandArr[1])){
                            break;
                        }
                        if (Integer.parseInt(arrayList.get(i)) % 2 == 0){
                            System.out.print(arrayList.get(i)+ " ");
                            breakCounter++;
                        }
                    }
                    if (breakCounter == 0){
                        System.out.println("[]");
                    }
                    System.out.println();
                }else if (commandArr[2].equals("odd")){
                    int breakCounter = 0;
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (breakCounter >= Integer.parseInt(commandArr[1])){
                            break;
                        }
                        if (Integer.parseInt(arrayList.get(i)) % 2 != 0){
                            System.out.print(arrayList.get(i)+ " ");
                            breakCounter++;
                        }
                    }
                    if (breakCounter == 0){
                        System.out.println("[]");
                    }
                    System.out.println();
                }
            }
            if (commandArr[0].equals("last")){
                if (Integer.parseInt(commandArr[1]) > arrayList.size()){
                    System.out.println("Invalid count");
                    command = scanner.nextLine();
                    commandArr = command.split(" ");
                    continue;
                }
                if (commandArr[2].equals("even")){
                    int breakCounter = 0;
                    for (int i = arrayList.size()-1; i >= 0 ; i--) {
                        if (breakCounter >= Integer.parseInt(commandArr[1])){
                            break;
                        }
                        if (Integer.parseInt(arrayList.get(i)) % 2 == 0){
                            System.out.print(arrayList.get(i)+ " ");
                            breakCounter++;
                        }
                    }
                    if (breakCounter == 0){
                        System.out.println("[]");
                    }
                    System.out.println();
                }else if (commandArr[2].equals("odd")){
                    int breakCounter = 0;
                    for (int i = arrayList.size()-1; i >= 0 ; i--) {
                        if (breakCounter >= Integer.parseInt(commandArr[1])){
                            break;
                        }
                        if (Integer.parseInt(arrayList.get(i)) %2 != 0){
                            System.out.print(arrayList.get(i)+" ");
                            breakCounter++;
                        }

                    }
                    if (breakCounter == 0){
                        System.out.println("[]");
                    }
                    System.out.println();
                }
            }

            command = scanner.nextLine();
            commandArr = command.split(" ");
        }
        System.out.println(arrayList);
    }
}
