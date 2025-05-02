// package Day80;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Meeting implements Comparable<Meeting> {
    int pos;
    int start;
    int end;

    // constructor
    public Meeting(int pos, int start, int end) {
        this.pos = pos;
        this.start = start;
        this.end = end;
    }

    // compareTo method to sort meetings based on end time
    @Override
    public int compareTo(Meeting o) {
        return Integer.compare(this.end, o.end);
    }
}

// answer class
class Answer {
    int maxMeetings;
    List<Integer> meetingSequence;

    // constructor
    public Answer(int maxMeetings, List<Integer> meetingSequence) {
        this.maxMeetings = maxMeetings;
        this.meetingSequence = meetingSequence;
    }

    @Override
    public String toString() {
        return "Max Meetings: " + maxMeetings + ", Meeting Sequence: " + meetingSequence.toString();
    }
}

public class MeetingsPossible {
    public static Answer getAnswer(List<Meeting> meetings) {
        Collections.sort(meetings); // sorts in ascending order
        int n = meetings.size();
        // previous & sequence
        int prev = -1;
        List<Integer> seq = new ArrayList<>();
        int cnt = 0;
        // choosing the meeting
        for (int i = 0; i < n; i++) {
            Meeting meet = meetings.get(i);
            if (prev == -1 || meet.start > prev) {
                cnt++;
                seq.add(meet.pos);
                prev = meet.end;
            }
        }
        return new Answer(cnt, seq);
    }

    public static void main(String[] args) {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(1, 0, 5));
        meetings.add(new Meeting(2, 1, 2));
        meetings.add(new Meeting(3, 3, 4));
        meetings.add(new Meeting(4, 5, 9));
        meetings.add(new Meeting(5, 5, 7));
        meetings.add(new Meeting(6, 8, 9));

        // gets the answer
        Answer ans = getAnswer(meetings);
        System.out.println(ans);

    }
}
