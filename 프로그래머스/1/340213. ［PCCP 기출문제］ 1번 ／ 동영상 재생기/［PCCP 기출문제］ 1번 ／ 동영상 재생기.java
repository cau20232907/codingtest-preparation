import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("H:mm:ss");
        final LocalTime maxPos = LocalTime.parse("0:" + video_len, dateTimeFormatter);
        final LocalTime unavailableBegin = LocalTime.parse("0:" + op_start, dateTimeFormatter);
        final LocalTime unavailableEnd = LocalTime.parse("0:" + op_end, dateTimeFormatter);
        LocalTime current = LocalTime.parse("0:" + pos, dateTimeFormatter);
        if (current.isAfter(unavailableBegin) && current.isBefore(unavailableEnd))
            current = unavailableEnd;
        for (String cmd : commands) {
            current = switch (cmd) {
                case "next"-> {
                    LocalTime temp = current.plusSeconds(10);
                    if (!temp.isBefore(maxPos)) yield maxPos;
                    else yield temp;
                }
                case "prev"-> {
                    if (!current.isAfter(LocalTime.of(0, 0, 10)))
                        yield LocalTime.MIDNIGHT;
                    else yield current.minusSeconds(10);
                }
                default -> throw new RuntimeException();
            };
            if (!current.isBefore(unavailableBegin) && !current.isAfter(unavailableEnd))
                current = unavailableEnd;
        }
        return current.format(dateTimeFormatter).substring(2);
    }
}