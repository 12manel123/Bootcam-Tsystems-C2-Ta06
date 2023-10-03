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
                	JOptionPane.showMessageDialog(null, "Adiós!");
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Introduce un número del 0 al 12.");
            }
        }
    }
    public static String mostrarMenu() {
        return JOptionPane.showInputDialog(
            "Elige un ejercicio (0 para salir):\n" +
            "1.- Calcular el área de una figura.\n" +
            "2.- Generar números enteros aleatorios.\n" +
            "3.- Comprobar si un número es primo.\n" +
            "4.- Calcular el factorial de un número.\n" +
            "5.- Numero decimal a binario.\n" +
            "6.- Contar numero de cifras en un número.\n" +
            "7.- Convertir euros a otras monedas.\n" +
            "8.- Rellenar y mostrar un array de 10 posiciones.\n" +
            "9.- Rellenar y mostrar un array aleatorio.\n" +
            "10.- Generar array de números primos y encontrar el mayor.\n" +
            "11.- Multiplicar elementos de dos arrays.\n" +
            "12.- Encontrar números que terminen en un dígito en un array."
        );
    }
    //1) Crea una aplicación que nos calcule el área de un circulo, cuadrado o triangulo. Pediremos que figura queremos calcular su área y según lo introducido pedirá los valores necesarios para calcular el área. Crea un método por cada figura para calcular cada área, este devolverá un número real. Muestra el resultado por pantalla.
    public static void ejercicio1() {
        String figura = JOptionPane.showInputDialog("Introduce la figura (circulo, triangulo, cuadrado):");
        double area = 0;
        switch (figura.toLowerCase()) {
            case "circulo":
                double radio = Double.parseDouble(JOptionPane.showInputDialog("Dime el radio del círculo:"));
                area = calcularAreaCirculo(radio);
                break;
            case "triangulo":
                double base = Double.parseDouble(JOptionPane.showInputDialog("Base de triángulo:"));
                double altura = Double.parseDouble(JOptionPane.showInputDialog("Altura de triángulo:"));
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

    //2) Crea una aplicación que nos genere una cantidad de números enteros aleatorios que nosotros le pasaremos por teclado. Crea un método donde pasamos como parámetros entre que números queremos que los genere, podemos pedirlas por teclado antes de generar los números. Este método devolverá un número entero aleatorio. Muestra estos números por pantalla.
    public static void ejercicio2() {
        int min = Integer.parseInt(JOptionPane.showInputDialog("Número mínimo:"));
        int max = Integer.parseInt(JOptionPane.showInputDialog("Número máximo:"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cuantos numeros quieres aleatorios:"));
        for (int i = 0; i < cantidad; i++) {
            int num = generarNumeroAleatorio(min, max);
            JOptionPane.showMessageDialog(null, "Número aleatorio: " + num);
        }
    }

    public static int generarNumeroAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    //3) Crea una aplicación que nos pida un número por teclado y con un método se lo pasamos por parámetro para que nos indique si es o no un número primo, debe devolver true si es primo sino false
    public static void ejercicio3() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Dime un número:"));
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

    //4) Crea una aplicación que nos calcule el factorial de un número pedido por teclado, lo realizara mediante un método al que le pasamos el número como parámetro. Para calcular el factorial, se multiplica los números anteriores hasta llegar a uno. 
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

    // 5) Crea una aplicación que nos convierta un número en base decimal a binario. Esto lo realizara un método al que le pasaremos el numero como parámetro, devolverá un String con el numero convertido a binario. Para convertir un numero decimal a binario, debemos dividir entre 2 el numero y el resultado de esa división se divide entre 2 de nuevo hasta que no se pueda dividir mas, el resto que obtengamos de cada división formara el numero binario, de abajo a arriba.
    public static void ejercicio5() {
        int numeroDecimal = Integer.parseInt(JOptionPane.showInputDialog("Dime un numero decimal:"));
        String numeroBinario = convertirDecimalABinario(numeroDecimal);
        JOptionPane.showMessageDialog(null, "El número binario es: " + numeroBinario);
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

    // 6) Crea una aplicación que nos cuente el número de cifras de un número entero positivo (hay que controlarlo) pedido por teclado. Crea un método que realice esta acción, pasando el número por parámetro, devolverá el número de cifras.
    public static void ejercicio6() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Dime un numero positivo:"));
        int cantidadCifras = contarCifras(numero);
        JOptionPane.showMessageDialog(null, "El número de cifras es: " + cantidadCifras);
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

    // 7) Crea un aplicación que nos convierta una cantidad de euros introducida por teclado a otra moneda, estas pueden ser a dolares, yenes o libras. El método tendrá como parámetros, la cantidad de euros y la moneda a pasar que sera una cadena, este no devolverá ningún valor, mostrara un mensaje indicando el cambio (void).
    public static void ejercicio7() {
        double cantidadEuros = Double.parseDouble(JOptionPane.showInputDialog("Cantidad de euros:"));
        String monedaDestino = JOptionPane.showInputDialog("Moneda de destino (libras, dólares, yenes):");
        convertirMoneda(cantidadEuros, monedaDestino);
    }

    public static void convertirMoneda(double cantidadEuros, String monedaDestino) {
        double tasaCambio = 0;

        switch (monedaDestino.toLowerCase()) {
            case "libras":
                tasaCambio = 0.86;
                break;
            case "dólares":
                tasaCambio = 1.28611;
                break;
            case "yenes":
                tasaCambio = 129.852;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Moneda no válida.");
                return;
        }

        double cantidadConvertida = cantidadEuros * tasaCambio;
        JOptionPane.showMessageDialog(null, cantidadEuros + " euros son " + cantidadConvertida + " " + monedaDestino);
    }

    // 8) Crea un array de 10 posiciones de números con valores pedidos por teclado. Muestra por consola el indice y el valor al que corresponde. Haz dos métodos, uno para rellenar valores y otro para mostrar.
    public static void ejercicio8() {
        int[] array = new int[10];
        rellenarArray(array);
        mostrarArray(array);
    }

    public static void rellenarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(JOptionPane.showInputDialog("Dime un número para la posición " + i + ":"));
        }
    }

    public static void mostrarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            JOptionPane.showMessageDialog(null, "Posicion: " + i + ". Valor: " + array[i]);
        }
    }

    // 9) Crea un array de números donde le indicamos por teclado el tamaño del array, rellenaremos el array con números aleatorios entre 0 y 9. Al final muestra por pantalla el valor de cada posición y la suma de todos los valores.
    //Tareas a realizar: Haz un método para rellenar el array(que tenga como parámetros los números entre los que tenga que generar) y otro para mostrar el contenido y la suma del array.

    public static void ejercicio9() {
        int tamañoArray = Integer.parseInt(JOptionPane.showInputDialog("Dime el tamaño del array:"));
        int[] array = new int[tamañoArray];
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
            JOptionPane.showMessageDialog(null, "Índice " + i + ": " + array[i]);
            suma += array[i];
        }
        JOptionPane.showMessageDialog(null, "Suma total: " + suma);
    }

    // 10) Crea un array de números de un tamaño pasado por teclado, el array contendrá números aleatorios primos entre los números deseados, por último nos indicar cual es el mayor de todos.
    //Haz un método para comprobar que el número aleatorio es primo, puedes hacer todos lo métodos que necesites.

    public static void ejercicio10() {
        int tamañoArray = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño del array:"));
        int[] array = generarArrayPrimos(tamañoArray);
        mostrarArray(array);//Aprovecho el codigo de la linea 244
        int maximo = encontrarMaximo(array);
        JOptionPane.showMessageDialog(null, "El número primo más grande es: " + maximo);
    }

    public static int[] generarArrayPrimos(int tamaño) {
        int[] array = new int[tamaño];
        int contador = 0;
        int numero = 2;
        while (contador < tamaño) {
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

    // 11) Crea dos arrays de números con la dimensión pasada por teclado.
    //Uno de ellos estará rellenado con números aleatorios y el otro apuntara al array anterior, reasigna los valores del segundo array con valores aleatorios.
    //Después, crea un método que tenga como parámetros, los dos arrays y devuelva uno nuevo con la multiplicación de la posición O del array1 con el del array2 y así sucesivamente.
    //Por último, muestra el contenido de cada array.

    public static void ejercicio11() {
        int tamañoArray = Integer.parseInt(JOptionPane.showInputDialog("Dime el tamaño de los arrays:"));
        int[] array1 = new int[tamañoArray];
        int[] array2 = new int[tamañoArray];
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

    // 12) Crea un array de números de un tamaño pasado por teclado, el array contendrá números aleatorios entre 1 y 300 y mostrará aquellos números que acaben en un dígito que nosotros le indiquemos por teclado (debes controlar que se introduce un numero correcto), estos deben guardarse en un nuevo array.
    public static void ejercicio12() {
        int tamañoArray = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño del array:"));
        int[] array = new int[tamañoArray];
        rellenarArrayAleatorio(array, 1, 300);//Aprovecho el codigo de la linea 260
        int digito = Integer.parseInt(JOptionPane.showInputDialog("Introduce un dígito (0-9):"));
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
