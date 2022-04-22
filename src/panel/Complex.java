package panel;
class Complex{
	double real;
	double imag;
	public  Complex(double real, double imag) {
		super();
		this.real = real;
		this.imag = imag;
	}
	//相加
	public static Complex add(Complex a, Complex b) {
		double tr=a.real+b.real;
		double ti=a.imag+b.imag;
		return new Complex(tr, ti);
	}
	//相减
	public static Complex subtract(Complex a, Complex b) {
		double tr=a.real-b.real;
		double ti=a.imag-b.imag;
		return new Complex(tr, ti);
	}
	
	//相乘
	public static Complex multiply(Complex a, Complex b) {
	    double tr=a.real*b.real-a.imag*b.imag;
		double ti=b.real*a.imag+a.real*b.imag;
		return new Complex(tr, ti);
	}
	
	//相除
	public static Complex div(Complex a, Complex b) {
		double tr=(a.real*b.real+a.imag*b.imag)/(b.real*b.real-b.imag*b.imag);
		double ti=(a.imag*b.real-a.real*b.imag)/(b.real*b.real-b.imag*b.imag);
		return new Complex(tr, ti);
	}
	
	//相乘
	public static Complex power(Complex a, int n) {
		if(n<=0) {
			return new Complex(0, 0);
		}
		Complex temp=new Complex(a.real, a.imag);
		for(int i=1;i<n;i++) {
			temp=multiply(temp, a);
		}
		return temp;
	}
	
}