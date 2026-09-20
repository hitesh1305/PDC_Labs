#include <stdio.h>
#include <omp.h>

int main()
{
    int arr[8] = {10,20,30,40,50,60,70,80};
    int sum = 0;

    omp_set_num_threads(4); // Set the number of threads to 4

    #pragma omp parallel for reduction(+:sum)
    for(int i = 0; i < 8; i++)
    {
        printf("Thread %d is adding arr[%d] = %d to sum\n", omp_get_thread_num(), i, arr[i]);
        sum += arr[i];
    }
    printf("Final sum = %d\n", sum);
    return 0;
}