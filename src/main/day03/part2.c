#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1024

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
    
    // Greedy approach: select 12 digits that form the maximum number
    int result[12];
    int result_count = 0;
    int start = 0;
    
    // For each position in our 12-digit result
    for (int pos = 0; pos < 12; pos++) {
        int needed = 12 - pos;  // digits still needed (including current)
        int available = count - start;  // digits still available
        
        // Find the maximum digit in the range where we can still complete the sequence
        int max_digit = -1;
        int max_index = -1;
        
        // We can look ahead at most (available - needed + 1) positions
        int search_limit = start + (available - needed + 1);
        
        for (int i = start; i < search_limit; i++) {
            if (digits[i] > max_digit) {
                max_digit = digits[i];
                max_index = i;
            }
        }
        
        result[result_count++] = max_digit;
        start = max_index + 1;
    }
    
    // Convert result array to a number
    long long max_number = 0;
    for (int i = 0; i < 12; i++) {
        max_number = max_number * 10 + result[i];
    }
    
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
