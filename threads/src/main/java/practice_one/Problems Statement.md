# Tasks

---
#### Task 1:
    Create 3 threads named "Printer A", "Printer B", and "Printer C".
    Each thread should print its name and numbers from 1 to 5 to the console with a 100ms delay between numbers.

*Start them simultaneously and observe the console output.*

---
#### Task 2:
    Create a bank account with an initial balance of 1000.
    Implement two synchronized methods: `deposit` and `withdraw`.

    Create two threads:

    - The first thread deposits 10 into the account 100,000 times.
    - The second thread withdraws 10 from the account 100,000 times.

*Make sure that after both threads finish running, the account balance is still exactly 1000.*

---
#### Task 3:
    Create an array with 100 random numbers ranging from 1 to 1000.
    Create four threads and divide the array into four equal parts (25 elements each).
    Assign each part to a thread to find the maximum number within its range.
    Wait for all threads to complete using `join()`, and then find the absolute maximum among the four local results.

---
#### Task 4:
    Create a logger thread that prints "Logging system metrics..." to the console every 300ms in an infinite loop.
    The main thread should sleep for 1.5 seconds and then call `.interrupt()` on the logger thread.
    The logger thread must catch the interruption signal, print "Saving logs...", and terminate cleanly without throwing unhandled exceptions.
