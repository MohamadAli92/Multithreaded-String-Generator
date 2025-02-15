# Multithreaded-String-Generator

## Overview
This project is a multithreaded string generator that creates strings based on a predefined pattern. It uses multiple threads to generate sequences in a synchronized manner, ensuring correct character order. The goal is to experiment with concurrent execution and thread synchronization.

## Features
- Uses **three thread classes** for character generation.
- Implements **synchronization** to control execution order.
- Ensures **race-condition-free** multithreading.

## Implementation Details

### 1. Thread Classes
- **Thread A**: Prints the character `'a'`.
- **Thread B**: Prints the character `'b'`.
- **Thread C**: Prints the character `'c'` after `'a'` and `'b'` have completed.

### 2. Synchronization Mechanism
- Ensures that **Threads A and B** print `n` characters in any order.
- **Thread C** waits until `n` characters have been printed before executing.
- Uses **semaphores** to enforce execution order.

### 3. Constraints
- No use of **random functions** for determining order of `'a'` and `'b'`.
- The value of `n` is **manually initialized**.
- The program ensures **safe concurrent execution** without race conditions.

## Key Concepts Used
- **Multithreading**: Efficient parallel execution.
- **Synchronization**: Ensuring correct sequence of character printing.
- **Semaphores**: Used to manage thread dependencies.

## Example Execution
For `n = 5`, possible outputs include:
```
ababababbccccc
```
```
baabababbccccc
```

This project is a personal experiment in **multithreading and synchronization**. Contributions and feedback are welcome!

