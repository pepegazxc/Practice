# Tasks

---
#### Task 1: Bounded Buffer
Implement a BoundedBuffer with a fixed capacity of 5 slots.
Implement two synchronized methods: `put(int value)` and `take()`.

A producer must block in `put` when the buffer is full.
A consumer must block in `take` when the buffer is empty.

Create two producer threads and two consumer threads.
Each producer puts 6 values; each consumer takes 6 values.

Run it and confirm the buffer size never exceeds 5 and never drops below 0.

----
#### Task 2: Concurrent Counter — synchronized vs AtomicInteger vs ReentrantLock
Create a shared counter with an initial value of 0.
Implement three separate versions of an `increment` operation:

- one guarded by a `synchronized` method,
- one using `AtomicInteger`,
- one guarded by a `ReentrantLock`.

For each version, start 10 threads, each incrementing the counter 1,000,000 times.
Measure the total elapsed time for each version using `System.nanoTime()`.

Confirm the final count is correct in all three versions, then compare the three timings and explain in your own words why they differ.

---
#### Task 3: Worker Pool with CountDownLatch
Create N worker threads (Runnable), each simulating work with `Thread.sleep(...)`.
Use a `CountDownLatch` initialized to N.

Each worker counts down the latch once it finishes its work.
The main thread must wait on the latch — not call `join()` on the workers —
and only then print "All tasks completed".

Run it and confirm the message is never printed before every worker has finished.

----
#### Task 4: Dining Philosophers
Simulate the Dining Philosophers problem with 5 philosopher threads and 5 forks
(represented as 5 lock objects). Each philosopher alternately thinks and eats,
and needs to hold both adjacent forks to eat.

First implement the naive version, where every philosopher picks up the
left fork and then the right fork.

Run it and confirm the naive version deadlocks (or observe threads permanently stuck).

Then fix it using either a fixed global lock-acquisition order across all
philosophers, or a `Semaphore` limiting how many philosophers may attempt
to eat at the same time.

Run the fixed version repeatedly and confirm it completes without ever hanging.

---
#### Task 5: ExecutorService with Graceful Shutdown
Create a fixed thread pool via `ExecutorService` and submit a batch of
long-running tasks. Each task must periodically check
`Thread.currentThread().isInterrupted()` and stop cleanly if interrupted.

Implement a graceful shutdown sequence:

- stop accepting new tasks (`shutdown()`),
- wait for currently running tasks to finish within a timeout (`awaitTermination`),
- if they don't finish in time, force-stop them (`shutdownNow()`).

Trigger the shutdown while tasks are still running and confirm every task either finishes cleanly or is interrupted — none are left running or silently dropped.