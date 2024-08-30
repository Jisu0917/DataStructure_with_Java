package solutions;

import java.util.Arrays;
import java.util.Comparator;

class Programmers42746 {
    public String solution(int[] numbers) {
        String[] array = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }

        // 배열을 내림차순으로 정렬
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab);
            }
        });
        

        // 정렬된 결과에서 불필요한 문자 제거하고 숫자만 남김
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }

        // 결과가 0으로 시작하면 "0" 반환
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
