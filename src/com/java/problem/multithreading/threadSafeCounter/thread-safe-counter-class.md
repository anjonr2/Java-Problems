Implement a thread safe counter class in Java that supports increment
and decrement operations. Multiple threads should be able to increment
and decrement the counter concurrently without any race conditions


increment and decrement operation happens in three steps
1. Read the current value of the counter.
2. Modify the value (increment or decrement).
3. Write the new value back to the counter.

Above three operation ideally should be atomic
Should not execute as separate independent operations

But in concurrent environment when multiple threads are included there's a interference between the threads and the operations may not be atomic. This can lead to race conditions
