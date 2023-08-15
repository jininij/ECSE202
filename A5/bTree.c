/*
 ============================================================================
 Name        : bTree.c
 Author      : Woojin Jang (Student#: 260762536)
 Version     :
 Copyright   : Your copyright notice
 	 	 	 : This code contain codes from Prof. Frank ferrie and TA Katrina Poulin
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "bTree.h"
#include <string.h>


// instance variables
bNode *root = NULL;  // bTree root node
int numNodes = 0;	 // Number of nodes in tree

// methods:
void initTree(){ // this method sets root to null and numNodes to 0
	root = NULL;
	numNodes= 0;
}


void addNode (char * data){
	// Adds a new node to the bTree.
	bNode *current = NULL;
			// empty tree
			if (root == NULL) {
				root = makeNode(data);
			}
			// not empty
			else {
				current = root;
				while (1) {
					// the return value is negative
					// which means the name (data) comes first compare to the root
					if (keyCompareToIgnoreCase(data, current->data) < 0) {
						// left pointer is empty
						if (current->left == NULL) {
							current->left = makeNode(data);
							break;
						}
						// left pointer is not empty
						else {
							current = current->left;
						}
					}
					else {
						// right pointer is empty
						if (current->right == NULL) {
							current->right = makeNode(data);
							break;
						}
						// right pointer is not empty
						else {
							current = current->right;
						}
					}
				}
			}

}
bNode *makeNode(char *data){
	// Function that allocates a bNode
	bNode* node = (bNode*) malloc (sizeof(bNode));
	node->data = data;
	node->left = NULL;
	node->right = NULL;
	return node;
}

int keyCompareToIgnoreCase(char *name1, char *name2){
	// Modified version of strcasecmp to handle proper names.
	// get last names
	char *lastname1 = lastToken(name1);
	char *lastname2 = lastToken(name2);
	// compare last names
	return strcasecmp (lastname1,lastname2);
}
char *lastToken(char *input){
	// Returns index of last token in string.
	for ( int i = strlen(input)-1; i >= 0; i--){
		  char c = input[i];
		  if (c ==' '){
			  // input points to 1st char
			  // input+i points to space
			  // input+i+1 points to 1st letter of the last name
			  return (char*) (input+i+1);
		  }
	}
	// if we reach this point, there is no space in the input string
	return input; // no space, compare with entire input
}
void displayInOrder(){
	// Prints bTree in forward order by calling recursive traversal function
	traverseInOrder(root);
}
void traverseInOrder(bNode *root){
	// left, root, right
	if (root->left != NULL){
		traverseInOrder (root ->left);
	}
	// visiting
	printf("%s\n",root->data);
	if (root->right != NULL){
		traverseInOrder(root->right);
	}
	// The recursive function that performs in order traversal
}

void displayInReverseOrder(){
	traverseInReverseOrder(root);
}
void traverseInReverseOrder(bNode *root){
	// right, root, left
	if (root->right!= NULL){
		traverseInReverseOrder (root ->right);
		}
	printf("%s\n",root->data);
	if (root->left != NULL){
		traverseInReverseOrder(root->left);
		}
}


//deallocation methods:
void deleteTree(){
	// Post order traversal used to delete tree nodes
	postOrder(root);
}

void postOrder (bNode *root){
	// Post order traversal used to delete tree nodes
	if (root->left!= NULL){
		postOrder (root ->left);
		}
	if (root->right != NULL){
		postOrder(root->right);
		}
	// postOrder
	free(root->data);
	free(root);
	}


int getNumNodes (){
	return numNodes;
}
