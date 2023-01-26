package fraccion;

/**
 * Clase que define una fracción
 * @author frodriguez
 *
 */
public class Fraccion {
	/**
	 * Numerador
	 */
	private int num;

	/**
	 * Denominador 
	 */
	private int den;

	/**
	 * Constructor por defecto
	 * Debe generar el valor neutro que es 0/1
	 */

	public Fraccion() { 
		num = 0;
		den = 1;

	}

	/**
	 * Constructor con los parámetros de una fracción
	 * @param num valor del numerador de la fracción
	 * @param den valor del denominador de la fracción
	 */
	public Fraccion(int num, int den) {
		// para evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		/**
		 * devuelvo la fraccion simplificada
		 */
		simplificar();
	}

	/**
	 * Constructor copia
	 * @param f Objeto 'Fraccion'
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	/**
	 * setter para dar valor al atributo 'num'
	 * @param num numerador de la fracción
	 */

	public void setNum(int num) {
		this.num = num;

	}
	/**
	 * getter para obtener el valor de 'num'
	 * @return devuelve el valor de 'num'
	 */

	public int getNum() {
		return num;

	}
	
	/**
	 * setter para dar valor al atributo 'den'
	 * @param den denominador de la fracción
	 */
	
	public void setDen(int den) {
		this.den = den;
	}
	
	/**
	 * getter para obtener el valor de 'den'
	 * @return devuelve el valor de 'den'
	 */
	public int getDen() {
		return den;
	}

	/**
	 * Cálculo del máximo común divisor por el algoritmo de Euclides
	 * @return devuelve el valor absoluto del numerador
	 */
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r; //Variable para guardar el resto
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	/**
	 * método para simplificar fracciones
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	/**
	 * Método toString
	 * @return devuelve el mensaje
	 */

	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	/**
	 * suma de fracciones
	 * @param f recibe la fracción por parámetro
	 * @return devuelve el valor de la variable auxiliar
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Restar fracciones
	 * @param f recibe la fracción por parámetro
	 * @return devuelve el valor de la variable auxiliar
	 */

	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Multiplicar fracciones
	 * @param f recibe la fracción por parámetro
	 * @return devuelve el valor de la variable auxiliar
	 */

	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Dividir fracciones
	 * @param f Recibe la fracción por parámetros
	 * @return Devuelve el valor de la variable auxiliar
	 */

	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
