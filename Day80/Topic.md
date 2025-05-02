# Problem 1 : Job Sequencing Problem

The **Job Sequencing Problem** is a classic greedy algorithm problem in computer science and operations research. It involves scheduling jobs to maximize profit given deadlines and profits for each job.

## Problem Statement

- You are given `n` jobs, each with:
    - A deadline (`d`)
    - A profit (`p`)
- Each job takes **one unit of time**.
- Only one job can be scheduled at a time.
- A job must be completed **before or on its deadline**.
- The goal is to **maximize total profit** by scheduling jobs optimally.

## Approach

1. **Sort** all jobs in decreasing order of profit.
2. **Iterate** through the sorted jobs:
     - For each job, find a free time slot before its deadline.
     - If a slot is found, schedule the job.
3. **Repeat** until all jobs are considered or all slots are filled.

# Problem 2: N Meetings in a Room

The **N Meetings in a Room** problem is another classic greedy scheduling problem. It focuses on maximizing the number of non-overlapping meetings that can be scheduled in a single room.

### Problem Statement

- You are given `n` meetings, each with:
    - A start time (`s`)
    - An end time (`e`)
- Only one meeting can be held in the room at a time.
- The goal is to **schedule the maximum number of meetings** without overlaps.

### Approach

1. **Sort** all meetings by their end times.
2. **Iterate** through the sorted meetings:
    - Select a meeting if its start time is after the end time of the last selected meeting.
3. **Repeat** until all meetings are considered.

This greedy approach ensures the room is available for as many meetings as possible.
