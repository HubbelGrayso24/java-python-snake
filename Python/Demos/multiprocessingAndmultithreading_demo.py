import multiprocessing
import threading
import time
"""
This script demonstrates the use of multiprocessing and multithreading in Python to safely increment a shared counter using locks.

Functions:
- multiprocessing_worker(counter, lock, process_name): Worker function for multiprocessing that increments a shared counter safely using a lock.
- threading_worker(counter, lock, thread_name): Worker function for multithreading that increments a shared counter safely using a lock.

Usage:
Run the script directly to see the demonstration of multiprocessing and multithreading.
"""


# Sequential counting function
def sequential_worker(counter):
    """Increment the counter sequentially."""
    for i in range(5):
        counter += 1
        print(f"Sequential (No Threads/Processes): Counter incremented to {counter}")
        # time.sleep(1)
    return counter

# Function for multiprocessing
def multiprocessing_worker(counter, lock, process_name):
    """Increment the counter safely using a lock in multiprocessing."""
    for _ in range(5):
        with lock:
            counter.value += 1
            print(f"{process_name} (Multiprocessing): Counter incremented to {counter.value}")
        # time.sleep(1)

#  Function for multithreading
def threading_worker(counter, lock, thread_name):
    """Increment the counter safely using a lock in multithreading."""
    for _ in range(5):
        with lock:
            counter[0] += 1
            print(f"{thread_name} (Multithreading): Counter incremented to {counter[0]}")
        # time.sleep(1)


if __name__ == "__main__":

    # Sequential Execution
    print("Starting Sequential Demo")
    seq_start_time = time.perf_counter()

    seq_counter = 0  # Local counter
    seq_counter = sequential_worker(seq_counter)

    seq_end_time = time.perf_counter()
    print(f"Final counter value (Sequential): {seq_counter}")
    print(f"Time taken (Sequential): {seq_end_time - seq_start_time:.2f} seconds\n")


    print("Starting Multiprocessing Demo")
    # Measure time for multiprocessing
    mp_start_time = time.perf_counter()

    # Multiprocessing setup
    mp_counter = multiprocessing.Value('i', 0) 
    mp_lock = multiprocessing.Lock()  
    mp_processes = []

    # Create 3 processes
    for i in range(3):
        process_name = f"Process-{i+1}"
        process = multiprocessing.Process(target=multiprocessing_worker, args=(mp_counter, mp_lock, process_name))
        mp_processes.append(process)

    # Start and join multiprocessing processes
    for process in mp_processes:
        process.start()
    for process in mp_processes:
        process.join()

    mp_end_time = time.perf_counter()
    print(f"Final counter value (Multiprocessing): {mp_counter.value}")
    print(f"Time taken (Multiprocessing): {mp_end_time - mp_start_time:.2f} seconds\n")



    print("Starting Multithreading Demo")
    # Measure time for multithreading
    mt_start_time = time.perf_counter()

    # Multithreading setup
    thread_counter = [0]
    thread_lock = threading.Lock()
    threads = []

    # Create 3 threads
    for i in range(3):
        thread_name = f"Thread-{i+1}"
        thread = threading.Thread(target=threading_worker, args=(thread_counter, thread_lock, thread_name))
        threads.append(thread)

    # Start and join threads
    for thread in threads:
        thread.start()
    for thread in threads:
        thread.join()

    mt_end_time = time.perf_counter()
    print(f"Final counter value (Multithreading): {thread_counter[0]}")
    print(f"Time taken (Multithreading): {mt_end_time - mt_start_time:.2f} seconds\n")

    # Compare efficiency
    # efficiency = (mp_end_time - mp_start_time) / (mt_end_time - mt_start_time)

    # Efficiency Comparisons
    print("Efficiency Comparisons:")
    print(f"Sequential vs. Multiprocessing: {seq_end_time - seq_start_time:.2f} seconds vs. {mp_end_time - mp_start_time:.2f} seconds")
    print(f"Sequential vs. Multithreading: {seq_end_time - seq_start_time:.2f} seconds vs. {mt_end_time - mt_start_time:.2f} seconds")
