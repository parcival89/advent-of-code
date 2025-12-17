#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ROWS 1000
#define MAX_COLS 1000

int count_adjacent(char grid[][MAX_COLS], int rows, int cols, int r, int c) {
    int count = 0;
    // Check all 8 directions: up, down, left, right, and 4 diagonals
    int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    for (int i = 0; i < 8; i++) {
        int nr = r + dr[i];
        int nc = c + dc[i];
        
        // Check bounds and if it's an '@'
        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '@') {
            count++;
        }
    }
    
    return count;
}

int main(int argc, char *argv[]) {
    FILE *file;
    char grid[MAX_ROWS][MAX_COLS];
    int rows = 0;
    int cols = 0;
    char line[MAX_COLS];
    
    // Check if filename is provided
    if (argc < 2) {
        printf("Usage: %s <filename>\n", argv[0]);
        return 1;
    }
    
    // Open file
    file = fopen(argv[1], "r");
    if (file == NULL) {
        printf("Error: Could not open file %s\n", argv[1]);
        return 1;
    }
    
    // Read grid from file
    while (fgets(line, sizeof(line), file) && rows < MAX_ROWS) {
        // Remove newline if present
        int len = strlen(line);
        if (len > 0 && line[len-1] == '\n') {
            line[len-1] = '\0';
            len--;
        }
        
        // Store the line in grid
        strcpy(grid[rows], line);
        
        // Update cols to the maximum line length
        if (len > cols) {
            cols = len;
        }
        
        rows++;
    }
    
    fclose(file);
    
    printf("Grid size: %d rows x %d cols\n", rows, cols);
    
    // Count '@' symbols with fewer than 4 adjacent '@' symbols
    int count = 0;
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols && grid[r][c] != '\0'; c++) {
            if (grid[r][c] == '@') {
                int adjacent = count_adjacent(grid, rows, cols, r, c);
                if (adjacent < 4) {
                    count++;
                }
            }
        }
    }
    
    printf("Number of '@' symbols with fewer than 4 adjacent '@' symbols: %d\n", count);
    
    return 0;
}
