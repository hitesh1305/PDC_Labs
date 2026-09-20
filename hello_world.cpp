#include <omp.h>
#include <stdio.h>
int main()
{
    // Define the number of threads to be used
    int num_threads = 4;

    // Set the number of threads to use in parallel regions
    omp_set_num_threads(num_threads);

// Parallel region begins
#pragma omp parallel
    {
        // Get the ID of the current thread
        int thread_id = omp_get_thread_num();
        printf("Hello from thread %d\n", thread_id);
    }

    return 0;
}