import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        HashMap<String,Integer> playsByGenre=new HashMap<>();
        HashMap<String,Music[]> topByGenre=new HashMap<>();
        
        System.out.println(playsByGenre.containsKey("classic"));
        
        for(int i=0;i<genres.length;i++){
            playsByGenre.put(genres[i],
                             playsByGenre.getOrDefault(genres[i],0)+plays[i]);
            if(!topByGenre.containsKey(genres[i])){
                topByGenre.put(genres[i],new Music[]{new Music(i,plays[i]),null});
            }else if(topByGenre.get(genres[i])[0].plays<plays[i]){
                topByGenre.get(genres[i])[1]=topByGenre.get(genres[i])[0];
                topByGenre.get(genres[i])[0]=new Music(i,plays[i]);
            }else if(topByGenre.get(genres[i])[1]==null||
                     topByGenre.get(genres[i])[1].plays<plays[i]){
                topByGenre.get(genres[i])[1]=new Music(i,plays[i]);
            }
        }
        
        String[] genreRank=playsByGenre.entrySet().stream()
            .sorted((i,j)->i.getValue().compareTo(j.getValue())*-1)
            .map(i->i.getKey()).toArray(String[]::new);
        
        List<Integer> answer=new ArrayList<>();
        
        for(String genre:genreRank){
            Music[] musicOfGenre=topByGenre.get(genre);
            answer.add(musicOfGenre[0].id);
            if(musicOfGenre[1]!=null)
                answer.add(musicOfGenre[1].id);
        }
        return answer;
    }
    
    private class Music{
        //private 및 getter 생략
        final int plays;
        final int id;
        Music(int id, int plays){
            this.id=id;
            this.plays=plays;
        }
    }
}
/*
장르별 재생 횟수 정렬
장르별 top 2 저장
*/