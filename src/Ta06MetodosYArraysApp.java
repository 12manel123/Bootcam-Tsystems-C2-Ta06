import javax.swing.JOptionPane;

public class Ta06MetodosYArraysApp {
	public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            String opcion = mostrarMenu();

            switch (opcion) {
                case "1":
                    ejercicio1();
                    break;
                case "2":
                    ejercicio2();
                    break;
                case "3":
                    ejercicio3();
                    break;
                case "4":
                    ejercicio4();
                    break;
                case "5":
                    ejercicio5();
                    break;
                case "6":
                    ejercicio6();
                    break;
                case "7":
                    ejercicio7();
                    break;
                case "8":
                    ejercicio8();
                    break;
                case "9":
                    ejercicio9();
                    break;
                case "10":
                    ejercicio10();
                    break;
                case "11":
                    ejercicio11();
                    break;
                case "12":
                    ejercicio12();
                    break;
                case "0":
                	JOptionPane.showMessageDialog(null, "Adi�s!");
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opci�n no v�lida. Introduce un n�mero del 0 al 12.");
            }
        }
    }
    public static String mostrarMenu() {
        return JOptionPane.showInputDialog(
            "Elige un ejercicio (0 para salir):\n" +
            "1.- Calcular el �rea de una figura.\n" +
            "2.- Generar n�meros enteros aleatorios.\n" +
            "3.- Comprobar si un n�mero es primo.\n" +
            "4.- Calcular el factorial de un n�mero.\n" +
            "5.- Numero decimal a binario.\n" +
            "6.- Contar numero de cifras en un n�mero.\n" +
            "7.- Convertir euros a otras monedas.\n" +
            "8.- Rellenar y mostrar un array de 10 posiciones.\n" +
            "9.- Rellenar y mostrar un array aleatorio.\n" +
            "10.- Generar array de n�meros primos y encontrar el mayor.\n" +
            "11.- Multiplicar elementos de dos arrays.\n" +
            "12.- Encontrar n�meros que terminen en un d�gito en un array."
        );
    }
    //1) Crea una aplicaci�n que nos calcule el �rea de un circulo, cuadrado o triangulo. Pediremos que figura queremos calcular su �rea y seg�n lo introducido pedir� los valores necesarios para calcular el �rea. Crea un m�todo por cada figura para calcular cada �rea, este devolver� un n�mero real. Muestra el resultado por pantalla.
    public static void ejercicio1() {
        String figura = JOptionPane.showInputDialog("Introduce la figura (circulo, triangulo, cuadrado):");
        double area = 0;
        switch (figura.toLowerCase()) {
            case "circulo":
                double radio = Double.parseDouble(JOptionPane.showInputDialog("Dime el radio del c�rculo:"));
                area = calcularAreaCirculo(radio);
                break;
            case "triangulo":
                double base = Double.parseDouble(JOptionPane.showInputDialog("Base de tri�ngulo:"));
                double altura = Double.parseDouble(JOptionPane.showInputDialog("Altura de tri�ngulo:"));
                area = calcularAreaTriangulo(base, altura);
                break;
            case "cuadrado":
                double lado = Double.parseDouble(JOptionPane.showInputDialog("Dime el lado del cuadrado:"));
                area = calcularAreaCuadrado(lado);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Figura no valida.");
                break;
        }
        JOptionPane.showMessageDialog(null, "El area es: " + area);
    }

    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    public static double calcularAreaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }

    public static double calcularAreaCuadrado(double lado) {
        return Math.pow(lado, 2);
    }

    //2) Crea una aplicaci�n que nos genere una cantidad de n�meros enteros aleatorios que nosotros le pasaremos por teclado. Crea un m�todo donde pasamos como par�metros entre que n�meros queremos que los genere, podemos pedirlas por teclado antes de generar los n�meros. Este m�todo devolver� un n�mero entero aleatorio. Muestra estos n�meros por pantalla.
    public static void ejercicio2() {
        int min = Integer.parseInt(JOptionPane.showInputDialog("N�mero m�nimo:"));
        int max = Integer.parseInt(JOptionPane.showInputDialog("N�mero m�ximo:"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cuantos numeros quieres aleatorios:"));
        for (int i = 0; i < cantidad; i++) {
            int num = generarNumeroAleatorio(min, max);
            JOptionPane.showMessageDialog(null, "N�mero aleatorio: " + num);
        }
    }

    public static int generarNumeroAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    //3) Crea una aplicaci�n que nos pida un n�mero por teclado y con un m�todo se lo pasamos por par�metro para que nos indique si es o no un n�mero primo, debe devolver true si es primo sino false
    public static void ejercicio3() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Dime un n�mero:"));
        if(esNumeroPrimo(numero)) {
        	JOptionPane.showMessageDialog(null, "Es primo");
        }
        else {
        	JOptionPane.showMessageDialog(null, "No es primo ");
        }
        
    }

    public static boolean esNumeroPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {//Al comprovar el restante de uan division, compruevo si ese numero es primo
                return false;
            }
        }
        return true;
    }

    //4) Crea una aplicaci�n que nos calcule el factorial de un n�mero pedido por teclado, lo realizara mediante un m�todo al que le pasamos el n�mero como par�metro. Para calcular el factorial, se multiplica los n�meros anteriores hasta llegar a uno. 
    public static void ejercicio4() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Dime un numero:"));
        int factorial = calcularFactorial(numero);
        JOptionPane.showMessageDialog(null, "El factorial de " + numero + " es: " + factorial);
    }

    public static int calcularFactorial(int numero) {
        if (numero == 0 || numero == 1) {
            return 1;
        }
        return numero * calcularFactorial(numero - 1);//Puedo llamar la operacion dentro de ella, asi realizar 3*2*1
    }

    // 5) Crea una aplicaci�n que nos convierta un n�mero en base decimal a binario. Esto lo realizara un m�todo al que le pasaremos el numero como par�metro, devolver� un String con el numero convertido a binario. Para convertir un numero decimal a binario, debemos dividir entre 2 el numero y el resultado de esa divisi�n se divide entre 2 de nuevo hasta que no se pueda dividir mas, el resto que obtengamos de cada divisi�n formara el numero binario, de abajo a arriba.
    public static void ejercicio5() {
        int numeroDecimal = Integer.parseInt(JOptionPane.showInputDialog("Dime un numero decimal:"));
        String numeroBinario = convertirDecimalABinario(numeroDecimal);
        JOptionPane.showMessageDialog(null, "El n�mero binario es: " + numeroBinario);
    }

    public static String convertirDecimalABinario(int numeroDecimal) {
        StringBuilder binario = new StringBuilder();
        while (numeroDecimal > 0) {
            int residuo = numeroDecimal % 2;
            binario.insert(0, residuo);
            numeroDecimal /= 2;
        }
        return binario.toString();
    }

    // 6) Crea una aplicaci�n que nos cuente el n�mero de cifras de un n�mero entero positivo (hay que controlarlo) pedido por teclado. Crea un m�todo que realice esta acci�n, pasando el n�mero por par�metro, devolver� el n�mero de cifras.
    public static void ejercicio6() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Dime un numero positivo:"));
        int cantidadCifras = contarCifras(numero);
        JOptionPane.showMessageDialog(null, "El n�mero de cifras es: " + cantidadCifras);
    }

    public static int contarCifras(int numero) {
        if (numero < 0) {
            return -1;
        }
        if (numero == 0) {
            return 1;
        }
        int cifras = 0;
        while (numero > 0) {
            cifras++;
            numero /= 10;
        }
        return cifras;
    }

    // 7) Crea un aplicaci�n que nos convierta una cantidad de euros introducida por teclado a otra moneda, estas pueden ser a dolares, yenes o libras. El m�todo tendr� como par�metros, la cantidad de euros y la moneda a pasar que sera una cadena, este no devolver� ning�n valor, mostrara un mensaje indicando el cambio (void).
    public static void ejercicio7() {
        double cantidadEuros = Double.parseDouble(JOptionPane.showInputDialog("Cantidad de euros:"));
        String monedaDestino = JOptionPane.showInputDialog("Moneda de destino (libras, d�lares, yenes):");
        convertirMoneda(cantidadEuros, monedaDestino);
    }

    public static void convertirMoneda(double cantidadEuros, String monedaDestino) {
        double tasaCambio = 0;

        switch (monedaDestino.toLowerCase()) {
            case "libras":
                tasaCambio = 0.86;
                break;
            case "d�lares":
                tasaCambio = 1.28611;
                break;
            case "yenes":
                tasaCambio = 129.852;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Moneda no v�lida.");
                return;
        }

        double cantidadConvertida = cantidadEuros * tasaCambio;
        JOptionPane.showMessageDialog(null, cantidadEuros + " euros son " + cantidadConvertida + " " + monedaDestino);
    }

    // 8) Crea un array de 10 posiciones de n�meros con valores pedidos por teclado. Muestra por consola el indice y el valor al que corresponde. Haz dos m�todos, uno para rellenar valores y otro para mostrar.
    public static void ejercicio8() {
        int[] array = new int[10];
        rellenarArray(array);
        mostrarArray(array);
    }

    public static void rellenarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(JOptionPane.showInputDialog("Dime un n�mero para la posici�n " + i + ":"));
        }
    }

    public static void mostrarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            JOptionPane.showMessageDialog(null, "Posicion: " + i + ". Valor: " + array[i]);
        }
    }

    // 9) Crea un array de n�meros donde le indicamos por teclado el tama�o del array, rellenaremos el array con n�meros aleatorios entre 0 y 9. Al final muestra por pantalla el valor de cada posici�n y la suma de todos los valores.
    //Tareas a realizar: Haz un m�todo para rellenar el array(que tenga como par�metros los n�meros entre los que tenga que generar) y otro para mostrar el contenido y la suma del array.

    public static void ejercicio9() {
        int tama�oArray = Integer.parseInt(JOptionPane.showInputDialog("Dime el tama�o del array:"));
        int[] array = new int[tama�oArray];
        rellenarArrayAleatorio(array, 0, 9);
        mostrarArrayYSuma(array);
    }

    public static void rellenarArrayAleatorio(int[] array, int min, int max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = generarNumeroAleatorio(min, max);
        }
    }

    public static void mostrarArrayYSuma(int[] array) {
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            JOptionPane.showMessageDialog(null, "�ndice " + i + ": " + array[i]);
            suma += array[i];
        }
        JOptionPane.showMessageDialog(null, "Suma total: " + suma);
    }

    // 10) Crea un array de n�meros de un tama�o pasado por teclado, el array contendr� n�meros aleatorios primos entre los n�meros deseados, por �ltimo nos indicar cual es el mayor de todos.
    //Haz un m�todo para comprobar que el n�mero aleatorio es primo, puedes hacer todos lo m�todos que necesites.

    public static void ejercicio10() {
        int tama�oArray = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tama�o del array:"));
        int[] array = generarArrayPrimos(tama�oArray);
        mostrarArray(array);//Aprovecho el codigo de la linea 244
        int maximo = encontrarMaximo(array);
        JOptionPane.showMessageDialog(null, "El n�mero primo m�s grande es: " + maximo);
    }

    public static int[] generarArrayPrimos(int tama�o) {
        int[] array = new int[tama�o];
        int contador = 0;
        int numero = 2;
        while (contador < tama�o) {
            if (esNumeroPrimo(numero)) {
                array[contador] = numero;
                contador++;
            }
            numero++;
        }
        return array;
    }

    public static int encontrarMaximo(int[] array) {
        int maximo = Integer.MIN_VALUE;
        for (int numero : array) {
            if (numero > maximo) {
                maximo = numero;
            }
        }
        return maximo;
    }

    // 11) Crea dos arrays de n�meros con la dimensi�n pasada por teclado.
    //Uno de ellos estar� rellenado con n�meros aleatorios y el otro apuntara al array anterior, reasigna los valores del segundo array con valores aleatorios.
    //Despu�s, crea un m�todo que tenga como par�metros, los dos arrays y devuelva uno nuevo con la multiplicaci�n de la posici�n O del array1 con el del array2 y as� sucesivamente.
    //Por �ltimo, muestra el contenido de cada array.

    public static void ejercicio11() {
        int tama�oArray = Integer.parseInt(JOptionPane.showInputDialog("Dime el tama�o de los arrays:"));
        int[] array1 = new int[tama�oArray];
        int[] array2 = new int[tama�oArray];
        rellenarArrayAleatorio(array1, 0, 100);//Aprovecho el codigo de la linea 260
        rellenarArrayAleatorio(array2, 0, 100);
        int[] resultado = multiplicarArrays(array1, array2);
        mostrarArray(array1);//Aprovecho el codigo de la linea 244
        mostrarArray(array2);
        mostrarArray(resultado);
    }

    public static int[] multiplicarArrays(int[] array1, int[] array2) {
        int[] resultado = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            resultado[i] = array1[i] * array2[i];
        }
        return resultado;
    }

    // 12) Crea un array de n�meros de un tama�o pasado por teclado, el array contendr� n�meros aleatorios entre 1 y 300 y mostrar� aquellos n�meros que acaben en un d�gito que nosotros le indiquemos por teclado (debes controlar que se introduce un numero correcto), estos deben guardarse en un nuevo array.
    public static void ejercicio12() {
        int tama�oArray = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tama�o del array:"));
        int[] array = new int[tama�oArray];
        rellenarArrayAleatorio(array, 1, 300);//Aprovecho el codigo de la linea 260
        int digito = Integer.parseInt(JOptionPane.showInputDialog("Introduce un d�gito (0-9):"));
        int[] numerosConDigito = encontrarNumerosConDigito(array, digito);
        mostrarArray(array);//Aprovecho el codigo de la linea 244
        mostrarArray(numerosConDigito);
    }

    public static int[] encontrarNumerosConDigito(int[] array, int digito) {
        int[] resultado = new int[array.length];
        int contador = 0;
        for (int numero : array) {
            if (numero % 10 == digito) {
                resultado[contador] = numero;
                contador++;
            }
        }
        int[] numerosFinales = new int[contador];
        System.arraycopy(resultado, 0, numerosFinales, 0, contador);
        return numerosFinales;
    }
}
