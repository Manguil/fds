#ifndef VECTOR_H
#define VECTOR_H

/**
\struct vector
*/
typedef struct vector {
    int *array;         // the memory space of the vector
    int capacity;       // the maximal number of elements in this space
    int size;           // the size of the vector (size is always less or equal to capacity)
} vector;

/**
 \brief Create a vector of given size
 \param s the initial size of the vector
 \param vec a pointer to a vector
 \return a vector of both capacity and size initialized to s is created. 1 is returned if the creation succeeds, else 0.
 */
_Bool newVec(int s, vector *vec);

/**
 \brief Give the capacity of a vector
 \param vec a vector
 \return the maximal number of elements in vec
 */
int cap(vector vec) ;
           
/**
 \brief Give the size of a vector
 \param vec a vector
 \return the useful number of elements of vec
 */
int size(vector vec) ;

/**
 \brief The value of the element with a given index
 \param vec a vector
 \param i a positive integer
 \return the value of the element of vec having the index i (the (i+1)-th element).
    i must be strictly less than the size of vec
 */
int getVal(vector vec, int i) ;

/**
 \brief Display the characteristics and content of a vector
 \param vec a vector
 \return None. The size, capacity and content of vec is displayed in the form :
    Vector of size s (capacity c) : [ v1 v2 ...  vs ]
 */
void printVector(vector vec) ;

/**
 \brief Set a value to a specific position
 \param vec a pointer to a vector
 \param i a positive integer, the position
 \param val an int, the value
 \return none but vec is modified : val is the new value of the element indexed by i.
    i must be strictly less than the size of vec
 */
void setVal(vector *vec, int i, int val) ;

/**
 \brief Extends a vector with a new element at the end.
 \param vec a pointer to a vector
 \param val an int, the value
 \return Extends vec of one element and set val in this new last element. 1 is returned if the extension succeeds, 0 else.value 0.
 */
_Bool addVal(vector *vec, int val) ;

/**
 \brief Delete a vector
 \param vec a pointer to a vector
 \return Delete vec which becomes an empty vector.
 */
void deleteVec(vector *vec);

#endif
