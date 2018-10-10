package section4;

public final class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex add(Complex complex) {
        return new Complex(re + complex.im, im + complex.im);
    }

    public Complex subtract(Complex complex) {
        return new Complex(re - complex.re, im - complex.im);
    }

    public Complex multiply(Complex complex) {
        return new Complex(re * complex.re - im * complex.im,
                re * complex.im + im * complex.re);
    }

    public Complex divide(Complex complex) {
        double tmp = complex.re * complex.re + complex.im * complex.im;
        return new Complex((re * complex.re + im * complex.im) / tmp,
                (im * complex.re - re * complex.im) / tmp);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Complex)) {
            return false;
        }
        Complex c= (Complex) obj;
        return Double.compare(re,c.re)==0&&
                Double.compare(im,c.im)==0;
    }

    @Override
    public int hashCode() {
        int result = 17 + hashDouble(re);
        result = 31 * result + hashDouble(im);
        return result;
    }

    private int hashDouble(double val) {
        long longBits = Double.doubleToLongBits(re);
        return (int)(longBits^(longBits>>>32));
    }

    @Override
    public String toString() {
        return "("+re+"+"+im+"i)";
    }
}
