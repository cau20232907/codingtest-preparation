import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n) {
        if (n < 2) {
            return n;
        }
        
        // 소인수분해
        Map<Integer, Integer> primeFactors = new HashMap<>();
        for(int i = 2; i * i <= n; i++) {
            // i * i <= n: i < Math.sqrt(n)
            while(n % i == 0) {
                primeFactors.put(i,
                                 primeFactors.getOrDefault(i, 0) + 1
                                );
                n /= i;
            }
        }
        if (n != 1) {
            primeFactors.put(n, 1);
        }
        
        return primeFactors.entrySet()
            .stream()
            .map(prime -> {
                List<Integer> multiples = new ArrayList<>();
                int value = 1;
                multiples.add(value);
                for(int i = 0; i < prime.getValue(); i++) {
                    value *= prime.getKey();
                    multiples.add(value);
                }
                return multiples;
            })
            .reduce(List.of(1),
                    (s1, s2) ->
                        s1.stream()
                            .flatMap(i -> s2.stream().map(j -> i * j))
                            .toList()
            )
            .stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}