class Solution {
    public String solution(String new_id) {
        // 시간 복잡도는 무시한 코드
        String suggestedId = new_id.toLowerCase()
            .replaceAll("[^\\w\\.-]", "")
            .replaceAll("\\.+", ".")
            .replaceFirst("^\\.", "")
            .replaceFirst("\\.$", "");
        
        switch(suggestedId.length()) {
            case 0:
                suggestedId = "a";
            case 1:
                suggestedId = suggestedId.repeat(3);
                break;
            case 2:
                suggestedId = suggestedId + suggestedId.charAt(1);
                break;
            default:
                suggestedId = suggestedId.substring(
                    0, Math.min(15, suggestedId.length())
                )
                    .replaceFirst("\\.$", "");
        }
        
        return suggestedId;
    }
}