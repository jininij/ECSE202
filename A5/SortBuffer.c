/*
 ============================================================================
 Name        : SortBuffer.c
 Author      : Woojin Jang (Student#: 260762536)
 Version     :
 Copyright   : Your copyright notice
 	 	 	 : This code contain codes from Prof. frank ferrie and TA Katarina poulin
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "bTree.h"
#include <string.h>


#define  bufferSize 80

/**
 * This code is from the TA Katrina Poulin
 */
int main (int argc, char* argv []){

	// welcome message
	printf("Text Sorting Program in C: (ECSE 202 - Assignment 5)\n");
	printf("Enter names to be sorted, line by line. A blank line terminates.\n");
	printf("you can cut and paste text into this window:\n");

	char* readLine();
	initTree();
	while(1){
		// get input
		char* input = readLine();
		if (input == NULL){
			// heap is full!!!
			// print error message
			printf("Heap is full!!!\n");
			// couldn't allocate memory.
			printf("Coudln't allocate memory\n");
			return -1; //error

		}else if(strlen(input) < 1){ // if empty line, break
			break; // user entered a blank line

		}else{ // else, add node to btree
			addNode(input);
		}

	}

	printf("Text in sort order:\n");
	// traverse in order
	displayInOrder();

	printf("\n");
	printf("Text in reverse sort order:\n");

	// traverse in reverse order
	displayInReverseOrder();

	// delete tree
	deleteTree();
	return 0;
}



char* readLine(){
	// allocate memory for input string (buffer)
	char * buffer = malloc(bufferSize*sizeof(char));
	// fgets -> ([where we store the result],
	//			 [length of what we read],
	//			 [where we read from])
	if (buffer != NULL){
		fgets(buffer, bufferSize*sizeof(char), stdin);
		if (strlen(buffer)>0){
			buffer[strlen(buffer)-1]='\0';
		}
	}
	return buffer;
}
