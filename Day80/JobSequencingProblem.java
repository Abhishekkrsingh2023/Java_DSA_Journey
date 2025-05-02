// package Day80;

import java.util.Arrays;

// Jobs class to represent each job with id, deadline, and profit
class Jobs implements Comparable<Jobs> {
    int id;
    int deadLine;
    int profit;

    // constructor
    public Jobs(int id, int deadLine, int profit) {
        this.id = id;
        this.deadLine = deadLine;
        this.profit = profit;
    }

    // compareTo method to sort jobs based on profit in descending order
    @Override
    public int compareTo(Jobs o) {
        return o.profit - this.profit;
    }
}

// Anwer class
class Ans {
    int maxProfit;
    int[] jobSequence;

    // constructor
    public Ans(int maxProfit, int[] jobSequence) {
        this.maxProfit = maxProfit;
        this.jobSequence = jobSequence;
    }

    @Override
    public String toString() {
        return "Max Profit: " + maxProfit + ", Job Sequence: " + Arrays.toString(jobSequence);
    }
}

public class JobSequencingProblem {
    public static Ans getSequnece(Jobs[] jobs) {
        // Sorts based on max profit
        Arrays.sort(jobs);
        int n = jobs.length;

        // finding the max deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadLine);
        }
        // stores the max profit and job id
        int maxProfit = 0; 
        int[] result = new int[maxDeadline + 1];
        Arrays.fill(result, -1); // Initialize with -1

        // stores the job id in the slot
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int jobDeadline = jobs[i].deadLine;
            for (int j = jobDeadline; j > 0; j--) {
                if (result[j] == -1) { // If slot is empty
                    result[j] = jobs[i].id; 
                    maxProfit += jobs[i].profit; 
                    cnt++;
                    break;
                }
            }
        }
        // sequence of the jobs
        int[] jobSequence = new int[cnt];
        int index = 0;  
        for (int i = 1; i <= maxDeadline; i++) {
            if (result[i] != -1) {
                jobSequence[index++] = result[i];
            }
        }
        // returning the max profit and job sequence
        return new Ans(maxProfit, jobSequence);
    }

    public static void main(String[] args) {
        Jobs[] jobs = {
                new Jobs(1, 2, 100),
                new Jobs(2, 1, 19),
                new Jobs(3, 2, 27),
                new Jobs(4, 1, 25),
                new Jobs(5, 3, 15)
        };

        Ans ans = getSequnece(jobs);
        System.out.println(ans); 
    }
}
