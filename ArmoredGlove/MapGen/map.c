
#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>


#include <time.h>
#include <stdlib.h>


int main()
{
   	int myInt, c;
   	printf("Enter rows: \n");
	scanf("%d", &myInt);

	printf("Enter columns: \n");
	scanf("%d", &c);
	FILE *f = fopen("file.txt", "w");

	if (f == NULL)
	{
    printf("Error opening file!\n");
    exit(1);
	}
	//char *text; 

	int i = 0;
	int j = 0;

	char *text = "";
int row, columns, top, bottom;

for (int top=-2; top<c; top++){
	     fprintf(f, "@");

}
	     fprintf(f, "\n");
		srand(time(NULL));

for (int row=0; row<myInt; row++){
	     	fprintf(f, "@");
	     	int r = rand();    //returns a pseudo-random integer between 0 and RAND_MAX
    for(int columns=0; columns<c; columns++)
	//	if (r%10 == 0){
	//		fprintf(f, "@");
	//		 r = rand();    //returns a pseudo-random integer between 0 and RAND_MAX

	//	}
		//else{
     	fprintf(f, "X");

 //}
      	fprintf(f, "@\n");

}

for (int bottom=-2; bottom<c; bottom++){
	     fprintf(f, "@");

}

	


	fclose(f);

    return 0;
}