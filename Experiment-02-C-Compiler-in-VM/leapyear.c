/* EX.NO: 2 - C Compiler in Virtual Machine
   AIM: Install C compiler in VM and execute simple C programs */

#include <stdio.h>

/* Program 1: Leap Year Checker */
int isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}

int main() {
    int year;
    printf("Leap Year Checker\n");
    printf("Enter year: ");
    scanf("%d", &year);
    if (isLeapYear(year))
        printf("%d is a Leap Year\n", year);
    else
        printf("%d is NOT a Leap Year\n", year);
    return 0;
}
