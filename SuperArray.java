/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray implements ListInt{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor ¡V initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) 
    { 
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
	Comparable[] a = new Comparable[_size + 1];
        for( int i = 0; i < _size; i++ ){
	    a[i] = _data[i];
        }
        _size++;
        _lastPos++;
        a[_lastPos] = newVal;
       _data = a;
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) { 
        Comparable[] a = new Comparable[_size + 1];
        for( int i = 0; i < index; i++ ){ 
	    a[i] = _data[i];
        } 
	a[index] = newVal; 
	for ( int i = index + 1; i < _size + 1; i++ ) { 
	    a[i] = _data [i-1];
	}
        _size++;
        _lastPos++;
       _data = a;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) { 
        Comparable[] a = new Comparable[_size - 1];
        for( int i = 0; i < index; i++ ){
	    a[i] = _data[i];
	}
        for ( int i = index ; i < _size - 1; i++ ) { 
	    a[i] = _data [i+1];
	}
        _size--;
        _lastPos--;
       _data = a;
    }


    //return number of meaningful items in _data
    public int size() { 
	return _size;
    }

    public int linSearch(Comparable c){
	for (int x=0;x<_data.length;x++){
	    if (c.equals(_data[x])){
		return x;
	    }
	}
	return -1;
    }

    public boolean isSorted(){
	for (int x=0;x<_data.length-1;x++){
	    if (_data[x].compareTo(_data[x+1])<0){
		return false;
	    }
	}
	return true;
    }
    //main method for testing
    public static void main( String[] args ) 
    {
	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    int n = (int)(Math.random()*3);
	    if (n==0){
		curtis.set(i,new Rational((int)(Math.random()*100),(int)(Math.random()*100+1)));
		System.out.println(i);
	    }
	    if (n==1){
		curtis.set(i,new Binary((int)(Math.random()*100)));
	    }
	    else{
		curtis.set(i,new Hexadecimal((int)(Math.random()*100)));
	    }
	    curtis._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);
	System.out.println(curtis.isSorted());
	//System.out.println(curtis.linSearch(14));
	//System.out.println(curtis.linSearch(""));
	//System.out.println(curtis.linSearch(""));
	SuperArray jim=new SuperArray();
	for(int x=0;x<jim._data.length;x++){
	    jim.set(x,new Binary(x));
	}
	System.out.println(jim.isSorted());
	jim.expand();
	jim.add(3,new Hexadecimal(3));
	System.out.println(jim.isSorted());
	/*
	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	  mayfield.add(5);
	  mayfield.add(4);
	  mayfield.add(3);
	  mayfield.add(2);
	  mayfield.add(1);

	  System.out.println("Printing populated SuperArray mayfield...");
	  System.out.println(mayfield);

	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);
	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);

	  mayfield.add(3,99);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(2,88);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(1,77);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  System.out.println("ListInt tests:");
	  ListInt jim=new SuperArray();
	  jim.add(7);
	  jim.add(11);
	  jim.add(0,12);
	  System.out.println("Printing ListInt jim post-add");
	  System.out.println(jim);
	  jim.remove(1);
	  System.out.println("Printing ListInt jim post-remove");
	  System.out.println(jim);
	  jim.set(0,1);
	  System.out.println("Printing index 0 of ListInt jim post-set");
	  System.out.println(jim.get(0));
	  System.out.println("Printing size of ListInt jim");
	  System.out.println(jim.size());
          /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	//*****INSERT ANY ADDITIONAL TEST CALLS HERE*****

    }//end main
		
}//end class
