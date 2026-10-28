#include <stdio.h>
#include <cuda_runtime.h>

__global__ void helloCUDA() {
    printf("Hello from CUDA Thread %d\n", threadIdx.x);
}

int main() {
    int deviceCount = 0;
    cudaError_t err = cudaGetDeviceCount(&deviceCount);
    if (err != cudaSuccess || deviceCount == 0) {
        fprintf(stderr, "No CUDA-capable NVIDIA GPU detected: %s\n",
                cudaGetErrorString(err));
        return 1;
    }

    printf("Hello from CPU\n");
    helloCUDA<<<1, 5>>>();
    err = cudaGetLastError();
    if (err != cudaSuccess) {
        fprintf(stderr, "Kernel launch failed: %s\n", cudaGetErrorString(err));
        return 1;
    }
    err = cudaDeviceSynchronize();
    if (err != cudaSuccess) {
        fprintf(stderr, "Kernel execution failed: %s\n", cudaGetErrorString(err));
        return 1;
    }
    return 0;
}
