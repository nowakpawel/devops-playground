#include <stdio.h>
#include <limits.h>
#include <float.h>
#include <string.h>

void printDelimiter(char *text) {
	printf("\n====== %s ======\n", text);
}	

void printHello(char *name) {
	printf("Hello %s.\n Here you have all C basic types ranges\n", name);
}

int main() {
	char name[15];

	printf("Enter you name:\t");
	fgets(name, sizeof(name), stdin);
	name[strlen(name) - 1] = '\0'; //Remove 'new line' character when hiting the Enter
	printHello(name);

	printf("Integer types:\n");
	printf("char: %d to %d\n", CHAR_MIN, CHAR_MAX); 
	printf("short: %d to %d\n", SHRT_MIN, SHRT_MAX); 
	printf("int: %d to %d\n", INT_MIN, INT_MAX); 
	printf("long: %ld to %ld\n", LONG_MIN, LONG_MAX); 
	printf("Char: %lld to %lld\n", LLONG_MIN, LLONG_MAX); 

	printf("\nFloating-point types:\n");
	printf("float: %e to %e\n", FLT_MIN, FLT_MAX); 
	printf("double: %e to %e\n", DBL_MIN, DBL_MAX); 
	printf("long double: %Le to %Le\n", LDBL_MIN, LDBL_MAX);

	printDelimiter("Compilation Done");


	return 0;
}
