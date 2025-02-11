import java.util.Arrays;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map=new int[m][n];
        for(int i=0;i<puddles.length;i++){
            map[puddles[i][0]-1][puddles[i][1]-1]=Integer.MIN_VALUE;
        }
        for(int j=0;j<m;j++){
            if(map[j][0]!=0) break;
            map[j][0]=1;
        }
        for(int j=1;j<n;j++){
            if(map[0][j]!=0) break;
            map[0][j]=1;
        }
        for(int i=1;i<Math.min(m,n);i++){
            for(int j=i;j<m;j++){
                if(map[j][i]==Integer.MIN_VALUE) continue;
                if(map[j-1][i]!=Integer.MIN_VALUE) map[j][i]=map[j-1][i];
                if(map[j][i-1]!=Integer.MIN_VALUE) map[j][i]=(map[j][i]+map[j][i-1])%1_000_000_007;
            }
            for(int j=i+1;j<n;j++){
                if(map[i][j]==Integer.MIN_VALUE) continue;
                if(map[i-1][j]!=Integer.MIN_VALUE) map[i][j]=map[i-1][j];
                if(map[i][j-1]!=Integer.MIN_VALUE) map[i][j]=(map[i][j]+map[i][j-1])%1_000_000_007;
            }
        }
        return map[m-1][n-1];
    }
}
//오른쪽 m-1번, 아래쪽 n-1번, 배치 순서를 변경하는 것
//모든 경우 - puddle 지나는 경우
//puddle 여러 개를 지나는 사례가 있으면? puddle이 10개밖에 없으니 O(n^2)로 처리 가능할수도
//모든 경우 구하는 법: (m+n)C(n), (m+n)!/m!n! -> 오버플로로 실행 불가

//직접 한칸한칸 구하기?