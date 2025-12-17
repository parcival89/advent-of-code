#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1024

void find_max_sequence(int *digits, int count, int start, int depth, long long current, long long *max_number) {
    // Base case: we've selected 12 digits
    if (depth == 12) {
        if (current > *max_number) {
            *max_number = current;
        }
        return;
    }
    
    // No more digits to select
    if (start >= count) {
        return;
    }
    
    // Try including the current digit
    find_max_sequence(digits, count, start + 1, depth + 1, current * 10 + digits[start], max_number);
    
    // Try skipping the current digit
    find_max_sequence(digits, count, start + 1, depth, current, max_number);
}

long long process_line(const char *line) {
    int digits[MAX_LINE_LENGTH];
    int count = 0;
    
    // Extract all digits from the line
    for (int i = 0; line[i] != '\0' && line[i] != '\n'; i++) {
        if (line[i] >= '0' && line[i] <= '9') {
            digits[count++] = line[i] - '0';
        }
    }
    
    // Need at least 12 digits
    if (count < 12) {
        return 0;
    }
    
    // Find the highest possible 12-digit number
    long long max_number = 0;
    find_max_sequence(digits, count, 0, 0, 0, &max_number);
    
    return max_number;
}

int main(int argc, char *argv[]) {
    FILE *file;
    char line[MAX_LINE_LENGTH];
    long long total_sum = 0;
    
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
        long long line_result = process_line(line);
        printf("Line: %s", line);
        printf("Highest 12-digit number: %lld\n\n", line_result);
        total_sum += line_result;
    }
    
    // Close the file
    fclose(file);
    
    // Print the final sum
    printf("Total sum: %lld\n", total_sum);
    
    return 0;
}
