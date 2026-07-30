class Solution {
    public int solution(int n, String control) {
        char[] cmd = control.toCharArray();
        for(int i = 0; i < cmd.length; i++) {
            switch(cmd[i]) {
                case 'w':
                    n++;
                    break;
                case 's':
                    n--;
                    break;
                case 'd':
                    n+=10;
                    break;
                case 'a':
                    n-=10;
                    break;
            }
        }
        return n;
    }
}