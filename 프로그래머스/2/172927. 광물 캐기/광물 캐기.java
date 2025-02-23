import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        PriorityQueue<Minerals> queue=new PriorityQueue<>(Collections.reverseOrder());
        int axe=Arrays.stream(picks).sum();
        for(int i=0;i<axe*5&&i<minerals.length;i+=5){
            int diamond=0;
            int iron=0;
            int stone=0;
            for(int j=i;j<i+5&&j<minerals.length;j++){
                switch(minerals[j]){
                    case "diamond":{
                        diamond++;
                        break;
                    }
                    case "iron":{
                        iron++;
                        break;
                    }
                    case "stone":{
                        stone++;
                        break;
                    }
                }
            }
            queue.add(new Minerals(diamond,iron,stone));
        }
        int answer=0;
        //diamond axe
        for(int i=0;i<picks[0]&&!queue.isEmpty();i++){
            Minerals current=queue.poll();
            answer+=current.diamond+current.iron+current.stone;
        }
        
        //iron axe
        for(int i=0;i<picks[1]&&!queue.isEmpty();i++){
            Minerals current=queue.poll();
            answer+=current.diamond*5+current.iron+current.stone;
        }
        
        //diamond axe
        for(int i=0;i<picks[2]&&!queue.isEmpty();i++){
            Minerals current=queue.poll();
            answer+=current.diamond*25+current.iron*5+current.stone;
        }
        return answer;
    }
    private class Minerals implements Comparable<Minerals>{
        final int diamond;
        final int iron;
        final int stone;
        Minerals(int diamond, int iron, int stone){
            this.diamond=diamond;
            this.iron=iron;
            this.stone=stone;
        }
        public int compareTo(Minerals other){
            int diff=Integer.compare(this.diamond, other.diamond);
            if(diff!=0) return diff;
            diff=Integer.compare(this.iron, other.iron);
            if(diff!=0) return diff;
            return Integer.compare(this.stone, other.stone);
        }
    }
}