PDC LAB - EXPERIMENT 8: CUDA PROGRAMS
=====================================

Included programs:
1. hello.cu             - Hello from CPU and five GPU threads
2. vector_add.cu        - Vector addition
3. vector_subtract.cu   - Vector subtraction
4. vector_multiply.cu   - Element-wise vector multiplication
5. array_max.cu         - Maximum element in an array
6. matrix_add.cu        - 2x2 matrix addition
7. matrix_multiply.cu   - 2x2 matrix multiplication

IMPORTANT REQUIREMENTS
---------------------
Actual CUDA execution requires:
- An NVIDIA CUDA-capable GPU
- A suitable NVIDIA driver
- NVIDIA CUDA Toolkit (includes nvcc)
- On Windows, a supported Microsoft Visual C++ compiler/Visual Studio C++ build tools
- On Linux, a supported C/C++ compiler

Check before running:
    nvidia-smi
    nvcc --version

If nvidia-smi cannot find an NVIDIA GPU, or nvcc is not found, the programs
will not run locally until the relevant hardware/software setup is available.
Intel integrated graphics alone cannot execute CUDA kernels.

WINDOWS (PowerShell or Developer Command Prompt)
------------------------------------------------
1. Extract this ZIP to a folder, for example:
       C:\CUDAPrograms
2. Open a CUDA-enabled terminal. On Windows, nvcc may need the Visual Studio
   C++ build environment initialized.
3. Go to the folder:
       cd C:\CUDAPrograms
4. Compile and run one program at a time, for example:
       nvcc hello.cu -o hello.exe
       .\hello.exe

Repeat with each file:
       nvcc vector_add.cu -o vector_add.exe
       .\vector_add.exe

       nvcc vector_subtract.cu -o vector_subtract.exe
       .\vector_subtract.exe

       nvcc vector_multiply.cu -o vector_multiply.exe
       .\vector_multiply.exe

       nvcc array_max.cu -o array_max.exe
       .\array_max.exe

       nvcc matrix_add.cu -o matrix_add.exe
       .\matrix_add.exe

       nvcc matrix_multiply.cu -o matrix_multiply.exe
       .\matrix_multiply.exe

LINUX
-----
1. Extract the ZIP and open a terminal in the extracted folder.
2. Check setup:
       nvidia-smi
       nvcc --version
3. Compile and run one program at a time:
       nvcc hello.cu -o hello
       ./hello

Repeat with each file:
       nvcc vector_add.cu -o vector_add && ./vector_add
       nvcc vector_subtract.cu -o vector_subtract && ./vector_subtract
       nvcc vector_multiply.cu -o vector_multiply && ./vector_multiply
       nvcc array_max.cu -o array_max && ./array_max
       nvcc matrix_add.cu -o matrix_add && ./matrix_add
       nvcc matrix_multiply.cu -o matrix_multiply && ./matrix_multiply

EXPECTED RESULTS
----------------
hello.cu:
    Hello from CPU
    Hello from CUDA Thread 0
    ...
    Hello from CUDA Thread 4
(The order of GPU thread messages may vary.)

vector_add.cu:
    10 + 1 = 11
    20 + 2 = 22
    30 + 3 = 33
    40 + 4 = 44
    50 + 5 = 55

vector_subtract.cu:
    10 - 1 = 9
    20 - 2 = 18
    30 - 3 = 27
    40 - 4 = 36
    50 - 5 = 45

vector_multiply.cu:
    10 * 1 = 10
    20 * 2 = 40
    30 * 3 = 90
    40 * 4 = 160
    50 * 5 = 250

array_max.cu:
    Maximum value = 42

matrix_add.cu:
    6 8
    10 12

matrix_multiply.cu:
    19 22
    43 50

TROUBLESHOOTING
---------------
- 'nvcc' is not recognized: CUDA Toolkit is not installed or its bin folder
  is not on PATH. Open a CUDA-enabled terminal and verify installation.
- 'no CUDA-capable device detected': the system does not expose a compatible
  NVIDIA GPU/driver. Use a CUDA-enabled lab PC or cloud runtime.
- Windows compiler error: install a CUDA-supported Visual Studio C++ toolchain.
- If a kernel fails, the programs print CUDA error details for checked calls.
