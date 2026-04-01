    public void get (Console c)
    {
	String a;
	a = c.readString ();
	this.size = a.length ();

	for (int i = 0 ; i < a.length () ; i++)
	    this.addDigitBack (a.charAt (i) - '0');

	this.removeLeadingZeros ();
    }


    public void removeLeadingZeros ()
    {
	int[] old;
	while ((this.digits [this.size - 1] == 0) && (size > 1))
	    this.size--;

	old = this.digits;
	this.digits = new int [this.size];

	for (int a = 0 ; a < this.size ; a++)
	    this.digits [a] = old [a];
    }
    public void addDigitFront (int added)
    {
	int[] oldDigit;
	oldDigit = this.digits;

	this.size++;
	this.digits = new int [this.size];

	for (int i = 1 ; i < this.size ; i++)
	    this.digits [i] = oldDigit [i - 1];
	this.digits [0] = added;
    }
    public void addDigitBack (int added)
    {
	int[] oldDigit;
	oldDigit = this.digits;

	this.size++;
	this.digits = new int [this.size];

	for (int i = 0 ; i < this.size - 1 ; i++)
	    this.digits [i] = oldDigit [i];
	this.digits [this.size - 1] = added;
    }
