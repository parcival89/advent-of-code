#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1024

int process_line(const char *line) {
    int digits[MAX_LINE_LENGTH];
    int count = 0;
    
    // Extract all digits from the line
    for (int i = 0; line[i] != '\0' && line[i] != '\n'; i++) {
        if (line[i] >= '0' && line[i] <= '9') {
            digits[count++] = line[i] - '0';
        }
    }
    
    // Need at least 2 digits
    if (count < 2) {
        return 0;
    }
    
    // Find the highest possible two-digit number
    // by checking all pairs (i, j) where i < j
    int max_number = 0;
    
    for (int i = 0; i < count - 1; i++) {
        for (int j = i + 1; j < count; j++) {
            int two_digit = digits[i] * 10 + digits[j];
            if (two_digit > max_number) {
                max_number = two_digit;
            }
        }
    }
    
    return max_number;
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
        printf("Highest two-digit number: %d\n\n", line_result);
        total_sum += line_result;
    }
    
    // Close the file
    fclose(file);
    
    // Print the final sum
    printf("Total sum: %d\n", total_sum);
    
    return 0;
}
