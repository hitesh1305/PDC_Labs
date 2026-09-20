#include <stdio.h>
#include <mpi.h>
#define N 4
int main(int argc, char *argv[])
{
    int rank, size;
    int A[N][N] = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    int B[N][N] = {
        {1, 0, 0, 1},
        {0, 1, 1, 0},
        {1, 1, 0, 0},
        {0, 0, 1, 1}
    };
    int C[N][N];
    int localA[N / 2][N];
    int localC[N / 2][N];
    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (size != 2)
    {
        if (rank == 0)
        {
            printf("Please run the program using 2 processes.\n");
        }
        MPI_Finalize();
        return 0;
    }
    MPI_Scatter(A, (N / 2) * N, MPI_INT,
                localA, (N / 2) * N, MPI_INT,
                0, MPI_COMM_WORLD);
    for (int i = 0; i < N / 2; i++)
    {
        for (int j = 0; j < N; j++)
        {
            localC[i][j] = 0;
            for (int k = 0; k < N; k++)
            {
                localC[i][j] += localA[i][k] * B[k][j];
            }
        }
    }
    MPI_Gather(localC, (N / 2) * N, MPI_INT,
               C, (N / 2) * N, MPI_INT,
               0, MPI_COMM_WORLD);
    if (rank == 0)
    {
        printf("Result Matrix C = A x B:\n\n");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                printf("%4d", C[i][j]);
            }
            printf("\n");
        }
    }
    MPI_Finalize();
    return 0;
}
