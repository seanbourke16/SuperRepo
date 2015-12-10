//Team ? -- Sean Bourke, Jiawei Chen
//APCS pd9
//HW44 -- This or That or Fouteen Other Things
//2015-12-08

public class Hexadecimal implements Comparable{

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF";


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() {
	_decNum=0;
	_hexNum="0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	_decNum=n;
	_hexNum=decToHex(n);
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative hexadecimal number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
	_decNum=hexToDec(s);
	_hexNum=s;
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _hexNum;   
    }


    /*=====================================
      String decToHex(int) -- converts base-10 input to hexadecimal
      pre:  n >= 0
      post: returns String of bits
      eg  decToHex(0) -> "0"
      decToHex(1) -> "1"
      decToHex(2) -> "10"
      decToHex(3) -> "11"
      decToHex(14) -> "1110"
      =====================================*/
    public static String decToHex( int n ) {
	String retStr="";
	while (n>0){
	    retStr=HEXDIGITS.substring(n%16,n%16+1)+retStr;//Adds remainder to string
	    n=n/16;//Sets n equal to quotient
	}
	return retStr;
    }


    /*=====================================
      String decToHexR(int) -- converts base-10 input to hexadecimal, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToHexR(0) -> "0"
      decToHexR(1) -> "1"
      decToHexR(2) -> "10"
      decToHexR(3) -> "11"
      decToHexR(14) -> "1110"
      =====================================*/
    public static String decToHexR( int n ) {
	if (n==0){
	    return "0";//Returns 0 if imput is 0
	}
	if (n==1){
	    return "1";//Returns 1 if imput is 1
	}
	return HEXDIGITS.substring(n%16,n%16+1)+decToHexR(n/2);//Takes remainder of n/16 and sends quotient back through method
    }


    /*=====================================
      String hexToDec(String) -- converts base-10 input to hexadecimal
      pre:  s represents non-negative hexadecimal number
      post: returns decimal equivalent as int
      eg  
      hexToDec("0") -> 0
      hexToDec("1") -> 1
      hexToDec("10") -> 2
      hexToDec("11") -> 3
      hexToDec("1110") -> 14
      =====================================*/
    public static int hexToDec( String s ) {
	int retInt=0;
	for (int x=0;x<s.length();x++){
	    retInt+=(int)(HEXDIGITS.indexOf(s.substring(x,x+1).toUpperCase())*Math.pow(16,(s.length()-1-x)));//Multiplies each number by its proper power of 16
	}
	return retInt;  
    }


    /*=====================================
      String hexToDecR(String) -- converts base-10 input to hexadecimal, recursively
      pre:  s represents non-negative hexadecimal number
      post: returns decimal equivalent as int
      eg  
      hexToDecR("0") -> 0
      hexToDecR("1") -> 1
      hexToDecR("10") -> 2
      hexToDecR("11") -> 3
      hexToDecR("1110") -> 14
      =====================================*/
    public static int hexToDecR( String s ) {
	if (s.length()==0){
	    return 0;
	}
	return (int)(HEXDIGITS.indexOf(s.substring(0,1).toUpperCase())*Math.pow(16,(s.length()-1)))+hexToDecR(s.substring(1));//Multiplies each number by its proper multiple of 2 and runs the rest of the string through the method again
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal hexadecimal values
      =============================================*/
    public boolean equals( Object other ) {
	if (other==null){
	    throw new NullPointerException("Error the input is null");
	}
	if(!(other instanceof Hexadecimal)){
	    throw new ClassCastException("Error the input is not Hexadecimal");
	}
	Hexadecimal o=(Hexadecimal)other;
	return (this._hexNum.equals(o._hexNum));   
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	if (other==null){
	    throw new NullPointerException("Error the input is null");
	}
	if(!(other instanceof Hexadecimal)){
	    throw new ClassCastException("Error the input is not Hexadecimal");
	}
	Hexadecimal o=(Hexadecimal)other;
	return (int)(this._decNum-o._decNum);
    }


    //main method for testing
    public static void main( String[] args ) {
	System.out.println(hexToDec("6a4c2"));//Should be 435394
	System.out.println(hexToDec("9a"));//Should be 154
	System.out.println(hexToDec("cab"));//Should be 3243
	System.out.println(hexToDecR("6a4c2"));//Should be 435394
	System.out.println(hexToDecR("9a"));//Should be 154
	System.out.println(hexToDecR("cab"));//Should be 3243
	System.out.println(decToHex(12));//Should be c
	System.out.println(decToHex(432));//Should be 1b0
	System.out.println(decToHex(71));//Should be 47
	System.out.println(decToHex(12));//Should be c
	System.out.println(decToHex(432));//Should be 1b0
	System.out.println(decToHex(71));//Should be 47
	System.out.println( "Testing ..." );
	
	Hexadecimal h1 = new Hexadecimal(5);
	Hexadecimal h2 = new Hexadecimal(5);
	Hexadecimal h3 = h1;
	Hexadecimal h4 = new Hexadecimal(7);
	Hexadecimal h5 = null;
	Binary b1 = new Binary();
	System.out.println( h1 );
	System.out.println( h2 );
	System.out.println( h3 );       
	System.out.println( h4 );       

	System.out.println( "\n==..." );
	System.out.println( h1 == h2 ); //should be false
	System.out.println( h1 == h3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( h1.equals(h2) ); //should be true
	System.out.println( h1.equals(h3) ); //should be true
	System.out.println( h3.equals(h1) ); //should be true
	System.out.println( h4.equals(h2) ); //should be false
	System.out.println( h1.equals(h4) ); //should be false
	//System.out.println( h1.equals(h5) ); //should be error
	//System.out.println( h1.equals(b1) ); //should be error
	
	System.out.println( "\n.compareTo..." );
	System.out.println( h1.compareTo(h2) ); //should be 0
	System.out.println( h1.compareTo(h3) ); //should be 0
	System.out.println( h1.compareTo(h4) ); //should be neg
	System.out.println( h4.compareTo(h1) ); //should be pos
	/*=========================================
	=========================================*/
    }//end main()

} //end class
