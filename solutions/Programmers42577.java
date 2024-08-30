package solutions;

import java.util.*;

class Programmers42577 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];
            int n = s.length();
            int j = i + 1;
            if (j < phone_book.length && phone_book[j].length() > n) {
                String temp = phone_book[j].substring(0, n);
                if (i != j && s.compareTo(temp) == 0) {
                    return false;
                }
            }          
        }
        
        return true;
    }
}