#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

#define MAX_LINE_LENGTH 1024

// Structure to hold a digit and its position
typedef struct {
    int value;
    int position;
} Digit;

int process_line(const char *line) {
    Digit highest = {INT_MIN, -1};
    Digit second_highest = {INT_MIN, -1};
    int pos = 0;
    
    // Iterate through each character in the line
    for (int i = 0; line[i] != '\0' && line[i] != '\n'; i++) {
        if (line[i] >= '0' && line[i] <= '9') {
            int digit = line[i] - '0';
            
            // Update highest and second highest
            if (digit > highest.value) {
                second_highest = highest;
                highest.value = digit;
                highest.position = pos;
            } else if (digit > second_highest.value) {
                second_highest.value = digit;
                second_highest.position = pos;
            }
            pos++;
        }
    }
    
    // Combine the two highest in order they appear in the line
    if (highest.position == -1 || second_highest.position == -1) {
        return 0; // Not enough digits found
    }
    
    // Always combine in the order they appear (left to right)
    int result;
    if (highest.position < second_highest.position) {
        result = highest.value * 10 + second_highest.value;
    } else {
        result = second_highest.value * 10 + highest.value;
    }
    
    return result;
}

int main(int argc, char *argv[]) {
    FILE *file;
    char line[MAX_LINE_LENGTH];
    int total_sum = 0;
    
    // Check command line arguments
    if (argc != 2) {
        printf("Usage: %s <filename>\n", argv[0]);
        return 1;
    }
    
    // Open the file
    file = fopen(argv[1], "r");
    if (file == NULL) {
        perror("Error opening file");
        return 1;
    }
    
    // Process each line
    while (fgets(line, sizeof(line), file) != NULL) {
        int line_result = process_line(line);
        printf("Line: %s", line);
        printf("Combined value: %d\n\n", line_result);
        total_sum += line_result;
    }
    
    // Close the file
    fclose(file);
    
    // Print the final sum
    printf("Total sum: %d\n", total_sum);
    
    return 0;
}
